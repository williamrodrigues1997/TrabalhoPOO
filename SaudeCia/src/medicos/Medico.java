package medicos;

public class Medico {

    //Atributos

    private DAODadosAdicionaisPaciente gerenciarDadosAdicionaisPacientes = new DAODadosAdicionaisPaciente();
    private DAOProntuario gerenciarProntuarios = new DAOProntuario();

    //Construtor
    public Medico() {
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
    
        
}
