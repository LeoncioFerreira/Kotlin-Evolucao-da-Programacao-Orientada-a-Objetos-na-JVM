/**
 * Descrição: Verifica a criação e as validações de avaliações
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AvaliacaoTest {
    val aluno = Aluno(id = "A01", nome = "Leôncio Ferreira")
    val disciplina = Disciplina(
        codigo = "ES0012",
        nome = "Paradigmas de Programação",
    )

    @Test
    fun `deve criar avaliacao com exatamente duas notas`() {
        val avaliacao = Avaliacao(
            aluno = aluno,
            disciplina = disciplina,
            notas = listOf(Nota(7.3), Nota(10.0)),
        )

        assertEquals(aluno, avaliacao.aluno)
        assertEquals(disciplina, avaliacao.disciplina)
        assertEquals(listOf(Nota(7.3), Nota(10.0)), avaliacao.notas)
    }

    @Test
    fun `deve rejeitar avaliacao sem notas`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Avaliacao(aluno, disciplina, emptyList())
        }

        assertEquals("A avaliação deve possuir exatamente duas notas.", erro.message)
    }

    @Test
    fun `deve rejeitar avaliacao com somente uma nota`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Avaliacao(aluno, disciplina, listOf(Nota(7.3)))
        }

        assertEquals("A avaliação deve possuir exatamente duas notas.", erro.message)
    }

    @Test
    fun `deve rejeitar avaliacao com mais de duas notas`() {
        val erro = assertFailsWith<IllegalArgumentException> {
            Avaliacao(
                aluno,
                disciplina,
                notas = listOf(Nota(7.3), Nota(10.0), Nota(10.0)),
            )
        }

        assertEquals("A avaliação deve possuir exatamente duas notas.", erro.message)
    }
}
