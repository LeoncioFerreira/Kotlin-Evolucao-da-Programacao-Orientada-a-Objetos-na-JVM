/**
 * Descrição: Testes unitários para os serviços acadêmicos.
 * Autor: Salomão
 */
package sistema.alunos.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import sistema.alunos.model.*
import sistema.alunos.repository.AlunoRepositoryEmMemoria
import sistema.alunos.repository.AvaliacaoRepositoryEmMemoria

class ServicosAcademicosTest {

    private lateinit var alunoRepo: AlunoRepositoryEmMemoria
    private lateinit var avaliacaoRepo: AvaliacaoRepositoryEmMemoria
    private lateinit var cadastroService: CadastroAlunoService
    private lateinit var avaliacaoService: AvaliacaoService
    private lateinit var relatorioService: RelatorioAcademicoService
    private lateinit var estatisticaService: EstatisticaTurmaService

    @BeforeEach
    fun setup() {
        alunoRepo = AlunoRepositoryEmMemoria()
        avaliacaoRepo = AvaliacaoRepositoryEmMemoria()
        cadastroService = CadastroAlunoService(alunoRepo)
        avaliacaoService = AvaliacaoService(alunoRepo, avaliacaoRepo)
        relatorioService = RelatorioAcademicoService(alunoRepo, avaliacaoRepo)
        estatisticaService = EstatisticaTurmaService(alunoRepo, avaliacaoRepo)

        cadastroService.cadastrar("A01", "Salomão")
    }

    @Test
    fun `deve registrar avaliacao com sucesso com exatamente duas notas`() {
        val disciplina = Disciplina("MAT01", "Matemática")
        // Utilizando a value class real
        val notas = listOf(Nota(8.0), Nota(9.0))

        val avaliacao = avaliacaoService.registrarAvaliacao("A01", disciplina, notas)

        assertNotNull(avaliacao)
        assertEquals(2, avaliacao.notas.size)
        assertEquals(8.0, avaliacao.notas[0].valor)
    }

    @Test
    fun `deve impedir segunda avaliacao da mesma disciplina para o mesmo aluno`() {
        val disciplina = Disciplina("MAT01", "Matemática")
        val notas = listOf(Nota(8.0), Nota(9.0))

        avaliacaoService.registrarAvaliacao("A01", disciplina, notas)

        val exception = assertThrows<IllegalStateException> {
            avaliacaoService.registrarAvaliacao("A01", disciplina, notas)
        }
        assertTrue(exception.message!!.contains("O aluno já possui avaliação"))
    }

    @Test
    fun `deve lancar excecao se aluno nao existir no momento da avaliacao`() {
        val disciplina = Disciplina("MAT01", "Matemática")
        val notas = listOf(Nota(8.0), Nota(9.0))

        assertThrows<AlunoNaoEncontradoException> {
            avaliacaoService.registrarAvaliacao("INEXISTENTE", disciplina, notas)
        }
    }

    @Test
    fun `deve impedir instanciacao de nota fora do limite permitido`() {
        val exceptionMaior = assertThrows<IllegalArgumentException> {
            Nota(11.0)
        }
        assertEquals("A nota deve estar entre 0 e 10.", exceptionMaior.message)

        val exceptionMenor = assertThrows<IllegalArgumentException> {
            Nota(-1.0)
        }
        assertEquals("A nota deve estar entre 0 e 10.", exceptionMenor.message)
    }

    @Test
    fun `deve gerar relatorio com disciplina notas media e situacao`() {
        avaliacaoService.registrarAvaliacao(
            "A01",
            Disciplina("MAT01", "Matemática"),
            listOf(Nota(8.0), Nota(6.0)),
        )

        val relatorio = relatorioService.gerarRelatorio("A01")

        assertEquals("Salomão", relatorio.nomeAluno)
        assertEquals(7.0, relatorio.mediaGeral)
        assertEquals(1, relatorio.disciplinas.size)
        assertEquals("Matemática", relatorio.disciplinas.single().nomeDisciplina)
        assertEquals(listOf(Nota(8.0), Nota(6.0)), relatorio.disciplinas.single().notas)
        assertEquals(7.0, relatorio.disciplinas.single().media)
        assertEquals("APROVADO", relatorio.disciplinas.single().situacao)
    }

    @Test
    fun `deve calcular media geral do relatorio com mais de uma disciplina`() {
        avaliacaoService.registrarAvaliacao(
            "A01",
            Disciplina("MAT01", "Matemática"),
            listOf(Nota(8.0), Nota(6.0)),
        )
        avaliacaoService.registrarAvaliacao(
            "A01",
            Disciplina("POR01", "Português"),
            listOf(Nota(4.0), Nota(6.0)),
        )

        val relatorio = relatorioService.gerarRelatorio("A01")

        assertEquals(6.0, relatorio.mediaGeral)
        assertEquals(listOf("APROVADO", "RECUPERACAO"), relatorio.disciplinas.map { it.situacao })
    }

    @Test
    fun `deve rejeitar relatorio de aluno inexistente`() {
        assertThrows<AlunoNaoEncontradoException> {
            relatorioService.gerarRelatorio("INEXISTENTE")
        }
    }

    @Test
    fun `deve informar ausencia de avaliacoes no relatorio`() {
        val exception = assertThrows<IllegalStateException> {
            relatorioService.gerarRelatorio("A01")
        }

        assertEquals("Ausência de avaliações para o aluno.", exception.message)
    }

    @Test
    fun `deve calcular media da turma e agrupar alunos por situacao`() {
        cadastroService.cadastrar("A02", "Maria")
        cadastroService.cadastrar("A03", "João")
        avaliacaoService.registrarAvaliacao(
            "A01",
            Disciplina("MAT01", "Matemática"),
            listOf(Nota(8.0), Nota(8.0)),
        )
        avaliacaoService.registrarAvaliacao(
            "A02",
            Disciplina("MAT01", "Matemática"),
            listOf(Nota(5.0), Nota(5.0)),
        )
        avaliacaoService.registrarAvaliacao(
            "A03",
            Disciplina("MAT01", "Matemática"),
            listOf(Nota(2.0), Nota(2.0)),
        )

        val estatisticas = estatisticaService.calcularEstatisticas()

        assertEquals(5.0, estatisticas.mediaGeralTurma)
        assertEquals(listOf("A01"), estatisticas.alunosPorSituacao.getValue("APROVADO").map { it.id })
        assertEquals(listOf("A02"), estatisticas.alunosPorSituacao.getValue("RECUPERACAO").map { it.id })
        assertEquals(listOf("A03"), estatisticas.alunosPorSituacao.getValue("REPROVADO").map { it.id })
    }

    @Test
    fun `deve ignorar alunos sem avaliacao nas estatisticas`() {
        cadastroService.cadastrar("A02", "Maria")
        avaliacaoService.registrarAvaliacao(
            "A01",
            Disciplina("MAT01", "Matemática"),
            listOf(Nota(8.0), Nota(8.0)),
        )

        val estatisticas = estatisticaService.calcularEstatisticas()

        assertEquals(8.0, estatisticas.mediaGeralTurma)
        assertEquals(listOf("A01"), estatisticas.alunosPorSituacao.getValue("APROVADO").map { it.id })
    }

    @Test
    fun `deve retornar estatisticas vazias quando nao houver avaliacoes`() {
        val estatisticas = estatisticaService.calcularEstatisticas()

        assertEquals(0.0, estatisticas.mediaGeralTurma)
        assertTrue(estatisticas.alunosPorSituacao.isEmpty())
    }
}
