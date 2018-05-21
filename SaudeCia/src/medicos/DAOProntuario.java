package medicos;

import dados.Dados;
import java.util.List;
import secretaria.Paciente;

public class DAOProntuario {
    
    public List<Prontuario> getLista(){
        return Dados.listaProntuarios;
    }
    
     public void inserir(Paciente paciente, String sintomas, String diagnosticoDoenca, String prescricaoTratamento){
        Prontuario prontuario = new Prontuario();
        
        if(prontuario.getId()==null){ //Caso seja um novo prontuario
             prontuario.setId(Dados.listaProntuarios.size()+1); //Gera um novo codigo para ele
        }
        //Insere os dados do Prontuario
        prontuario.setPaciente(paciente);
        prontuario.setSintomas(sintomas);
        prontuario.setDiagnosticoDoenca(diagnosticoDoenca);
        prontuario.setPrescricaoTratamento(prescricaoTratamento);
        
        Dados.listaProntuarios.add(prontuario);
    }
    
    public void alterar(Integer id, Paciente paciente, String sintomas, String diagnosticoDoenca, String prescricaoTratamento){
        Prontuario prontuario = new Prontuario();
        
        prontuario.setId(id);
        prontuario.setPaciente(paciente);
        prontuario.setSintomas(sintomas);
        prontuario.setDiagnosticoDoenca(diagnosticoDoenca);
        prontuario.setPrescricaoTratamento(prescricaoTratamento);
        
        int posicao = id-1;
        Dados.listaProntuarios.set(posicao, prontuario);
    }
    
    public void remover(Integer id){
        int posicao = id-1;
        Dados.listaProntuarios.remove(posicao);
    }
    
}
