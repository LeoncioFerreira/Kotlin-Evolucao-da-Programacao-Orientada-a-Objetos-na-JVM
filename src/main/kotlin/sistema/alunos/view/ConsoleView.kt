package sistema.alunos.view

/**
 * Implementação de saída formatada para o terminal.
 * Responsável exclusivamente por exibir mensagens.
 * 
 * Adaptado para a interface do projeto:
 * - Implementa apenas exibir()
 * - Métodos auxiliares para erros e resultados
 */
class ConsoleView : Saida {
    
    /**
     * Exibe uma mensagem simples no terminal.
     * Método obrigatório da interface Saida.
     *
     * @param mensagem Mensagem a ser exibida
     */

    override fun exibir(mensagem: String) {
        println(mensagem)
    }
    
    /**
     * Exibe uma mensagem de erro com formatação destacada.
     * Método auxiliar (não está na interface, mas é útil).
     * Prefixo: [ERRO]
     *
     * @param erro Descrição do erro
     */

     
    override fun exibirErro(erro: String) {
        println("\n❌ [ERRO] $erro\n")
    }
    
    /**
     * Exibe um resultado em um box formatado.
     * Método auxiliar (não está na interface, mas é útil).
     * Útil para respostas importantes do sistema.
     *
     * @param resultado Conteúdo do resultado
     */

    override fun exibirResultado(resultado: String) {
        println("\n╔════════════════════════════════════════╗")
        println("║           🎯 RESULTADO                   ║")
        println("╠════════════════════════════════════════╣")
        println("║ $resultado".padEnd(40) + "║")
        println("╚════════════════════════════════════════╝\n")
    }
    
    /**
     * Limpa a tela do terminal.
     * Método auxiliar (não está na interface, mas é útil).
     * Funciona em Linux/macOS e Windows.
     */

    override fun limparTela() {
        val comando = if (System.getProperty("os.name").contains("Windows")) {
            "cls"
        } else {
            "clear"
        }
        try {
            Runtime.getRuntime().exec(comando).waitFor()
        } catch (e: Exception) {
            // Se não conseguir limpar, apenas exibe quebras de linha
            repeat(50) { println() }
        }
    }
    
    /**
     * Exibe um menu com formatação padronizada.
     * Método auxiliar (não está na interface, mas é útil).
     * Use junto com lerInteiro(min, max) de ConsoleInput.
     *
     * @param titulo Título do menu
     * @param opcoes List de strings descrevendo cada opção
     */
     
    override fun exibirMenu(titulo: String, opcoes: List<String>) {
        println("\n╔════════════════════════════════════════╗")
        println("║ $titulo".padEnd(40) + "║")
        println("╠════════════════════════════════════════╣")
        opcoes.forEachIndexed { index, opcao ->
            println("║ ${index + 1}. $opcao".padEnd(40) + "║")
        }
        println("╚════════════════════════════════════════╝\n")
    }
}