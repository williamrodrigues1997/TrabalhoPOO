package secretaria;

import dados.Dados;
import java.util.Date;
import java.util.List;

public class DAOConsulta {

    public List<Consulta> getLista() {
        return Dados.listaConsultas;
    }

    public void inserir(Date data, String horario, String medico, Paciente paciente, TipoConsulta tipo) {
        Consulta consulta = new Consulta();

        if (consulta.getId() == null) { //Caso seja uma nova consulta
            if (Dados.listaConsultas.isEmpty()) {
                consulta.setId(1);
            } else {
                consulta.setId((Dados.listaConsultas.get(Dados.listaConsultas.size() - 1).getId()) + 1); //Gera um novo codigo para ela
            }
        }
        //Insere os dados da Consulta
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setTipo(tipo);

        Dados.listaConsultas.add(consulta);
    }

    public void alterar(Integer id, Date data, String horario, String medico, Paciente paciente, TipoConsulta tipo) {
        Consulta consulta = new Consulta();

        consulta.setId(id);
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setTipo(tipo);

        int posicao = Dados.listaConsultas.indexOf(getConsultaPorId(id));
        Dados.listaConsultas.set(posicao, consulta);
    }

    public void remover(Integer id) {
        int posicao = Dados.listaConsultas.indexOf(getConsultaPorId(id));
        Dados.listaConsultas.remove(posicao);
    }

    public Consulta getConsultaPorId(Integer id) {
        for (Consulta consulta : Dados.listaConsultas) {
            if (consulta.getId().equals(id)) {
                return consulta;
            }
        }
        return null;
    }
}
