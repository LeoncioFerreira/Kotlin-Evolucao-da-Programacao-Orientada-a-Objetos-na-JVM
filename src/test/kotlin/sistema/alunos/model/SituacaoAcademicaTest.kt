/**
 * Descrição: Verifica os valores disponíveis para a situação acadêmica
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

import kotlin.test.Test
import kotlin.test.assertEquals

class SituacaoAcademicaTest {

    @Test
    fun `deve possuir as tres situacoes academicas`() {
        val situacoes = SituacaoAcademica.entries

        assertEquals(3, situacoes.size)

        assertEquals(
            SituacaoAcademica.APROVADO,
            situacoes[0],
        )

        assertEquals(
            SituacaoAcademica.RECUPERACAO,
            situacoes[1],
        )
        assertEquals(
            SituacaoAcademica.REPROVADO,
            situacoes[2],
        )
    }
}
