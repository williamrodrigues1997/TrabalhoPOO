package secretaria;

public class Secretaria {

    //Atributos
    private DAOPaciente gerenciarPacientes = new DAOPaciente();
    private DAOConsulta gerenciarConsultas = new DAOConsulta();
    private RelatorioConsulta relatorioConsulta = new RelatorioConsulta();

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

    public RelatorioConsulta getRelatorioConsulta() {
        return relatorioConsulta;
    }

    public void setRelatorioConsulta(RelatorioConsulta relatorioConsulta) {
        this.relatorioConsulta = relatorioConsulta;
    }
    
    
    
    
}
