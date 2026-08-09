/**
 * Descrição: Representa e valida uma nota acadêmica entre zero e dez
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

@JvmInline
value class Nota(
    val valor: Double,
) {
    init {
        require(valor in 0.0..10.0) {
            "A nota deve estar entre 0 e 10."
        }
    }
}
