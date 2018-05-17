
package principal;

import dados.*;
import java.text.ParseException;
import secretaria.*;
import medicos.*;
import mensagens.*;
import menus.MenuSecretaria;


public class PrincipalTeste {
    
    public static void main(String args[]) throws ParseException {             
        
        MenuSecretaria menuSecretaria = new MenuSecretaria();
        menuSecretaria.executarMenu();
        
        /*
        
        Medico medico = new Medico(); 
        
        //----------------------ACOES DO MEDICO---------------------------------
        
        //INSERINDO PRONTUARIOS
        medico.getGerenciarProntuarios().inserir(secretaria.getGerenciarPacientes().getLista().get(0), "Sintomas", "Diagnostico", "Prescricao");
        System.out.println("Prontuario inserido: " 
                + medico.getGerenciarProntuarios().getLista().get(0).getPaciente().getNome() 
                + " - " + medico.getGerenciarProntuarios().getLista().get(0).getDiagnosticoDoenca() 
                + " ...");   

        */
        
    }
    
}
