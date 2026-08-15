/**
 * Descrição: Verifica a criação e as validações de disciplinas
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DisciplinaTest {
    @Test
    fun `deve criar disciplina com dados validos`() {
        val disciplina = Disciplina(
            codigo = "ES0012",
            nome = "Paradigmas de Programação",
        )

        assertEquals("ES0012", disciplina.codigo)
        assertEquals("Paradigmas de Programação", disciplina.nome)
    }

    @Test
    fun `deve rejeitar codigo vazio`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Disciplina(codigo = "", nome = "Paradigmas de Programação")
        }

        assertEquals("O codigo da disciplina nao pode estar vazio.", erro.message)
    }

    @Test
    fun `deve rejeitar codigo somente com espacos`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Disciplina(codigo = "   ", nome = "Paradigmas de Programação")
        }

        assertEquals("O codigo da disciplina nao pode estar vazio.", erro.message)
    }

    @Test
    fun `deve rejeitar nome vazio`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Disciplina(codigo = "ES0012", nome = "")
        }

        assertEquals("O nome da disciplina nao pode estar vazio.", erro.message)
    }

    @Test
    fun `deve rejeitar nome somente com espacos`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Disciplina(codigo = "ES0012", nome = "   ")
        }

        assertEquals("O nome da disciplina nao pode estar vazio.", erro.message)
    }
}
