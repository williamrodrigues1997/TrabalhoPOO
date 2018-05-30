package secretaria;

import mensagens.GerenciadorMensagens;

/**
 *
 * Classe que representa as funcionalidades de uma Secretária da clínica.
 */
public class Secretaria {

    //Atributos (Gerenciadores/Funcionalidades da Secretária)
    private final DAOPaciente gerenciarPacientes;
    private final DAOConsulta gerenciarConsultas;
    private final GerenciadorMensagens gerenciarMensagens;
    private final RelatorioConsulta relatorioConsulta;

    //Construtor
    public Secretaria() {
        this.gerenciarPacientes = new DAOPaciente();
        this.gerenciarConsultas = new DAOConsulta();
        this.gerenciarMensagens = new GerenciadorMensagens();
        this.relatorioConsulta = new RelatorioConsulta();
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
