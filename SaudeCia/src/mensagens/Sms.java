package mensagens;

/**
 *
 * Classe POJO que reresenta uma mensagem do tipo SMS.
 */
public class Sms {

    //Atributos
    private String mensagem;

    //Construtor
    public Sms() {
    }

    //Metodos
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
