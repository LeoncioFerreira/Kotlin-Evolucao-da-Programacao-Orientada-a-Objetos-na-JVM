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

// Mock da calculadora atualizado com o enum real
class CalculadoraMock : CalculadoraAcademica {
    override fun calcularMedia(notas: List<Nota>): Double = notas.map { it.valor }.average()

    override fun determinarSituacao(media: Double): SituacaoAcademica =
        when {
            media >= 7.0 -> SituacaoAcademica.APROVADO
            media >= 5.0 -> SituacaoAcademica.RECUPERACAO
            else -> SituacaoAcademica.REPROVADO
        }
}

class ServicosAcademicosTest {

    private lateinit var alunoRepo: AlunoRepositoryEmMemoria
    private lateinit var avaliacaoRepo: AvaliacaoRepositoryEmMemoria
    private lateinit var cadastroService: CadastroAlunoService
    private lateinit var avaliacaoService: AvaliacaoService

    @BeforeEach
    fun setup() {
        alunoRepo = AlunoRepositoryEmMemoria()
        avaliacaoRepo = AvaliacaoRepositoryEmMemoria()
        cadastroService = CadastroAlunoService(alunoRepo)
        avaliacaoService = AvaliacaoService(alunoRepo, avaliacaoRepo)

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
}