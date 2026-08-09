/**
 * Descrição: Define o contrato de leitura de dados fornecidos pelo usuário
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.view

interface Entrada {
    fun lerTexto(mensagem: String): String

    fun lerInteiro(mensagem: String): Int

    fun lerDecimal(mensagem: String): Double
}
