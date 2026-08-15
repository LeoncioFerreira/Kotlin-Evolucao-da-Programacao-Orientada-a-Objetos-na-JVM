/**
 * Descricao: Exemplo executavel de Kotlin instanciando e utilizando uma classe Java
 * Autor: Paulo
 */
package sistema.alunos.interop

fun main() {
    println("--- Teste de Interoperabilidade Kotlin e Java ---")
    
    // O Kotlin consegue instanciar uma classe Java nativamente como se fosse Kotlin!
    // Note que nao precisamos usar a palavra "new"
    val geradorJava = GeradorDeMensagemJava("Equipe de Desenvolvimento")
    
    // Chamando o metodo escrito em Java
    val mensagem = geradorJava.gerarMensagemBoasVindas("Joao Pedro")
    
    println(mensagem)
    println("-------------------------------------------------")
    println("Teste concluido com sucesso: o Kotlin conseguiu importar, instanciar e executar uma classe escrita em Java na mesma plataforma JVM.")
}
