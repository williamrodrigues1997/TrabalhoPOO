package medicos;

import dados.Dados;
import datas.Datas;
import java.util.Calendar;

public class RelatorioMedico {

    //Atributos
    private String relatorio;

    //Construtor
    public RelatorioMedico() {
    }

    //Metodos
    public String getRelatorio() {
        return relatorio;
    }

    public String gerarReceita(Prontuario prontuario) {
        return this.relatorio = "\nMedico: " + prontuario.getMedico()
                + "\nPaciente: " + prontuario.getPaciente().getNome()
                + "\n"
                + "\nPrescrição: " + prontuario.getPrescricaoTratamento()
                + "\n"
                + "\nData: " + Datas.formatoData.format(prontuario.getData())
                + "\n"
                + "\n"
                + "_______________________________"
                + "\n" + prontuario.getMedico()
                + "\nCRM";
    }

    public String gerarDeclaracaoAcompanhante(Prontuario prontuario, String nomeAcomp, String cpfAcomp, String parentescoAcomp) {
        Calendar data = Calendar.getInstance();

        return this.relatorio
                = "\nAtesto para os devidos fins a pedido  que o Sr. " + prontuario.getPaciente().getNome() + ","
                + "\nincrito no CPF sob o nº" + prontuario.getPaciente().getCpf() + ", paciente sob meus"
                + "\ncuidados, foi atendido no dia " + data.DAY_OF_MONTH + " ,ás " + Datas.formatoHora.format(data.getTime()) + ", apresentando"
                + "\nquadro de " + prontuario.getDiagnosticoDoenca() + ","
                + "\ntendo sido acompanhado pelo seu " + parentescoAcomp + ","
                + "\nSr. " + nomeAcomp + ", inscrito no CPF sob o nº: " + cpfAcomp
                + "\n"
                + "\n"
                + Datas.formatoData.format(data.getTime())
                + "\n"
                + "\n"
                + "_______________________________"
                + "\n" + prontuario.getMedico()
                + "\nCRM";
    }

    public String gerarClientesAtendidosMes() {
        Calendar calendario = Calendar.getInstance();
        if (Dados.listaProntuarios.isEmpty()) {
            this.relatorio = "\nNão existem consultas cadastradas";
        } else {
            int contador = 0;
            for (Prontuario prontuario : Dados.listaProntuarios) {
                if (Datas.formatoDataMesAno.format(calendario.getTime()).equals(Datas.formatoDataMesAno.format(prontuario.getData()))) {
                    contador++;
                    this.relatorio += prontuario.toString() + "\n";
                }
            }

            if (contador == 0) {
                this.relatorio = "Não existem consultas neste mes";
            }
        }

        return this.relatorio;
    }

    public String gerarAtestado(Prontuario prontuario, int dias) {
        Calendar data = Calendar.getInstance();
        return this.relatorio
                = "\nAtesto para os devidos fins a pedido  que o Sr. " + prontuario.getPaciente().getNome() + ","
                + "\nincrito no CPF sob o nº " + prontuario.getPaciente().getCpf() + ", paciente sob meus"
                + "\ncuidados, foi atendido no dia" + data.DAY_OF_MONTH + ", ás " + Datas.formatoData.format(data.getTime()) + ", apresentando"
                + "\nquadro de " + prontuario.getDiagnosticoDoenca() + ""
                + "\ne necessita de " + dias + " dias  de repouso."
                + "\n"
                + "\n"
                + "localidade, " + data.DAY_OF_MONTH + " de " + data.MONTH + " de " + data.YEAR
                + "\n"
                + "\n"
                + "_______________________________"
                + "\n" + prontuario.getMedico()
                + "\nCRM";
    }

}
