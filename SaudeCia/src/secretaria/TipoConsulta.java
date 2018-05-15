package secretaria;

public enum TipoConsulta {
    NORMAL("Normal (duração de 1 hora)"),
    RETORNO("Retorno (duração de 30 minutos)");

    private String descricao;

    private TipoConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
