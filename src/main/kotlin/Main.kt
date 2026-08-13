/**
 * Descrição: Executa exemplos temporários dos tipos fundamentais do sistema acadêmico
 * Autor: Leôncio Ferreira
 */
package sistema.alunos

import sistema.alunos.model.Aluno
import sistema.alunos.model.CalculadoraDeMedia
import sistema.alunos.model.Nota
import sistema.alunos.model.SituacaoAcademica
import sistema.alunos.repository.AlunoRepositoryEmMemoria
import sistema.alunos.service.AlunoJaCadastradoException
import sistema.alunos.service.AlunoNaoEncontradoException
import sistema.alunos.service.CadastroAlunoService

fun main() {
    val aluno = Aluno(
        id = "A01",
        nome = "Leôncio Ferreira",
    )

    val nota = Nota(10.0)

    val situacao = SituacaoAcademica.APROVADO

    println(aluno)
    println("ID: ${aluno.id}")
    println("Nome: ${aluno.nome}")
    println("Nota: ${nota.valor}")
    println("Situação academica: ${situacao}")

    println()
    println("--- Cadastro de alunos (repositório em memória) ---")

    val repositorio = AlunoRepositoryEmMemoria()
    val servico = CadastroAlunoService(repositorio)

    servico.cadastrar(id = "A01", nome = "Maria Souza")
    servico.cadastrar(id = "A02", nome = "João Pedro")

    println("Alunos cadastrados: ${servico.listarAlunos()}")
    println("Busca por A01: ${servico.buscarPorId("A01")}")

    try {
        servico.cadastrar(id = "A01", nome = "Outro Nome")
    } catch (erro: AlunoJaCadastradoException) {
        println("Erro esperado: ${erro.message}")
    }

    try {
        servico.buscarPorId("INEXISTENTE")
    } catch (erro: AlunoNaoEncontradoException) {
        println("Erro esperado: ${erro.message}")
    }
}