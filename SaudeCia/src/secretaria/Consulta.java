package secretaria;

import dados.Datas;
import java.util.Date;
import java.util.Objects;

public class Consulta {

    //Atributos
    private Integer id;
    private Date data;
    private String horario;
    private String medico;
    private Paciente paciente;
    private TipoConsulta tipo;

    //Construtor
    public Consulta() {
    }

    //Metodos
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoConsulta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsulta tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ID: " + this.id
                + "\nData: " + Datas.formatoData.format(this.data)
                + "\nHorario: " + this.horario
                + "\nMedico: " + this.medico
                + "\nPaciente: " + this.paciente.getNome()
                + "\nTipo: " + this.tipo.getDescricao();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
