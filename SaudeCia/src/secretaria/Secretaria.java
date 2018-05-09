package secretaria;

public class Secretaria {

    //Atributos
    private DAOPaciente gerenciarPacientes = new DAOPaciente();
    private DAOConsulta gerenciarConsultas = new DAOConsulta();

    //Construtor
    public Secretaria() {
    }
    
    //Metodos

    public DAOPaciente getGerenciarPacientes() {
        return gerenciarPacientes;
    }

    public void setGerenciarPacientes(DAOPaciente gerenciarPacientes) {
        this.gerenciarPacientes = gerenciarPacientes;
    }

    public DAOConsulta getGerenciarConsultas() {
        return gerenciarConsultas;
    }

    public void setGerenciarConsultas(DAOConsulta gerenciarConsultas) {
        this.gerenciarConsultas = gerenciarConsultas;
    }
    
    
}
