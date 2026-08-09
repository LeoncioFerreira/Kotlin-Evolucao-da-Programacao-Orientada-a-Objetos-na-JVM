/**
 * Descrição: Verifica a criação e as validações de alunos
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AlunoTest {

    @Test
    fun `deve criar aluno com dados validos`() {
        val aluno = Aluno(
            id = "A01",
            nome = "Leôncio Ferreira",
        )

        assertEquals("A01", aluno.id)
        assertEquals("Leôncio Ferreira", aluno.nome)
    }

    @Test
    fun `deve rejeitar identificador vazio`() {
        assertFailsWith<IllegalArgumentException> {
            Aluno(
                id = "",
                nome = "Leôncio Ferreira",
            )
        }
    }

    @Test
    fun `deve rejeitar identificador somente com espacos`() {
        assertFailsWith<IllegalArgumentException> {
            Aluno(
                id = "   ",
                nome = "Leôncio Ferreira",
            )
        }
    }

    @Test
    fun `deve rejeitar nome vazio`() {
        assertFailsWith<IllegalArgumentException> {
            Aluno(
                id = "A01",
                nome = "",
            )
        }
    }

    @Test
    fun `deve rejeitar nome somente com espacos`() {
        assertFailsWith<IllegalArgumentException> {
            Aluno(
                id = "A01",
                nome = "   ",
            )
        }
    }
}
