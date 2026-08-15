package sistema.alunos.view

import kotlin.test.*

class MenuPrincipalTest {

    private class MockEntrada(private val valores: List<Int>) : Entrada {
        private var index = 0
        override fun lerTexto(mensagem: String) = "teste"
        override fun lerInteiro(mensagem: String) = valores[index++]
        override fun lerDecimal(mensagem: String) = 0.0
        override fun lerInteiro(mensagem: String, min: Int, max: Int) = valores[index++]
    }

    private class MockSaida : Saida {
        val mensagens = mutableListOf<String>()
        override fun exibir(mensagem: String) { mensagens.add(mensagem) }
        override fun exibirErro(erro: String) { mensagens.add(erro) }
        override fun exibirResultado(resultado: String) { mensagens.add(resultado) }
        override fun limparTela() {}
        override fun exibirMenu(titulo: String, opcoes: List<String>) {}
    }

    private class MockController : Controlador {
        var aluno = false
        var avaliacao = false
        var relatorio = false
        var estatisticas = false

        override fun cadastrarAluno() { aluno = true }
        override fun registrarAvaliacao() { avaliacao = true }
        override fun consultarRelatorio() { relatorio = true }
        override fun verEstatisticas() { estatisticas = true }
    }

    @Test
    fun `deve chamar cadastrarAluno e encerrar`() {
        val entrada = MockEntrada(listOf(1, 5))
        val saida = MockSaida()
        val controller = MockController()
        val menu = MenuPrincipal(entrada, saida, controller)

        menu.iniciar()

        assertTrue(controller.aluno)
        assertTrue(saida.mensagens.any { it.contains("Encerrando") })
    }
}
