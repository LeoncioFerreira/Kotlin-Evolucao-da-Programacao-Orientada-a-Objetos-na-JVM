/**
 * Descrição: Serviço para registro e validação de avaliações.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.model.Avaliacao
import sistema.alunos.model.Disciplina
import sistema.alunos.model.Nota
import sistema.alunos.repository.AlunoRepository
import sistema.alunos.repository.AvaliacaoRepository

class AvaliacaoService(
    private val alunoRepository: AlunoRepository,
    private val avaliacaoRepository: AvaliacaoRepository
) {
    fun registrarAvaliacao(idAluno: String, disciplina: Disciplina, notas: List<Nota>): Avaliacao {
        val aluno = alunoRepository.buscarPorId(idAluno)
            ?: throw AlunoNaoEncontradoException(idAluno)

        val avaliacoesDoAluno = avaliacaoRepository.buscarPorIdAluno(idAluno)
        val jaAvaliado = avaliacoesDoAluno.any { it.disciplina.codigo == disciplina.codigo }

        if (jaAvaliado) {
            throw IllegalStateException("O aluno ja possui avaliacao para a disciplina ${disciplina.nome}.")
        }

        // A classe Avaliacao já valida se a lista contém exatamente duas notas no bloco init
        val novaAvaliacao = Avaliacao(aluno, disciplina, notas)
        avaliacaoRepository.salvar(novaAvaliacao)

        return novaAvaliacao
    }
}