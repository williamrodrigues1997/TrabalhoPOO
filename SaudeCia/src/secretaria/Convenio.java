
package secretaria;


public enum Convenio {
    PARTICULAR("Particular"),
    PLANO_DE_SAUDE("Plano de Saude");
    
    private String descricao;
    
    Convenio(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
