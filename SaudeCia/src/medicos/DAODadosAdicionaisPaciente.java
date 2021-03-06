package medicos;

import dados.Dados;
import java.util.List;
import secretaria.Paciente;

/**
 *
 * Classe responsável pelo CRUD relacionado ao POJO DadosAdicionaisPaciente.
 */
public class DAODadosAdicionaisPaciente {

    public List<DadosAdicionaisPaciente> getLista() {
        return Dados.listaAdicionaisPacientes;
    }

    public void inserir(Paciente paciente, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        DadosAdicionaisPaciente dadosAdicionaisPaciente = new DadosAdicionaisPaciente();

        //Insere os dados adicionais
        dadosAdicionaisPaciente.setId(paciente.getId());
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

    public void alterar(Integer id, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        DadosAdicionaisPaciente dadosAdicionaisPaciente = new DadosAdicionaisPaciente();

        dadosAdicionaisPaciente.setId(id);
        dadosAdicionaisPaciente.setFuma(fuma);
        dadosAdicionaisPaciente.setBebe(bebe);
        dadosAdicionaisPaciente.setColesterol(colesterol);
        dadosAdicionaisPaciente.setDiabete(diabete);
        dadosAdicionaisPaciente.setDoencaCardiaca(doencaCardiaca);
        dadosAdicionaisPaciente.setCirurgias(cirurgias);
        dadosAdicionaisPaciente.setAlergias(alergias);

        int posicao = Dados.listaAdicionaisPacientes.indexOf(getDadosAdicionaisPorId(id));
        Dados.listaAdicionaisPacientes.set(posicao, dadosAdicionaisPaciente);
    }

    public void remover(Integer id) {
        int posicao = Dados.listaAdicionaisPacientes.indexOf(getDadosAdicionaisPorId(id));
        Dados.listaAdicionaisPacientes.remove(posicao);
    }

    public DadosAdicionaisPaciente getDadosAdicionaisPorId(int id) {
        for (DadosAdicionaisPaciente dados : Dados.listaAdicionaisPacientes) {
            if (dados.getId().equals(id)) {
                return dados;
            }
        }
        return null;
    }

}
