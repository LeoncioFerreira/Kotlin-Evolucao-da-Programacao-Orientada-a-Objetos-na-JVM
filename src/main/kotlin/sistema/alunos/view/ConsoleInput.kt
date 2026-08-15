/**
 * Descrição: Implementa a leitura e a conversão segura de dados fornecidos pelo terminal
 * Autora: Ramona
 */
package sistema.alunos.view

class ConsoleInput : Entrada {

    override fun lerInteiro(mensagem: String): Int {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()

            if (entrada == null) {
                println("Entrada encerrada. O programa foi finalizado pelo usuário.")
                throw IllegalStateException("Entrada encerrada pelo usuário.")
            }

            if (entrada.isBlank()) {
                println("A entrada não pode ficar em branco. Por favor, digite novamente.")
                continue
            }

            val numero = entrada.toIntOrNull()
            if (numero != null) {
                return numero
            } else {
                println("Valor inválido. Digite um número inteiro.")
            }
        }
    }

    override fun lerInteiro(mensagem: String, min: Int, max: Int): Int {
        while (true) {
            val numero = lerInteiro(mensagem)
            if (numero in min..max) {
                return numero
            } else {
                println("O valor deve estar entre $min e $max.")
            }
        }
    }

    override fun lerTexto(mensagem: String): String {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()

            if (entrada == null) {
                println("Entrada encerrada. O programa foi finalizado pelo usuário.")
                throw IllegalStateException("Entrada encerrada pelo usuário.")
            }

            if (entrada.isBlank()) {
                println("Nenhum texto foi digitado. Tente novamente.")
                continue
            }

            return entrada.trim()
        }
    }

    override fun lerDecimal(mensagem: String): Double {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()

            if (entrada == null) {
                println("Entrada encerrada. O programa foi finalizado pelo usuário.")
                throw IllegalStateException("Entrada encerrada pelo usuário.")
            }

            if (entrada.isBlank()) {
                println("A entrada não pode ficar em branco. Digite novamente.")
                continue
            }

            val entradaNormalizada = entrada.replace(",", ".")
            val numero = entradaNormalizada.toDoubleOrNull()

            if (numero != null && numero >= 0) {
                return numero
            } else {
                println("Valor inválido. Digite um número decimal (ponto ou vírgula).")
            }
        }
    }
}
