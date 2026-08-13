/**
 * Descrição: Implementa o armazenamento de alunos em memória, sem banco de dados ou arquivos
 * Autor: Pedro Kauan Cardoso da Silva
 */
package sistema.alunos.repository

import sistema.alunos.model.Aluno

class AlunoRepositoryEmMemoria : AlunoRepository {

    private val alunos: MutableMap<String, Aluno> = mutableMapOf()

    override fun salvar(aluno: Aluno) {
        alunos[aluno.id] = aluno
    }

    override fun buscarPorId(id: String): Aluno? {
        return alunos[id]
    }

    override fun listar(): List<Aluno> {
        return alunos.values.toList()
    }
}