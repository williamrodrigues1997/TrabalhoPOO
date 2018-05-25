package medicos;

import dados.Datas;
import java.util.Date;
import java.util.Objects;
import secretaria.Paciente;

public class Prontuario {

    //Atributos
    private Integer id;
    private Paciente paciente;
    private Date data;
    private String medico;
    private String sintomas;
    private String diagnosticoDoenca;
    private String prescricaoTratamento;

    //Construtor
    public Prontuario() {
    }

    //Metodos
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }    

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }   

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnosticoDoenca() {
        return diagnosticoDoenca;
    }

    public void setDiagnosticoDoenca(String diagnosticoDoenca) {
        this.diagnosticoDoenca = diagnosticoDoenca;
    }

    public String getPrescricaoTratamento() {
        return prescricaoTratamento;
    }

    public void setPrescricaoTratamento(String prescricaoTratamento) {
        this.prescricaoTratamento = prescricaoTratamento;
    }
    
    @Override
    public String toString(){
        return "\nID: " + this.id
                + "\nPaciente: " + this.paciente.getNome()
                + "\nData: " + Datas.formatoData.format(this.data)
                + "\nMedico: " + this.medico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Prontuario other = (Prontuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
