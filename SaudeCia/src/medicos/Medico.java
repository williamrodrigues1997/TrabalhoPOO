package medicos;

/**
 *
 * Classe que representa as funcionalidades de um Médico da clínica.
 */
public class Medico {

    //Atributos (Gerenciadores/Funcionalidades do Médico)
    private DAODadosAdicionaisPaciente gerenciarDadosAdicionaisPacientes;
    private DAOProntuario gerenciarProntuarios;
    private RelatorioMedico gerenciarRelatorios;

    //Construtor
    public Medico() {
        this.gerenciarRelatorios = new RelatorioMedico();
        this.gerenciarProntuarios = new DAOProntuario();
        this.gerenciarDadosAdicionaisPacientes = new DAODadosAdicionaisPaciente();
    }

    //Metodos
    public DAODadosAdicionaisPaciente getGerenciarDadosAdicionaisPacientes() {
        return gerenciarDadosAdicionaisPacientes;
    }

    public void setGerenciarDadosAdicionaisPacientes(DAODadosAdicionaisPaciente gerenciarDadosAdicionaisPacientes) {
        this.gerenciarDadosAdicionaisPacientes = gerenciarDadosAdicionaisPacientes;
    }

    public DAOProntuario getGerenciarProntuarios() {
        return gerenciarProntuarios;
    }

    public void setGerenciarProntuarios(DAOProntuario gerenciarProntuarios) {
        this.gerenciarProntuarios = gerenciarProntuarios;
    }

    public RelatorioMedico getGerenciarRelatorios() {
        return gerenciarRelatorios;
    }

    public void setGerenciarRelatorios(RelatorioMedico gerenciarRelatorios) {
        this.gerenciarRelatorios = gerenciarRelatorios;
    }

}
