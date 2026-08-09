/**
 * Descrição: Executa exemplos temporários dos tipos fundamentais do sistema acadêmico
 * Autor: Leôncio Ferreira
 */
package sistema.alunos

import sistema.alunos.model.Aluno
import sistema.alunos.model.Nota
import sistema.alunos.model.SituacaoAcademica

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
}
