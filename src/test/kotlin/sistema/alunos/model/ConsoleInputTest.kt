package sistema.alunos.view

import kotlin.test.*
import java.io.*

class ConsoleInputTest {

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
}
