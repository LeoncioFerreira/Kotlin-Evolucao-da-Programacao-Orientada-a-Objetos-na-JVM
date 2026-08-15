package sistema.alunos.interop;

/**
 * Descricao: Exemplo de classe escrita puramente em Java para demonstrar interoperabilidade
 * Autor: Paulo
 */
public class GeradorDeMensagemJava {
    
    private String remetente;

    public GeradorDeMensagemJava(String remetente) {
        this.remetente = remetente;
    }

    public String gerarMensagemBoasVindas(String nomeAluno) {
        return "Ola " + nomeAluno + ", seja muito bem-vindo ao sistema! (Mensagem gerada por codigo Java, assinada por: " + remetente + ")";
    }
}
