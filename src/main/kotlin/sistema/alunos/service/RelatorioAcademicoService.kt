/**
 * Descrição: Serviço para geração de relatórios acadêmicos individuais.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.model.CalculadoraDeMedia
import sistema.alunos.model.Nota
import sistema.alunos.repository.AlunoRepository
import sistema.alunos.repository.AvaliacaoRepository

class RelatorioAcademicoService(
    private val alunoRepository: AlunoRepository,
    private val avaliacaoRepository: AvaliacaoRepository
) {
    fun gerarRelatorio(idAluno: String): RelatorioAcademico {
        val aluno = alunoRepository.buscarPorId(idAluno)
            ?: throw AlunoNaoEncontradoException(idAluno)

        val avaliacoes = avaliacaoRepository.buscarPorIdAluno(idAluno)
        if (avaliacoes.isEmpty()) {
            throw IllegalStateException("Ausência de avaliações para o aluno.")
        }

        val itens = avaliacoes.map { avaliacao ->
            // Instancia a calculadora com as duas notas da avaliação atual
            val calculadora = CalculadoraDeMedia(avaliacao.notas[0], avaliacao.notas[1])
            val mediaDisciplina = calculadora.calcularMedia()
            val situacao = calculadora.determinarSituacao()

            ItemRelatorio(
                nomeDisciplina = avaliacao.disciplina.nome,
                notas = avaliacao.notas.toList(),
                media = mediaDisciplina,
                situacao = situacao.name
            )
        }

        return RelatorioAcademico(aluno.nome, itens, avaliacoes.calcularMediaGeral())
    }
}

data class RelatorioAcademico(val nomeAluno: String, val disciplinas: List<ItemRelatorio>, val mediaGeral: Double)
data class ItemRelatorio(
    val nomeDisciplina: String,
    val notas: List<Nota>,
    val media: Double,
    val situacao: String,
)
