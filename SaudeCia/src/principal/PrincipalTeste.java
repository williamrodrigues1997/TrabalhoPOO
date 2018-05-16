
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
        
        //CRIANDO SECRETARIA E MEDICO (Gerenciadores)
        Secretaria secretaria = new Secretaria();
        Medico medico = new Medico();       
        
        
        
        //--------------------ACOES DA SECRETARIA-------------------------------
        
        //INSERINDO PACIENTES
        secretaria.getGerenciarPacientes().inserir("William", "123", "123", Datas.formatoData.parse("09/03/1997"), "Rua X", "98704725", "mail@uem.br", Convenio.PARTICULAR);
        System.out.println("PACIENTE INSERIDO: " 
                + "\n" + secretaria.getGerenciarPacientes().getLista().get(0).toString());
        
        secretaria.getGerenciarPacientes().inserir("Ronny", "123", "123", Datas.formatoData.parse("01/01/2001"), "Rua Y", "", "", Convenio.PLANO_DE_SAUDE);

        for(Paciente paciente: secretaria.getGerenciarPacientes().getLista()){
            paciente.toString();
        }
        
        //INSERINDO CONSULTAS
        secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("16/05/2018"), "15:30", "Dr Testando", secretaria.getGerenciarPacientes().getLista().get(0), TipoConsulta.RETORNO);
        secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("16/05/2018"), "17:00", "Dr Estagiario", secretaria.getGerenciarPacientes().getLista().get(1), TipoConsulta.NORMAL);
        
        //GERANDO RELATORIO DE CONSULTAS
        secretaria.getRelatorioConsulta().gerarRelatorio(false); //true com info de contato / false sem info de contato
        System.out.println(secretaria.getRelatorioConsulta().getRelatorio());
        
        
        
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
