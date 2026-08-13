/**
 * Descrição: Calcula a média aritmética entre duas notas e determina a situação acadêmica do aluno
 * Autor: André Wesley
 */
package sistema.alunos.model

class CalculadoraDeMedia(
    val nota: Nota,
    val nota2: Nota,
) {
    companion object {
        const val MEDIA_APROVACAO = 7.0
        const val MEDIA_RECUPERACAO = 4.0
    }
    fun calcularMedia (): Double {
        return (nota.valor + nota2.valor) / 2
    }

    fun determinarSituacao(): SituacaoAcademica {
        val media = calcularMedia()
        if (media >= MEDIA_APROVACAO){
            return SituacaoAcademica.APROVADO
        }else if (media >= MEDIA_RECUPERACAO){
            return SituacaoAcademica.RECUPERACAO
        }else{
            return SituacaoAcademica.REPROVADO
        }
    }
}