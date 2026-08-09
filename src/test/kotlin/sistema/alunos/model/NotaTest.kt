/**
 * Descrição: Verifica os limites e as validações de notas acadêmicas
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NotaTest {
    @Test
    fun `deve aceitar nota zero`() {
        val nota = Nota(0.0)

        assertEquals(0.0, nota.valor)
    }

    @Test
    fun `deve aceitar nota dez`() {
        val nota = Nota(10.0)

        assertEquals(10.0, nota.valor)
    }

    @Test
    fun `deve aceitar nota decimal`() {
        val nota = Nota(7.5)

        assertEquals(7.5, nota.valor)
    }

    @Test
    fun `deve rejeitar nota negativa`() {
        assertFailsWith<IllegalArgumentException> {
            Nota(-0.1)
        }
    }

    @Test
    fun `deve rejeitar nota maior que dez`() {
        assertFailsWith<IllegalArgumentException> {
            Nota(11.0)
        }
    }

}
