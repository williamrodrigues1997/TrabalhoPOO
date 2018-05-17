package medicos;

public class RelatorioMedico {

    //Atributos
    private String relatorio;
    private Medico medico;

    //Construtor
    public RelatorioMedico() {
    }

    //Metodos
    public String getRelatorio() {
        return relatorio;
    }

    public void gerarReceita(int prontuario) {
        this.relatorio = "Receita"
                + "Medico: " + medico.getGerenciarProntuarios().getLista().get(prontuario).getMedico()
                + "Pciente: " + medico.getGerenciarProntuarios().getLista().get(prontuario).getPaciente()
                + "Prescrição: " + medico.getGerenciarProntuarios().getLista().get(prontuario).getPrescricaoTratamento()
                + "Data: 'data da consulta";
    }

    public void gerarDeclaracaoAcompanhante() {

    }

    public void gerarClientesAtendidosMes() {

    }

    public void gerarAtestado() {

    }

}
