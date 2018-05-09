package medicos;

public class Medico {

    //Atributos
    private Integer id;
    private String nome;

    private DAODadosAdicionaisPaciente gerenciarDadosAdicionaisPacientes = new DAODadosAdicionaisPaciente();
    private DAOProntuario gerenciarProntuarios = new DAOProntuario();

    //Construtor
    public Medico() {
    }

    //Metodos
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
