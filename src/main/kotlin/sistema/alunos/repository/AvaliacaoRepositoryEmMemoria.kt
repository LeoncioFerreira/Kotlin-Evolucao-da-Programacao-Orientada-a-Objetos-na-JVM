/**
 * Descrição: Armazenamento em memória das avaliações.
 * Autor: Salomão
 */
package sistema.alunos.repository

import sistema.alunos.model.Avaliacao

class AvaliacaoRepositoryEmMemoria : AvaliacaoRepository {
    private val avaliacoes = mutableListOf<Avaliacao>()

    override fun salvar(avaliacao: Avaliacao) {
        avaliacoes.add(avaliacao)
    }

    override fun buscarPorIdAluno(idAluno: String): List<Avaliacao> {
        return avaliacoes.filter { it.aluno.id == idAluno }
    }

    override fun listarTodas(): List<Avaliacao> {
        return avaliacoes.toList()
    }
}