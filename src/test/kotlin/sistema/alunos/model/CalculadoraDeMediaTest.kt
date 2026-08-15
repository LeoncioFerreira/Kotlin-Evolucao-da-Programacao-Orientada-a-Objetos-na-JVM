/**
 * Descrição: Verifica o cálculo da média e a classificação da situação acadêmica nos casos de aprovação, recuperação e reprovação
 * Autor: André Wesley
 */
package sistema.alunos.model

import sistema.alunos.service.CalculadoraAcademica
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculadoraDeMediaTest {

    @Test
    fun `deve calcular media aritmetica de duas notas`() {
        val calculadora: CalculadoraAcademica = CalculadoraDeMedia(Nota(6.0), Nota(8.0))

        assertEquals(7.0, calculadora.calcularMedia())
    }

    @Test
    fun `deve mostrar que o aluno foi aprovado`() {
        val nota = Nota(valor = 8.0)
        val nota2 = Nota (valor = 8.5)
        val calculadora = CalculadoraDeMedia(nota, nota2)
        assertEquals(
            SituacaoAcademica.APROVADO,
            calculadora.determinarSituacao()

        )
    }

    @Test
    fun `deve mostrar que o aluno ficou de recuperacao`() {
        val nota = Nota(valor = 4.0)
        val nota2 = Nota(valor = 5.0)
        val calculadora = CalculadoraDeMedia(nota, nota2)
        assertEquals(
            SituacaoAcademica.RECUPERACAO,
            calculadora.determinarSituacao()
        )
    }

    @Test
    fun `deve mostrar que o aluno foi reprovado`() {
        val nota = Nota(valor = 4.0)
        val nota2 = Nota(valor = 3.0)
        val calculadora = CalculadoraDeMedia(nota, nota2)
        assertEquals(
            SituacaoAcademica.REPROVADO,
            calculadora.determinarSituacao()
        )
    }

    @Test
    fun `deve mostrar que o aluno foi aprovado com media exatamente 7` () {
        val nota = Nota(valor = 7.0)
        val nota2 = Nota(valor = 7.0)
        val calculadora = CalculadoraDeMedia(nota, nota2)
        assertEquals(
             SituacaoAcademica.APROVADO,
            calculadora.determinarSituacao()
        )
    }

    @Test
    fun `deve mostrar que o aluno ficou de recuperacao com media exatamente 4` () {
        val nota = Nota(valor = 4.0)
        val nota2 = Nota(valor = 4.0)
        val calculadora = CalculadoraDeMedia(nota, nota2)
        assertEquals(
            SituacaoAcademica.RECUPERACAO,
            calculadora.determinarSituacao()
        )
    }
}
