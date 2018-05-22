package medicos;

import dados.Datas;
import java.util.Calendar;

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
                + "Data: " + medico.getGerenciarProntuarios().getLista().get(prontuario).getData();
    }

    public String gerarDeclaracaoAcompanhante(int prontuario, String nomeAcomp, String cpfAcomp, String parentescoAcomp) {
        Calendar data = Calendar.getInstance();

        this.relatorio = "\nAtesto para os devidos fins a pedido  que o Sr. " + medico.getGerenciarProntuarios().getLista().get(prontuario).getPaciente() + ","
                + "\nincrito no CPF sob o nº" + medico.getGerenciarProntuarios().getLista().get(prontuario).getCpf() + ", paciente sob meus cuidados, foi atendido"
                + "\nno dia" + data.DAY_OF_MONTH + ", ás" + Datas.formatoHora.format(data.getTime()) + ", apresentando quadro de " + medico.getGerenciarProntuarios().getLista().get(prontuario).getDiagnosticoDoenca() + ", tendo sido"
                + "\nacompanhado pelo seu " + parentescoAcomp + ", Sr. " + nomeAcomp + ", inscrito no CPF sob o nº: " + cpfAcomp
                + "\n"
                + "\n"
                + data.getTime()
                + "\n"
                + "\n"
                + "_______________________________"
                + "\n" + medico.getGerenciarProntuarios().getLista().get(prontuario).getMedico()
                + "\nCRM";
        return this.relatorio;
    }

    public String gerarClientesAtendidosMes() {
        Calendar calendario = Calendar.getInstance();

        if (medico.getGerenciarProntuarios().getLista().size() == 0) {
            this.relatorio = "\nNão existem consultas cadastradas";
        } else {
            int contador = 0;
            for (Prontuario prontuario : medico.getGerenciarProntuarios().getLista()) {
                if (Datas.formatoDataMesAno.format(calendario.getTime()).equals(Datas.formatoDataMesAno.format(prontuario.getData()))) {
                    this.relatorio += prontuario.toString() + "\n";
                    contador++;
                }
            }

            if (contador == 0) {
                this.relatorio = "Não existem consultas neste mes";
            }
        }

        return this.relatorio;
    }

    public String gerarAtestado() {
        return this.relatorio = "\nAtesto para os devidos fins a pedido  que o Sr. (nome paciente),"
                + "\nincrito no CPF sob o nº (numero), paciente sob meus cuidados, foi atendido"
                + "\nno dia (data), ás (horario), apresentando quadro de (informar) e necessita"
                + "\n de (quantidade) dias  de repouso"
                + "\n(numero)"
                + "\n"
                + "\n"
                + "localidade,  dia de mes de ano"
                + "\n"
                + "\n"
                + "_______________________________"
                + "\nnome do medico"
                + "\nCRM";
    }

}
