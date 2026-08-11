package sistema.alunos.view

/**
 * Implementação de entrada segura a partir do terminal.
 * Converte e valida entrada do usuário sem lançar exceções.
 * 
 * Adaptado para as interfaces do projeto:
 * - lerTexto() ao invés de lerString()
 * - lerDecimal() ao invés de lerDouble()
 * - Sem sobrecarga de lerInteiro(min, max) na interface
 */
class ConsoleInput : Entrada {
    
    /**
     * Lê um número inteiro do terminal com segurança.
     * Permite nova tentativa se entrada inválida.
     *
     * @param mensagem Mensagem a ser exibida ao usuário
     * @return Número inteiro lido
     */

    override fun lerInteiro(mensagem: String): Int {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()
            
            if (entrada.isNullOrBlank()) {
                println("❌ Erro: A entrada não pode ser vazia. Tente novamente.")
                continue
            }
            
            val numero = entrada.toIntOrNull()
            if (numero != null) {
                return numero
            } else {
                println("❌ Erro: Digite um número inteiro válido.")
            }
        }
    }
    
    /**
     * Lê um número inteiro dentro de um intervalo específico.
     * Valida se o número está entre min e max (inclusive).
     * 
     * NOTA: Método auxiliar (não está na interface)
     * Use quando precisar validar intervalo
     *
     * @param mensagem Mensagem a ser exibida ao usuário
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Número inteiro no intervalo [min, max]
     */
    override fun lerInteiro(mensagem: String, min: Int, max: Int): Int {
        while (true) {
            val numero = lerInteiro(mensagem)
            if (numero in min..max) {
                return numero
            } else {
                println("❌ Erro: Digite um número entre $min e $max.")
            }
        }
    }
    
    /**
     * Lê um texto do terminal com segurança.
     * Valida se não está vazio (trim automático).
     * 
     * Mapeado de: lerString() para lerTexto()
     *
     * @param mensagem Mensagem a ser exibida ao usuário
     * @return String lida (não vazia, sem espaços laterais)
     */
    override fun lerTexto(mensagem: String): String {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()
            
            if (entrada.isNullOrBlank()) {
                println("❌ Erro: A entrada não pode ser vazia. Tente novamente.")
                continue
            }
            
            return entrada.trim()
        }
    }
    
    /**
     * Lê um número decimal (Double) do terminal com segurança.
     * Permite nova tentativa se entrada inválida.
     * Suporta vírgula como separador decimal (padrão brasileiro).
     * 
     * Mapeado de: lerDouble() para lerDecimal()
     *
     * @param mensagem Mensagem a ser exibida ao usuário
     * @return Número decimal lido
     */
    override fun lerDecimal(mensagem: String): Double {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()
            
            if (entrada.isNullOrBlank()) {
                println("❌ Erro: A entrada não pode ser vazia. Tente novamente.")
                continue
            }
            
            // Trata vírgula como separador decimal (padrão brasileiro)
            val entradaNormalizada = entrada.replace(",", ".")
            val numero = entradaNormalizada.toDoubleOrNull()
            
            if (numero != null && numero >= 0) {
                return numero
            } else {
                println("❌ Erro: Digite um número decimal válido (use ponto ou vírgula).")
            }
        }
    }
}