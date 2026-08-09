/**
 * Descrição: Define o contrato de armazenamento e consulta de alunos
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.repository

import sistema.alunos.model.Aluno

interface AlunoRepository {

    fun salvar(aluno: Aluno)

    fun buscarPorId(id: String): Aluno?

    fun listar(): List<Aluno>
}
