package menus;

import dados.Datas;
import java.text.ParseException;
import java.util.Scanner;
import medicos.Medico;
import medicos.RelatorioMedico;
import secretaria.Convenio;
import secretaria.Paciente;
import secretaria.RelatorioConsulta;
import secretaria.Secretaria;
import secretaria.TipoConsulta;

public class MenuSecretaria {

    //Atributos
    private boolean exit;
    private final Scanner leitor = new Scanner(System.in);
    private final Secretaria secretaria = new Secretaria();

    //Metodos
    public void executarMenu() throws ParseException {
        printCabecalho();
        while (!exit) {
            printMenu();
            int opcao = getOpcaoMenu();
            executarAcao(opcao);
        }
    }

    private void printCabecalho() {
        System.out.println("Desenvolvido por: William Rodrigues e Ronny Adel");
        System.out.println("+-----------------------------------+");
        System.out.println("|       Bem-Vindo ao Sistema        |");
        System.out.println("|        Clínica Saúde&Cia          |");
        System.out.println("|      Acesso como: Secretaria      |");
        System.out.println("+-----------------------------------+");

    }

    private void printMenu() {
        criarBorda("Escolha a opção desejada");
        System.out.println("1) Cadastrar Paciente");
        System.out.println("2) Editar Paciente");
        System.out.println("3) Excluir Paciente");
        System.out.println("4) Agendar Consulta");
        System.out.println("5) Editar Consulta");
        System.out.println("6) Excluir Consulta");
        System.out.println("7) Listar Pacientes Cadastrados");
        System.out.println("8) Gerar Relatórios de Consulta");
        System.out.println("0) Sair do sistema");
    }

    private int getOpcaoMenu() {

        int opcao = -1;
        do {
            System.out.print("Opção escolhida: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Apenas números.");
            }
            if (opcao < 0 || opcao > 8) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 0 || opcao > 8);
        return opcao;
    }

    private void executarAcao(int choice) throws ParseException {
        switch (choice) {
            case 0:
                System.out.println("Obrigado por usar o Sistema.");
                System.exit(0);
                break;
            case 1:
                cadastrarPaciente();
                break;
            case 2:
                Medico relatorio = new Medico();
                System.out.println(relatorio.getGerenciarRelatorios().gerarClientesAtendidosMes());
                break;
            case 3:
                //Implementar
                break;
            case 4:
                cadastrarConsulta();
                break;
            case 5:
                //Implementar
                break;
            case 6:
                //Implementar
                break;
            case 7:
                listarPacientes();
                break;
            case 8:
                gerarRelatorioConsultas();
                break;
            default:
                System.out.println("Erro desconhecido.");
        }
    }

    private void criarBorda(String mensagem) {
        System.out.println();
        int largura = mensagem.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (int i = 0; i < largura; ++i) {
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + mensagem + "   |");
        System.out.println(sb.toString());
    }

    private void cadastrarPaciente() throws ParseException {
        criarBorda("CADASTRO DE PACIENTE");
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("CPF: ");
        String cpf = leitor.nextLine();
        System.out.print("RG: ");
        String rg = leitor.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = leitor.nextLine();
        System.out.print("Endereço: ");
        String endereco = leitor.nextLine();
        System.out.print("Telefone Celular: ");
        String celular = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();
        Convenio conveio = getOpcaoConvenio();

        secretaria.getGerenciarPacientes().inserir(nome, cpf, rg, Datas.formatoData.parse(dataNascimento), endereco, celular, email, conveio);
        System.out.println("\nPaciente " + nome + " cadastrado com sucesso!");

    }

    private Convenio getOpcaoConvenio() {
        int opcao = -1;
        do {
            System.out.println("Selecione o convênio"
                    + "\n1) Particular"
                    + "\n2) Plano de Saúde");
            System.out.print("Opção: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Apenas números.");
            }
            if (opcao < 1 || opcao > 2) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 1 || opcao > 2);

        if (opcao == 1) {
            return Convenio.PARTICULAR;
        } else {
            return Convenio.PLANO_DE_SAUDE;
        }
    }

    private void listarPacientes() {
        criarBorda("PACIENTES CADASTRADOS");
        System.out.println("+----------------------------------------+");
        for (Paciente paciente : secretaria.getGerenciarPacientes().getLista()) {
            System.out.println(paciente.toString());
            System.out.println("+----------------------------------------+");
        }
    }

    private void gerarRelatorioConsultas() {
        criarBorda("RELATÓRIO DE CONSULTAS");
        int opcao = getOpcaoRelatorio();
        if (opcao == 1) {
            System.out.println(secretaria.getRelatorioConsulta().gerarRelatorio(true, 1));
        } else {
            System.out.println(secretaria.getRelatorioConsulta().gerarRelatorio(false, 1));
        }
    }

    private int getOpcaoRelatorio() {
        int opcao = -1;
        do {
            System.out.println("  Selecione o filtro desejado"
                    + "\n1) Pacientes COM info de contato"
                    + "\n2) Pacientes SEM info de contato");
            System.out.print("Opção: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Apenas números.");
            }
            if (opcao < 1 || opcao > 2) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 1 || opcao > 2);
        return opcao;
    }

    private void cadastrarConsulta() throws ParseException {
        if (secretaria.getGerenciarPacientes().getLista().size() != 0) {
            criarBorda("CADASTRO DE CONSULTA");
            System.out.print("Data: ");
            String data = leitor.nextLine();
            System.out.print("Horário: ");
            String horario = leitor.nextLine();
            System.out.print("Médico: ");
            String medico = leitor.nextLine();
            int IdPaciente = getOpcaoIdPaciente();
            Paciente paciente = secretaria.getGerenciarPacientes().getLista().get(IdPaciente - 1);
            TipoConsulta tipoConsulta = getOpcaoTipoConsulta();

            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse(data), horario, medico, paciente, tipoConsulta);
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("\nNão existem pacientes cadastrados,\n"
                    + " Adicione pelo menos um");
        }

    }

    private TipoConsulta getOpcaoTipoConsulta() {
        int opcao = -1;
        do {
            System.out.println("Selecione o tipo de consulta"
                    + "\n1) Consulta normal (1h)"
                    + "\n2) Consulta de retorno (30m)");
            System.out.print("Opção: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Apenas números.");
            }
            if (opcao < 1 || opcao > 2) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 1 || opcao > 2);

        if (opcao == 1) {
            return TipoConsulta.NORMAL;
        } else {
            return TipoConsulta.RETORNO;
        }
    }

    private int getOpcaoIdPaciente() {
        int IdPaciente = -1;
        do {
            System.out.print("ID do Paciente: ");
            try {
                IdPaciente = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Apenas números.");
            }
            if (IdPaciente < 1 || IdPaciente > secretaria.getGerenciarPacientes().getLista().size()) {
                System.out.println("ID inválido. Não está na lista.");
            }
        } while (IdPaciente < 1 || IdPaciente > secretaria.getGerenciarPacientes().getLista().size());

        return IdPaciente;
    }
}
