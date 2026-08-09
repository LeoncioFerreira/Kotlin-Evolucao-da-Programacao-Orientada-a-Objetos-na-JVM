/**
 * Descrição: Representa um aluno e valida seus dados fundamentais
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

data class Aluno(
    val id: String,
    val nome: String,
) {
    init {
        require(id.isNotBlank()) {
            "O identificador do aluno não pode estar vazio."
        }
        require(nome.isNotBlank()) {
            "O nome do aluno não pode estar vazio."
        }
    }
}
