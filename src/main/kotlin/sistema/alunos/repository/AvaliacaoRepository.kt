/**
 * Descrição: Contrato para armazenamento e consulta de avaliações.
 * Autor: Salomão
 */
package sistema.alunos.repository

import sistema.alunos.model.Avaliacao

interface AvaliacaoRepository {
    fun salvar(avaliacao: Avaliacao)
    fun buscarPorIdAluno(idAluno: String): List<Avaliacao>
    fun listarTodas(): List<Avaliacao>
}