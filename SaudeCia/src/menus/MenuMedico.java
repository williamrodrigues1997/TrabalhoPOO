package menus;

import dados.Datas;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import medicos.Medico;
import secretaria.Consulta;
import secretaria.Convenio;
import secretaria.Paciente;
import secretaria.Secretaria;
import secretaria.TipoConsulta;

public class MenuMedico extends Menu {

    //Atributos
    private final Medico medico = new Medico();
    private final Secretaria secretaria = new Secretaria();
    private int prontuario;
    //Metodos
    @Override
    public void executarMenu() {
        try {
            secretaria.getGerenciarPacientes().inserir("teste1", "06197312905", "100722291", Datas.formatoData.parse("12/12/1212"), "enderecoteste1", "999999999", "asd@cvb.com", Convenio.PARTICULAR);
            secretaria.getGerenciarPacientes().inserir("teste2", "06197312805", "100721191", Datas.formatoData.parse("13/14/1212"), "enderecoteste2", "888888888", "asdrp@cvb.com", Convenio.PLANO_DE_SAUDE);

            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("23/05/2018"), "9:30", "Dr.123", secretaria.getGerenciarPacientes().getLista().get(0), TipoConsulta.NORMAL);
            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("23/05/2018"), "10:30", "Dr.123", secretaria.getGerenciarPacientes().getLista().get(1), TipoConsulta.NORMAL);
            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("22/05/2018"), "9:30", "Dr.123", secretaria.getGerenciarPacientes().getLista().get(0), TipoConsulta.RETORNO);
            
            System.out.println("Dados inseridos com sucesso");
            
        } catch (Exception e) {
            System.err.println("Erro Misterioso");
        }

        printCabecalho();
        while (true) {
            printMenu();
            int opcao = solicitaOpcaoMenu();
            executarAcao(opcao);
        }
    }

    @Override
    void printCabecalho() {
        System.out.println("Desenvolvido por: William Rodrigues e Ronny Adel");
        System.out.println("+-----------------------------------+");
        System.out.println("|       Bem-Vindo ao Sistema        |");
        System.out.println("|        Clínica Saúde&Cia          |");
        System.out.println("|       Acesso como: Médico         |");
        System.out.println("+-----------------------------------+");

    }

    @Override
    void printMenu() {
        criarBorda("Escolha a opção desejada");
        System.out.println("1) Cadastrar Dados Adicionais Paciente");
        System.out.println("2) Editar Dados Adicionais Paciente");
        System.out.println("3) Excluir Dados Adicionais Paciente");
        System.out.println("4) Cadastrar Prontuário");
        System.out.println("5) Editar Prontuário");
        System.out.println("6) Excluir Prontuário");
        System.out.println("7) Gerar Receita Médica");
        System.out.println("8) Gerar Atestado Médico");
        System.out.println("9) Gerar Declaração de Acompanhamento");
        System.out.println("10) Gerar Relatório de Clientes Atendidos no mês");
        System.out.println("0) Sair do sistema");
    }

    @Override
    int solicitaOpcaoMenu() {

        int opcao = -1;
        do {
            System.out.print("Opção escolhida: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Apenas números.");
            }
            if (opcao < 0 || opcao > 10) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 0 || opcao > 10);
        return opcao;
    }

    @Override
    void executarAcao(int opcao) {
        switch (opcao) {
            case 0:
                System.out.println("\nObrigado por usar o Sistema.");
                System.exit(0);
                break;
            case 1:
                dadosAdicionais(prontuario);
                break;
            case 2:
                //Implementar
                break;
            case 3:
                //Implementar
                break;
            case 4:
                cadastrarProntuario();
                break;
            case 5:
                //Implementar
                break;
            case 6:
                //Implementar
                break;
            case 7:
                //Implementar
                break;
            case 8:
                //Implementar
                break;
            case 9:
                //Implementar
                break;
            case 10:
                //Implementar
                break;
            default:
                System.out.println("Erro desconhecido.");
        }
    }

    private void dadosAdicionais(int prontuario) {
        if (!medico.getGerenciarProntuarios().getLista().isEmpty()) {
            criarBorda("DADOS ADICIONAIS DO PACIENTE");
            Paciente paciente = medico.getGerenciarProntuarios().getLista().get(prontuario).getPaciente();

            System.out.println("Para as proximas respostas digite S ou N");
            boolean fuma = campoBooleanObrigatorio("Fuma? ");
            boolean bebe = campoBooleanObrigatorio("Bebe? ");
            boolean colesterol = campoBooleanObrigatorio("Colesterol? ");
            boolean diabete = campoBooleanObrigatorio("Diabete? ");
            boolean cardiaco = campoBooleanObrigatorio("Cardiaco? ");
            List<String> cirurgias = carregaListas("Cirurgia");
            List<String> alergias = carregaListas("Alergia");

            medico.getGerenciarDadosAdicionaisPacientes().inserir(paciente, fuma,
                    bebe, colesterol, diabete, cardiaco, cirurgias, alergias);
        } else {
            System.out.println("Não existem prontuarios iniciados");
        }

    }
    
    private void cadastrarProntuario(){
        if(!secretaria.getGerenciarConsultas().getLista().isEmpty()){
            listarConsultas();
        }else{
            System.out.println("Não existem consultas cadastradas");
        }
    }

    private boolean campoBooleanObrigatorio(String solicitando) {
        String campo;
        while (true) {
            System.out.print(solicitando);
            campo = leitor.nextLine();
            campo.toLowerCase();

            if (campo.length() == 0) {
                System.out.println("O campo " + solicitando.substring(0, solicitando.length() - 2)
                        + " é obrigatório.");
            } else {
                if (campo != "s" || campo != "n") {
                    System.out.println("Por favor responda com S ou N");
                } else {
                    if ("s".equals(campo)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    private List<String> carregaListas(String solicitando) {
        String opcao = "s";
        String resposta;
        List<String> lista = new ArrayList<>();
        System.out.println("Existe alguma " + solicitando + " a ser declarado?");
        resposta = leitor.next();

        if ("n".equals(resposta)) {
            return null;
        } else {
            System.out.println("Digite o nome da " + solicitando);
            resposta = leitor.next();
            lista.add(resposta);
            while ("s".equals(opcao)) {
                System.out.println("Existe mais alguma " + solicitando + "?");
                opcao = leitor.next();
                if ("s".equals(opcao)) {
                    System.out.println("Digite o nome da " + solicitando);
                    resposta = leitor.next();
                    lista.add(resposta);
                }
            }
        }

        return lista;
    }
    
    private void listarConsultas(){
        for (Consulta consulta : secretaria.getGerenciarConsultas().getLista()) {
            Calendar calendario = Calendar.getInstance();
            if(Datas.formatoData.format(consulta.getData()) == Datas.formatoData.format(calendario.getTime())){
                System.out.println(consulta.toString());
            }
        }
    }
}
