/**
 * Descrição: Define o contrato de apresentação de mensagens ao usuário
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.view

interface Saida {
    fun exibir(mensagem: String)
    fun exibirErro(erro: String)
    fun exibirResultado(resultado: String)
    fun limparTela()
    fun exibirMenu(titulo: String, opcoes: List<String>)
}
