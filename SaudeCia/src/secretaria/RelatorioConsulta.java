package secretaria;

import java.util.Calendar;
import dados.Dados;
import dados.Datas;

public class RelatorioConsulta {

    //Atributos
    private String relatorio;

    //Construtor
    public RelatorioConsulta() {
    }

    //Metodos
    public String getRelatorio() {
        return relatorio;

    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    /**
     * @param opcao true caso queria um relatório de pacientes COM informações
     * de contato; false caso queria um relatório de pacientes SEM infotmações
     * de contato.
     *
     * @param numDias quantidade de dias seguintes após o dia atual que o
     * relatório exibirá consultas referentes.
     *
     * @return Retorna um relatório (String) armazenado no atributo relatorio
     * das consultas agendadas para os numDias dias seguintes.
     */
    public String gerarRelatorio(boolean opcao, int numDias) {
        Calendar calendario = Calendar.getInstance(); //Intancia um calendario
        calendario.add(Calendar.DATE, numDias); //Adiciona numDias dia(s) a data de hoje

        if (opcao) {
            this.relatorio = "-------------------------------"
                    + "\n- Consultas para o dia seguinte"
                    + "\n- Pacientes COM Info de Contado";
            for (Consulta consulta : Dados.listaConsultas) {
                if ((consulta.getPaciente().getTelefoneCelular().length() > 0)
                        || (consulta.getPaciente().getEmail().length() > 0)) {
                    if (Datas.formatoData.format(calendario.getTime()).equals(Datas.formatoData.format(consulta.getData()))) {
                        this.relatorio += "\n-------------------------------\n" + consulta.toString();
                    }
                }
            }
            this.relatorio += "\n-------------------------------";
        } else {
            this.relatorio = "-------------------------------"
                    + "\n- Consultas para o dia seguinte"
                    + "\n- Pacientes SEM Info de Contado";
            for (Consulta consulta : Dados.listaConsultas) {
                if ((consulta.getPaciente().getTelefoneCelular().length() == 0)
                        && (consulta.getPaciente().getEmail().length() == 0)) {
                    if (Datas.formatoData.format(calendario.getTime()).equals(Datas.formatoData.format(consulta.getData()))) {
                        this.relatorio += "\n-------------------------------\n" + consulta.toString();
                    }
                }
            }
            this.relatorio += "\n-------------------------------";
        }
        return this.relatorio;
    }

}
