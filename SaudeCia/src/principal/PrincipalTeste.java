
package principal;

import dados.*;
import secretaria.*;
import medicos.*;
import mensagens.*;


public class PrincipalTeste {
    
    public static void main(String args[]) {
              
        Secretaria secretaria = new Secretaria();
        Medico medico = new Medico();
        
        System.out.println("PRINTS DE TESTE\n");
        
        secretaria.getGerenciarPacientes().inserir("William", "123", "123", "09/03/1997", "Rua X", "123", "123@uem.com", Convenio.PARTICULAR);
        System.out.println("Paciente inserido: " 
                + secretaria.getGerenciarPacientes().getLista().get(0).getNome() 
                + " - " + secretaria.getGerenciarPacientes().getLista().get(0).getDataNascimento() 
                + " ...");
        
        medico.getGerenciarProntuarios().inserir(secretaria.getGerenciarPacientes().getLista().get(0), "Sintomas", "Diagnostico", "Prescricao");
        System.out.println("Prontuario inserido: " 
                + medico.getGerenciarProntuarios().getLista().get(0).getPaciente().getNome() 
                + " - " + medico.getGerenciarProntuarios().getLista().get(0).getDiagnosticoDoenca() 
                + " ...");
    }
    
}
