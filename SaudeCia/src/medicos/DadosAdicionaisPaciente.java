package medicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import secretaria.Paciente;

public class DadosAdicionaisPaciente {

    //Atributos
    private Integer id;
    private Paciente paciente;
    private boolean fuma;
    private boolean bebe;
    private boolean colesterol;
    private boolean diabete;
    private boolean doencaCardiaca;
    private List<String> cirurgias = new ArrayList<>();
    private List<String> alergias = new ArrayList<>();

    //Construtor
    public DadosAdicionaisPaciente() {
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

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public boolean isColesterol() {
        return colesterol;
    }

    public void setColesterol(boolean colesterol) {
        this.colesterol = colesterol;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public List<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.paciente);
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
        final DadosAdicionaisPaciente other = (DadosAdicionaisPaciente) obj;
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return true;
    }

}
