package mensagens;

import dados.Dados;
import datas.Datas;
import java.util.Calendar;
import secretaria.Consulta;
import secretaria.Paciente;

public class GerenciadorMensagens {

    /**
     *
     * @param opcao true caso queira enviar emails, false para enviar SMS's
     *
     * @param numDias Quantidade de dias que faltam para a consulta
     */
    public void enviarMensagens(boolean opcao, int numDias) {
        Calendar calendario = Calendar.getInstance(); //Intancia um calendario
        calendario.add(Calendar.DATE, numDias); //Adiciona numDias dia(s) a data de hoje

        if (opcao) {
            for (Consulta consulta : Dados.listaConsultas) {
                //Se paciente tem Email
                if (consulta.getPaciente().getEmail().length() > 0) {
                    if (Datas.formatoData.format(calendario.getTime()).equals(Datas.formatoData.format(consulta.getData()))) {
                        enviarEmail(consulta.getPaciente(), consulta);
                    }
                }
            }
        } else {
            for (Consulta consulta : Dados.listaConsultas) {
                //Se paciente tem Celular
                if (consulta.getPaciente().getTelefoneCelular().length() > 0) {
                    if (Datas.formatoData.format(calendario.getTime()).equals(Datas.formatoData.format(consulta.getData()))) {
                        enviarSms(consulta.getPaciente(), consulta);
                    }
                }

            }
        }
    }

    //Simulação da operação Enviar E-mail
    private void enviarEmail(Paciente paciente, Consulta consulta) {
        Email email = new Email();
        String mensagem = "Prezado(a) paciente " + paciente.getNome()
                + "\nA clínica Saúde & Cia vem por meio desta mensagem"
                + "\nlembra-lo(a) de que sua consulta está agendada para"
                + "\n" + Datas.formatoData.format(consulta.getData()) + " as " + consulta.getHorario() + ".";
        email.setMensagem(mensagem);
        System.out.println("E-mail enviado para " + paciente.getEmail()
                + " (" + paciente.getNome() + ")");
    }

    //Simulação da operação Enviar SMS
    private void enviarSms(Paciente paciente, Consulta consulta) {
        Sms sms = new Sms();
        String mensagem = "Clínica Saúde & Cia"
                + "\n" + paciente.getNome() + " sua consulta está agendada para"
                + "\n" + Datas.formatoData.format(consulta.getData()) + " as " + consulta.getHorario() + ".";
        sms.setMensagem(mensagem);
        System.out.println("SMS enviado para " + paciente.getTelefoneCelular()
                + " (" + paciente.getNome() + ")");
    }
}
