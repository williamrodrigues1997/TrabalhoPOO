
package secretaria;

import dados.Dados;
import java.util.Date;
import java.util.List;
import medicos.Medico;


public class DAOConsulta {
    
    public List<Consulta> getLista(){
        return Dados.listaConsultas;
    }
    
     public void inserir(Date data, String horario, String medico, Paciente paciente, TipoConsulta tipo){
        Consulta consulta = new Consulta();
        
        if(consulta.getId()==null){ //Caso seja uma nova consulta
             consulta.setId(Dados.listaConsultas.size()+1); //Gera um novo codigo para ela
        }
        //Insere os dados da Consulta
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setTipo(tipo);
        
        Dados.listaConsultas.add(consulta);
    }
    
    public void alterar(Integer id, Date data, String horario, String medico, Paciente paciente, TipoConsulta tipo){
        Consulta consulta = new Consulta();
        
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setTipo(tipo);
        
        int posicao = id-1;
        Dados.listaConsultas.set(posicao, consulta);
    }
    
    public void remover(Integer id){
        int posicao = id-1;
        Dados.listaConsultas.remove(posicao);
    }
}
