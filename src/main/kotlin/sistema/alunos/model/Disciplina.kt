/**
 * Descrição: Representa uma disciplina e valida seus dados fundamentais
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

data class Disciplina(
    val codigo: String,
    val nome: String,
) {
    init {
        require(codigo.isNotBlank()) {
            "O codigo da disciplina nao pode estar vazio."
        }
        require(nome.isNotBlank()) {
            "O nome da disciplina nao pode estar vazio."
        }
    }
}
