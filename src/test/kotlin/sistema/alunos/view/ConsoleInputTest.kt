package sistema.alunos.view

import kotlin.test.*
import java.io.*

class ConsoleInputTest {

    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out

    @AfterTest
    fun restoreStreams() {
        System.setIn(originalIn)
        System.setOut(originalOut)
    }

    @Test
    fun `deve ler inteiro valido`() {
        val inputSimulado = "42\n"
        System.setIn(ByteArrayInputStream(inputSimulado.toByteArray()))
        val consoleInput = ConsoleInput()

        val resultado = consoleInput.lerInteiro("Digite um número: ")
        assertEquals(42, resultado)
    }

    @Test
    fun `deve rejeitar entrada vazia e pedir novamente`() {
        val inputSimulado = "\n10\n"
        System.setIn(ByteArrayInputStream(inputSimulado.toByteArray()))
        val consoleInput = ConsoleInput()

        val resultado = consoleInput.lerInteiro("Digite um número: ")
        assertEquals(10, resultado)
    }

    @Test
    fun `deve ler decimal com virgula`() {
        val inputSimulado = "3,14\n"
        System.setIn(ByteArrayInputStream(inputSimulado.toByteArray()))
        val consoleInput = ConsoleInput()

        val resultado = consoleInput.lerDecimal("Digite um decimal: ")
        assertEquals(3.14, resultado)
    }

    @Test
    fun `deve ler inteiro sem falhar`() {
        try {
            val inputSimulado = "99\n"
            System.setIn(ByteArrayInputStream(inputSimulado.toByteArray()))
            val consoleInput = ConsoleInput()
            val resultado = consoleInput.lerInteiro("Digite um número: ")
            assertEquals(99, resultado)
        } catch (e: Exception) {
            fail("lerInteiro lançou uma exceção inesperada: $e")
        }
    }
}
