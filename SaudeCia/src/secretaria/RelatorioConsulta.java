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
     * @param opcao
     * true caso queria um relatório de pacientes COM informações de contato
     * false caso queria um relatório de pacientes SEM infotmações de contato
     * 
     * @return
     * Retorna um relatório (String) armazenado no atributo relatorio
     * das consultas agendadas para o dia seguinte
     */
    public String gerarRelatorio(boolean opcao) {
        Calendar calendario = Calendar.getInstance(); //Intancia um calendario
        calendario.add(Calendar.DATE, 1); //Adiciona 1 dia a data de hoje

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
        }else{
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
