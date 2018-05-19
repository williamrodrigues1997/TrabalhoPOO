
package secretaria;

import dados.Dados;
import java.util.Date;
import java.util.List;


public class DAOPaciente {
    
    public List<Paciente> getLista(){
        return Dados.listaPacientes;
    }
    
    public void inserir(String nome, String cpf, String rg, Date dataNascimento, String endereco, String telefoneCelular, String email, Convenio tipoConvenio){
        Paciente paciente = new Paciente();
        
        if(paciente.getId()==null){ //Caso seja um novo paciente
             paciente.setId(Dados.listaPacientes.size()+1); //Gera um novo codigo para ele
        }
        //Insere os dados do paciente
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setRg(rg);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setTelefoneCelular(telefoneCelular);
        paciente.setEmail(email);
        paciente.setTipoConvenio(tipoConvenio);
        
        Dados.listaPacientes.add(paciente);
    }
    
    public void alterar(Integer id, String nome, String cpf, String rg, Date dataNascimento, String endereco, String telefoneCelular, String email, Convenio tipoConvenio){
        Paciente paciente = new Paciente();
        
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setRg(rg);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setTelefoneCelular(telefoneCelular);
        paciente.setEmail(email);
        paciente.setTipoConvenio(tipoConvenio);
        
        int posicao = id-1;
        Dados.listaPacientes.set(posicao, paciente);
    }
    
    public void remover(Integer id){
        int posicao = id-1;
        Dados.listaPacientes.remove(posicao);
    }
    
    public Paciente getPacientePorCpf(String Cpf){
        for(Paciente paciente: Dados.listaPacientes){
            if(paciente.getCpf().equals(Cpf)){
                return paciente;
            }
        }
        return null;
    }
    
}
