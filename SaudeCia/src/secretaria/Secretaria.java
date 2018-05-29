package secretaria;

import mensagens.GerenciadorMensagens;

public class Secretaria {

    //Atributos
    private final DAOPaciente gerenciarPacientes = new DAOPaciente();
    private final DAOConsulta gerenciarConsultas = new DAOConsulta();
    private final RelatorioConsulta relatorioConsulta = new RelatorioConsulta();
    private final GerenciadorMensagens gerenciarMensagens = new GerenciadorMensagens();

    //Construtor
    public Secretaria() {
    }

    //Metodos
    public DAOPaciente getGerenciarPacientes() {
        return gerenciarPacientes;
    }

    public DAOConsulta getGerenciarConsultas() {
        return gerenciarConsultas;
    }

    public RelatorioConsulta getRelatorioConsulta() {
        return relatorioConsulta;
    }

    public GerenciadorMensagens getGerenciarMensagens() {
        return gerenciarMensagens;
    }

}
