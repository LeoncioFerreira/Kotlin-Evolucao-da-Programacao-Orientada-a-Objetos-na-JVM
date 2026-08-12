package sistema.alunos.view

import kotlin.test.*
import java.io.*

class ConsoleViewTest {

    private lateinit var output: ByteArrayOutputStream
    private lateinit var consoleView: ConsoleView

    @BeforeTest
    fun setup() {
        output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))
        consoleView = ConsoleView()
    }

    @Test
    fun `deve exibir mensagem simples`() {
        consoleView.exibir("Olá mundo")
        assertTrue(output.toString().contains("Olá mundo"))
    }

    @Test
    fun `deve exibir erro formatado`() {
        consoleView.exibirErro("Falha")
        assertTrue(output.toString().contains("[ERRO] Falha"))
    }

    @Test
    fun `deve exibir resultado formatado`() {
        consoleView.exibirResultado("Aprovado")
        assertTrue(output.toString().contains("RESULTADO"))
        assertTrue(output.toString().contains("Aprovado"))
    }

    @Test
    fun `deve exibir menu com opcoes`() {
        consoleView.exibirMenu("Menu Teste", listOf("Opção 1", "Opção 2"))
        val saida = output.toString()
        assertTrue(saida.contains("Menu Teste"))
        assertTrue(saida.contains("1. Opção 1"))
        assertTrue(saida.contains("2. Opção 2"))
    }
}
