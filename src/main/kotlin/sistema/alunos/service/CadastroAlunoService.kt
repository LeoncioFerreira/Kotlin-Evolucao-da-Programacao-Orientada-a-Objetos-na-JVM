/**
 * Descrição: Coordena o cadastro de alunos, validando dados e impedindo duplicidade
 * Autor: Pedro Kauan Cardoso da Silva
 */
package sistema.alunos.service

import sistema.alunos.model.Aluno
import sistema.alunos.repository.AlunoRepository

/**
 * Descrição: Sinaliza a tentativa de cadastrar um aluno com identificador já existente
 * Autor: Pedro Kauan Cardoso da Silva
 */
class AlunoJaCadastradoException(id: String) :
    RuntimeException("Ja existe um aluno cadastrado com o identificador '$id'.")

/**
 * Descrição: Sinaliza que nenhum aluno foi encontrado para o identificador informado
 * Autor: Pedro Kauan Cardoso da Silva
 */
class AlunoNaoEncontradoException(id: String) :
    RuntimeException("Nenhum aluno encontrado com o identificador '$id'.")

class CadastroAlunoService(
    private val repositorio: AlunoRepository,
) {

    fun cadastrar(id: String, nome: String): Aluno {
        val aluno = Aluno(id = id, nome = nome)

        if (repositorio.buscarPorId(aluno.id) != null) {
            throw AlunoJaCadastradoException(aluno.id)
        }

        repositorio.salvar(aluno)
        return aluno
    }

    fun buscarPorId(id: String): Aluno {
        return repositorio.buscarPorId(id) ?: throw AlunoNaoEncontradoException(id)
    }

    fun listarAlunos(): List<Aluno> {
        return repositorio.listar()
    }
}