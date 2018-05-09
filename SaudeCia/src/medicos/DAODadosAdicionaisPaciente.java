package medicos;

import dados.Dados;
import java.util.List;
import secretaria.Paciente;

public class DAODadosAdicionaisPaciente {
    
    public List<DadosAdicionaisPaciente> getLista() {
        return Dados.listaAdicionaisPacientes;
    }
    
    public void inserir(Paciente paciente, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        DadosAdicionaisPaciente dadosAdicionaisPaciente = new DadosAdicionaisPaciente();
        
        if (dadosAdicionaisPaciente.getId() == null) {
            dadosAdicionaisPaciente.setId(Dados.listaAdicionaisPacientes.size() + 1); //Gera um novo codigo
        }
        //Insere os dados adicionais
        dadosAdicionaisPaciente.setPaciente(paciente);
        dadosAdicionaisPaciente.setFuma(fuma);
        dadosAdicionaisPaciente.setBebe(bebe);
        dadosAdicionaisPaciente.setColesterol(colesterol);
        dadosAdicionaisPaciente.setDiabete(diabete);
        dadosAdicionaisPaciente.setDoencaCardiaca(doencaCardiaca);
        dadosAdicionaisPaciente.setCirurgias(cirurgias);
        dadosAdicionaisPaciente.setAlergias(alergias);
        
        Dados.listaAdicionaisPacientes.add(dadosAdicionaisPaciente);
    }
    
    public void alterar(Integer id, Paciente paciente, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        DadosAdicionaisPaciente dadosAdicionaisPaciente = new DadosAdicionaisPaciente();
        
        dadosAdicionaisPaciente.setPaciente(paciente);
        dadosAdicionaisPaciente.setFuma(fuma);
        dadosAdicionaisPaciente.setBebe(bebe);
        dadosAdicionaisPaciente.setColesterol(colesterol);
        dadosAdicionaisPaciente.setDiabete(diabete);
        dadosAdicionaisPaciente.setDoencaCardiaca(doencaCardiaca);
        dadosAdicionaisPaciente.setCirurgias(cirurgias);
        dadosAdicionaisPaciente.setAlergias(alergias);
        
        int posicao = id - 1;
        Dados.listaAdicionaisPacientes.set(posicao, dadosAdicionaisPaciente);
    }
    
    public void remover(Integer id) {
        int posicao = id - 1;
        Dados.listaAdicionaisPacientes.remove(posicao);
    }
    
}
