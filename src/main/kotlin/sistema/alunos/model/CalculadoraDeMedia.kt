/**
 * Descrição: Calcula a média aritmética entre duas notas e determina a situação acadêmica do aluno
 * Autor: André Wesley
 */
package sistema.alunos.model

import sistema.alunos.service.CalculadoraAcademica

class CalculadoraDeMedia(
    val nota: Nota,
    val nota2: Nota,
) : CalculadoraAcademica {
    companion object {
        const val MEDIA_APROVACAO = 7.0
        const val MEDIA_RECUPERACAO = 4.0
    }
    override fun calcularMedia(): Double =
        (nota.valor + nota2.valor) / 2

    override fun determinarSituacao(): SituacaoAcademica =
        when {
            calcularMedia() >= MEDIA_APROVACAO -> SituacaoAcademica.APROVADO
            calcularMedia() >= MEDIA_RECUPERACAO -> SituacaoAcademica.RECUPERACAO
            else -> SituacaoAcademica.REPROVADO
        }
}
