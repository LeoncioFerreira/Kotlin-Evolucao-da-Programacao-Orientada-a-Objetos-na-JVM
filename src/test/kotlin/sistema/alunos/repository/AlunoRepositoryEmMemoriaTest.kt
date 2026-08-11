/**
 * Descrição: Verifica o armazenamento, a busca, a listagem e o isolamento da coleção interna
 * Autor: Pedro Kauan Cardoso da Silva
 */
package sistema.alunos.repository

import sistema.alunos.model.Aluno
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class AlunoRepositoryEmMemoriaTest {

    @Test
    fun `deve salvar e buscar aluno pelo identificador`() {
        val repositorio = AlunoRepositoryEmMemoria()
        val aluno = Aluno(id = "A01", nome = "Maria Souza")

        repositorio.salvar(aluno)

        assertEquals(aluno, repositorio.buscarPorId("A01"))
    }

    @Test
    fun `deve retornar nulo ao buscar aluno inexistente`() {
        val repositorio = AlunoRepositoryEmMemoria()

        assertNull(repositorio.buscarPorId("INEXISTENTE"))
    }

    @Test
    fun `deve listar todos os alunos salvos`() {
        val repositorio = AlunoRepositoryEmMemoria()
        val aluno1 = Aluno(id = "A01", nome = "Maria Souza")
        val aluno2 = Aluno(id = "A02", nome = "João Pedro")

        repositorio.salvar(aluno1)
        repositorio.salvar(aluno2)

        val alunos = repositorio.listar()

        assertEquals(2, alunos.size)
        assertTrue(alunos.containsAll(listOf(aluno1, aluno2)))
    }

    @Test
    fun `deve substituir aluno ao salvar o mesmo identificador novamente`() {
        val repositorio = AlunoRepositoryEmMemoria()

        repositorio.salvar(Aluno(id = "A01", nome = "Nome Antigo"))
        repositorio.salvar(Aluno(id = "A01", nome = "Nome Atualizado"))

        assertEquals(1, repositorio.listar().size)
        assertEquals("Nome Atualizado", repositorio.buscarPorId("A01")?.nome)
    }

    @Test
    fun `lista retornada por listar deve ser independente da colecao interna`() {
        val repositorio = AlunoRepositoryEmMemoria()
        repositorio.salvar(Aluno(id = "A01", nome = "Maria Souza"))

        val primeiraLista = repositorio.listar()
        repositorio.salvar(Aluno(id = "A02", nome = "João Pedro"))

        assertEquals(1, primeiraLista.size)
        assertEquals(2, repositorio.listar().size)
    }
}