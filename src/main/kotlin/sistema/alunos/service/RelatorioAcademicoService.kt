/**
 * Descrição: Serviço para geração de relatórios acadêmicos individuais.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.repository.AlunoRepository
import sistema.alunos.repository.AvaliacaoRepository

class RelatorioAcademicoService(
    private val alunoRepository: AlunoRepository,
    private val avaliacaoRepository: AvaliacaoRepository,
    private val calculadora: CalculadoraAcademica
) {
    fun gerarRelatorio(idAluno: String): RelatorioAcademico {
        val aluno = alunoRepository.buscarPorId(idAluno)
            ?: throw AlunoNaoEncontradoException(idAluno)

        val avaliacoes = avaliacaoRepository.buscarPorIdAluno(idAluno)
        if (avaliacoes.isEmpty()) {
            throw IllegalStateException("Ausência de avaliações para o aluno.")
        }

        // map transformando dados puros em DTOs
        val itens = avaliacoes.map { avaliacao ->
            val mediaDisciplina = calculadora.calcularMedia(avaliacao.notas)
            val situacao = calculadora.determinarSituacao(mediaDisciplina)

            ItemRelatorio(
                nomeDisciplina = avaliacao.disciplina.nome,
                media = mediaDisciplina,
                situacao = situacao.name
            )
        }

        return RelatorioAcademico(aluno.nome, itens, avaliacoes.calcularMediaGeral(calculadora))
    }
}

data class RelatorioAcademico(val nomeAluno: String, val disciplinas: List<ItemRelatorio>, val mediaGeral: Double)
data class ItemRelatorio(val nomeDisciplina: String, val media: Double, val situacao: String)