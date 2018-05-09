
package principal;

import dados.*;
import secretaria.*;
import medicos.*;
import mensagens.*;


public class PrincipalTeste {
    
    public static void main(String args[]) {
        
        Dados dados = new Dados();
        DAOPaciente daoPaciente = new DAOPaciente();
        daoPaciente.inserir("William", "123", "123", "09/03/1997", "Rua X", "123", "123@uem.com", Convenio.PARTICULAR);
        System.out.println("Paciente inserido: " + daoPaciente.getLista().get(0).getNome());
        System.out.println("Numero de Pacientes Cadastrados: " + daoPaciente.getLista().size());
        daoPaciente.alterar(1, "William Rodrigues", "123", "123", "09/03/1997", "Rua X", "123", "123@uem.com", Convenio.PARTICULAR);
        System.out.println("\nPaciente editado: " + daoPaciente.getLista().get(0).getNome());
        daoPaciente.remover(1);
        System.out.println("\nPaciente Removido");
        System.out.println("Numero de Pacientes Cadastrados: " + daoPaciente.getLista().size());
    }
    
}
