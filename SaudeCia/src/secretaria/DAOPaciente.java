package secretaria;

import dados.Dados;
import java.util.Date;
import java.util.List;
import medicos.DadosAdicionaisPaciente;

/**
 *
 * Classe responsável pelo CRUD relacionado ao POJO Paciente.
 */
public class DAOPaciente {

    public List<Paciente> getLista() {
        return Dados.listaPacientes;
    }

    public void inserir(String nome, String cpf, String rg, Date dataNascimento, String endereco, String telefoneCelular, String email, Convenio tipoConvenio) {
        Paciente paciente = new Paciente();

        if (paciente.getId() == null) { //Caso seja um novo paciente
            if (Dados.listaPacientes.isEmpty()) {
                paciente.setId(1);
            } else {
                paciente.setId((Dados.listaPacientes.get(Dados.listaPacientes.size() - 1).getId()) + 1); //Gera um novo codigo para ele
            }
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

    public void alterar(Integer id, String nome, String cpf, String rg, Date dataNascimento, String endereco, String telefoneCelular, String email, Convenio tipoConvenio) {
        Paciente paciente = new Paciente();

        paciente.setId(id);
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setRg(rg);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setTelefoneCelular(telefoneCelular);
        paciente.setEmail(email);
        paciente.setTipoConvenio(tipoConvenio);

        int posicao = Dados.listaPacientes.indexOf(getPacientePorId(id));
        Dados.listaPacientes.set(posicao, paciente);
    }

    public void remover(Integer id) {
        Paciente paciente = getPacientePorId(id);

        for (DadosAdicionaisPaciente dadoAdicional : Dados.listaAdicionaisPacientes) {
            if (dadoAdicional.getId().equals(id)) {
                Dados.listaAdicionaisPacientes.remove(dadoAdicional);
            }
            if (Dados.listaAdicionaisPacientes.isEmpty()) {
                break;
            }
        }
        if (paciente != null) {
            Dados.listaPacientes.remove(paciente);
        }
    }

    public Paciente getPacientePorCpf(String Cpf) {
        for (Paciente paciente : Dados.listaPacientes) {
            if (paciente.getCpf().equals(Cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente getPacientePorId(Integer id) {
        for (Paciente paciente : Dados.listaPacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null;
    }

}
