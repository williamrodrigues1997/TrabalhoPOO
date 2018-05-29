package medicos;

import dados.Dados;
import java.util.Date;
import java.util.List;
import secretaria.Paciente;

public class DAOProntuario {

    public List<Prontuario> getLista() {
        return Dados.listaProntuarios;
    }

    public void inserir(Date data, String medico, Paciente paciente, String sintomas, String diagnosticoDoenca, String prescricaoTratamento) {
        Prontuario prontuario = new Prontuario();

        if (prontuario.getId() == null) { //Caso seja um novo prontuario
            if (Dados.listaProntuarios.isEmpty()) {
                prontuario.setId(1);
            } else {
                prontuario.setId((Dados.listaProntuarios.get(Dados.listaProntuarios.size() - 1).getId()) + 1); //Gera um novo codigo para ele
            }
        }
        //Insere os dados do Prontuario
        prontuario.setPaciente(paciente);
        prontuario.setMedico(medico);
        prontuario.setData(data);
        prontuario.setSintomas(sintomas);
        prontuario.setDiagnosticoDoenca(diagnosticoDoenca);
        prontuario.setPrescricaoTratamento(prescricaoTratamento);

        Dados.listaProntuarios.add(prontuario);
    }

    public void alterar(Integer id, Paciente paciente, String sintomas, String diagnosticoDoenca, String prescricaoTratamento) {
        Prontuario prontuario = new Prontuario();

        prontuario.setId(id);
        prontuario.setPaciente(paciente);
        prontuario.setSintomas(sintomas);
        prontuario.setDiagnosticoDoenca(diagnosticoDoenca);
        prontuario.setPrescricaoTratamento(prescricaoTratamento);

        int posicao = Dados.listaProntuarios.indexOf(getProntuarioPorId(id));
        Dados.listaProntuarios.set(posicao, prontuario);
    }

    public void remover(Integer id) {
        int posicao = Dados.listaProntuarios.indexOf(getProntuarioPorId(id));
        Dados.listaProntuarios.remove(posicao);
    }

    public Prontuario getProntuarioPorCpf(String cpf) {
        for (Prontuario prontuario : Dados.listaProntuarios) {
            if (prontuario.getPaciente().getCpf().equals(cpf)) {
                return prontuario;
            }
        }
        return null;
    }

    public Prontuario getProntuarioPorId(Integer id) {
        for (Prontuario prontuario : Dados.listaProntuarios) {
            if (prontuario.getPaciente().getId().equals(id)) {
                return prontuario;
            }
        }
        return null;
    }
}
