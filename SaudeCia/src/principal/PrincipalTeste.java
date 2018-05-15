
package principal;

import dados.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import secretaria.*;
import medicos.*;
import mensagens.*;


public class PrincipalTeste {
    
    public static void main(String args[]) throws ParseException {
              
        Secretaria secretaria = new Secretaria();
        Medico medico = new Medico();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");        
        
        System.out.println("PRINTS DE TESTE\n");
        
        secretaria.getGerenciarPacientes().inserir("William", "123", "123", formatoData.parse("09/03/1997"), "Rua X", "123", "123@uem.com", Convenio.PARTICULAR);
        System.out.println("Paciente inserido: " 
                + secretaria.getGerenciarPacientes().getLista().get(0).getNome() 
                + " - " + formatoData.format(secretaria.getGerenciarPacientes().getLista().get(0).getDataNascimento()) 
                + " ...");
        
        medico.getGerenciarProntuarios().inserir(secretaria.getGerenciarPacientes().getLista().get(0), "Sintomas", "Diagnostico", "Prescricao");
        System.out.println("Prontuario inserido: " 
                + medico.getGerenciarProntuarios().getLista().get(0).getPaciente().getNome() 
                + " - " + medico.getGerenciarProntuarios().getLista().get(0).getDiagnosticoDoenca() 
                + " ...");
        
        //Comparar data com data do dia seguinte:
        Date dataTeste = formatoData.parse("16/05/2018"); //instancia uma data
        Calendar cal = Calendar.getInstance(); //Intancia um calendario
        cal.add (Calendar.DATE, 1); //Adiciona 1 dia a data de hoje        
        
        if(formatoData.format(cal.getTime()).equals(formatoData.format(dataTeste))){
            System.out.println("Falta 1 dia para data informada");
        }
        
    }
    
}
