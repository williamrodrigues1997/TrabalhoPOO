package menus;

import dados.Datas;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import secretaria.Consulta;
import secretaria.Convenio;
import secretaria.Paciente;
import secretaria.Secretaria;
import secretaria.TipoConsulta;

public class MenuSecretaria {

    //Atributos
    private boolean exit;
    private final Scanner leitor = new Scanner(System.in);
    private final Secretaria secretaria = new Secretaria();

    //Metodos
    public void executarMenu() {
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
        System.out.println("6) Desmarcar Consulta");
        System.out.println("7) Listar Pacientes Cadastrados");
        System.out.println("8) Listar Consultas Agendadas");
        System.out.println("9) Gerar Relatórios de Consulta");
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
            if (opcao < 0 || opcao > 9) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 0 || opcao > 9);
        return opcao;
    }

    private void executarAcao(int choice) {
        switch (choice) {
            case 0:
                System.out.println("\nObrigado por usar o Sistema.");
                System.exit(0);
                break;
            case 1:
                cadastrarPaciente();
                break;
            case 2:
                editarPaciente();
                break;
            case 3:
                excluirPaciente();
                break;
            case 4:
                cadastrarConsulta();
                break;
            case 5:
                editarConsulta();
                break;
            case 6:
                desmarcarConsulta();
                break;
            case 7:
                listarPacientes();
                break;
            case 8:
                listarConsultas();
                break;
            case 9:
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

    private void cadastrarPaciente() {
        criarBorda("CADASTRO DE PACIENTE");
        String nome = campoObrigatorioString("Nome: ");
        String cpf = campoObrigatorioString("CPF: ");
        String rg = campoObrigatorioString("RG: ");
        Date dataNascimento = getOpcaoData("Data de Nascimento: ");
        String endereco = campoObrigatorioString("Endereço: ");
        System.out.print("Telefone Celular: ");
        String celular = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();
        Convenio conveio = getOpcaoConvenio();

        secretaria.getGerenciarPacientes().inserir(nome, cpf, rg, dataNascimento, endereco, celular, email, conveio);
        System.out.println("\nPaciente " + nome + "\nCadastrado com sucesso!");

    }

    private Convenio getOpcaoConvenio() {
        int opcao = -1;
        do {
            System.out.println("Selecione o convênio:"
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
        if (!secretaria.getGerenciarPacientes().getLista().isEmpty()) {
            criarBorda("PACIENTES CADASTRADOS");
            System.out.println("+----------------------------------------+");
            for (Paciente paciente : secretaria.getGerenciarPacientes().getLista()) {
                System.out.println(paciente.toString());
                System.out.println("+----------------------------------------+");
            }
        } else {
            System.out.println("\nAinda não existem pacientes cadastrados no sistema.");
        }
    }

    private void listarConsultas() {
        if (!secretaria.getGerenciarConsultas().getLista().isEmpty()) {
            criarBorda("CONSULTAS AGENDADAS");
            System.out.println("+----------------------------------------+");
            for (Consulta consulta : secretaria.getGerenciarConsultas().getLista()) {
                System.out.println(consulta.toString());
                System.out.println("+----------------------------------------+");
            }
        } else {
            System.out.println("\nAinda não existem consultas cadastradas no sistema.");
        }
    }

    private void gerarRelatorioConsultas() {
        if (!secretaria.getGerenciarConsultas().getLista().isEmpty()) {
            criarBorda("RELATÓRIO DE CONSULTAS");
            int opcao = getOpcaoRelatorio();
            if (opcao == 1) {
                System.out.println(secretaria.getRelatorioConsulta().gerarRelatorio(true, 1));
            } else {
                System.out.println(secretaria.getRelatorioConsulta().gerarRelatorio(false, 1));
            }
        } else {
            System.out.println("\nAinda não existem consultas cadastradas no sistema.");
        }
    }

    private int getOpcaoRelatorio() {
        int opcao = -1;
        do {
            System.out.println("  Selecione o filtro desejado:"
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

    private void cadastrarConsulta() {
        if (!secretaria.getGerenciarPacientes().getLista().isEmpty()) {
            criarBorda("CADASTRO DE CONSULTA");
            Date data = getOpcaoData("Data: ");
            String horario = campoObrigatorioString("Horário: ");
            String medico = campoObrigatorioString("Médico: ");
            Paciente paciente = getOpcaoCpfPaciente();
            TipoConsulta tipoConsulta = getOpcaoTipoConsulta();

            secretaria.getGerenciarConsultas().inserir(data, horario, medico, paciente, tipoConsulta);
            System.out.println("\nConsulta agendada com sucesso!");
        } else {
            System.out.println("\nAinda não existem pacientes cadastrados no sistema,"
                    + "\nAdicione pelo menos um.");
        }

    }

    private TipoConsulta getOpcaoTipoConsulta() {
        int opcao = -1;
        do {
            System.out.println("Selecione o tipo de consulta:"
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

    private Paciente getOpcaoCpfPaciente() {
        Paciente paciente;
        String cpf;
        do {
            System.out.print("CPF do paciente: ");
            cpf = leitor.nextLine();
            paciente = secretaria.getGerenciarPacientes().getPacientePorCpf(cpf);
            if (paciente == null) {
                System.out.println("Nenhum resultado para o CPF " + cpf);
            }
        } while (paciente == null);

        return paciente;
    }

    private void excluirPaciente() {
        if (!secretaria.getGerenciarPacientes().getLista().isEmpty()) {
            criarBorda("EXCLUIR PACIENTE");
            Paciente paciente = getOpcaoCpfPaciente();
            System.out.println("\nTem certeza de que deseja excluir\n"
                    + "o pacente " + paciente.getNome() + " ?");
            int opcao = getOpcaoConfirmacao();
            if (opcao == 1) {
                System.out.println("\nPaciente " + paciente.getNome() + "\nexcluído do sistema.");
                secretaria.getGerenciarPacientes().remover(paciente.getId());
            } else {
                System.out.println("\nProcedimento de exclusão cancelado.");
            }
        } else {
            System.out.println("\nAinda não existem pacientes cadastrados no sistema.");
        }
    }

    private int getOpcaoConfirmacao() {
        int opcao = -1;
        do {
            System.out.println("\n1) Confrimar"
                    + "\n2) Cancelar");
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

    private void desmarcarConsulta() {
        if (!secretaria.getGerenciarConsultas().getLista().isEmpty()) {
            criarBorda("DESMARCAR CONSULTA");
            int idConsulta = getOpcaoIdConsulta();
            Consulta consulta = secretaria.getGerenciarConsultas().getLista().get(idConsulta - 1);

            System.out.println("\nTem certeza de que deseja desmarcar:\n"
                    + consulta.toString());
            int opcao = getOpcaoConfirmacao();
            if (opcao == 1) {
                System.out.println("\nConsulta desmarcada com sucesso.");
                secretaria.getGerenciarConsultas().remover(idConsulta);
            } else {
                System.out.println("\nProcedimento cancelado.");
            }
        } else {
            System.out.println("\nAinda não existem consultas cadastradas no sistema.");
        }
    }

    private int getOpcaoIdConsulta() {
        int idConsulta = -1;
        do {
            System.out.print("ID da Consulta: ");
            try {
                idConsulta = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Apenas números.");
            }
            if (idConsulta < 1 || idConsulta > secretaria.getGerenciarConsultas().getLista().size()) {
                System.out.println("ID inválido. Não está na lista.");
            }
        } while (idConsulta < 1 || idConsulta > secretaria.getGerenciarConsultas().getLista().size());

        return idConsulta;
    }

    private void editarPaciente() {
        if (!secretaria.getGerenciarPacientes().getLista().isEmpty()) {
            criarBorda("EDITAR PACIENTE");
            Paciente paciente = getOpcaoCpfPaciente();

            Integer id = paciente.getId();
            String nome = paciente.getNome();
            String cpf = paciente.getCpf();
            String rg = paciente.getRg();
            Date dataNascimento = paciente.getDataNascimento();
            String endereco = campoObrigatorioString("Endereço: ");
            System.out.print("Telefone Celular: ");
            String celular = leitor.nextLine();
            System.out.print("E-mail: ");
            String email = leitor.nextLine();
            Convenio conveio = getOpcaoConvenio();

            secretaria.getGerenciarPacientes().alterar(id, nome, cpf, rg, dataNascimento, endereco, celular, email, conveio);

            paciente = secretaria.getGerenciarPacientes().getLista().get(id - 1);
            System.out.println("\nPaciente editado com sucesso!"
                    + "\nDados atualizados:\n" + paciente.toString());
        } else {
            System.out.println("\nAinda não existem pacientes cadastrados no sistema.");
        }
    }

    private void editarConsulta() {
        if (!secretaria.getGerenciarConsultas().getLista().isEmpty()) {
            criarBorda("EDITAR CONSULTA");
            int idConsulta = getOpcaoIdConsulta();
            Consulta consulta = secretaria.getGerenciarConsultas().getLista().get(idConsulta - 1);

            Date data = getOpcaoData("Data: ");
            String horario = campoObrigatorioString("Horário: ");
            String medico = campoObrigatorioString("Médico: ");
            Paciente paciente = consulta.getPaciente();
            TipoConsulta tipoConsulta = consulta.getTipo();

            secretaria.getGerenciarConsultas().alterar(idConsulta, data, horario, medico, paciente, tipoConsulta);

            consulta = secretaria.getGerenciarConsultas().getLista().get(idConsulta - 1);
            System.out.println("\nConsulta editada com sucesso!"
                    + "\nDados atualizados:\n" + consulta.toString());
        } else {
            System.out.println("\nAinda não existem consultas cadastradas no sistema.");
        }
    }

    private Date getOpcaoData(String solicitando) {
        boolean sucesso = false;
        Date data = new Date();

        while (!sucesso) {
            System.out.print(solicitando);
            String dataString = leitor.nextLine();

            try {
                data = Datas.formatoData.parse(dataString);
                sucesso = true;
            } catch (ParseException ex) {
                System.out.println("Data inválida, digite no formato Dia/Mês/Ano");
            }
        }
        return data;
    }

    private String campoObrigatorioString(String solicitando) {
        String campo;
        while (true) {
            System.out.print(solicitando);
            campo = leitor.nextLine();
            if (campo.length() == 0) {
                System.out.println("O campo " + solicitando.substring(0, solicitando.length() - 2)
                        + " é obrigatório.");
            } else {
                break;
            }
        }
        return campo;
    }

}
