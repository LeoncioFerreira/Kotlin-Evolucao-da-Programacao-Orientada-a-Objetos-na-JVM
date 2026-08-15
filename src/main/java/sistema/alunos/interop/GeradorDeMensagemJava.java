package sistema.alunos.interop;

/**
 * Descrição: Exemplo de classe escrita puramente em Java para demonstrar interoperabilidade
 * Autor: Paulo
 */
public class GeradorDeMensagemJava {
    
    private String remetente;

    public GeradorDeMensagemJava(String remetente) {
        this.remetente = remetente;
    }

    public String gerarMensagemBoasVindas(String nomeAluno) {
        return "Olá " + nomeAluno + ", seja muito bem-vindo ao sistema! (Mensagem gerada por código Java, assinada por: " + remetente + ")";
    }
}
