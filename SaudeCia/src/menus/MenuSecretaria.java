package menus;

import java.util.Date;
import secretaria.Consulta;
import secretaria.Convenio;
import secretaria.Paciente;
import secretaria.Secretaria;
import secretaria.TipoConsulta;

public class MenuSecretaria extends Menu {

    //Atributos
    private final Secretaria secretaria = new Secretaria();

    //Metodos
    @Override
    public void executarMenu() {
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
        System.out.println("|      Acesso como: Secretaria      |");
        System.out.println("+-----------------------------------+");

    }

    @Override
     void printMenu() {
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
            if (opcao < 0 || opcao > 9) {
                System.out.println("Opção inválida. Não está no menu.");
            }
        } while (opcao < 0 || opcao > 9);
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

    private void cadastrarPaciente() {
        criarBorda("CADASTRO DE PACIENTE");
        String nome = campoObrigatorioString("Nome: ");
        String cpf = campoObrigatorioString("CPF: ");
        String rg = campoObrigatorioString("RG: ");
        Date dataNascimento = solicitaData("Data de Nascimento: ");
        String endereco = campoObrigatorioString("Endereço: ");
        System.out.print("Telefone Celular: ");
        String celular = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();
        Convenio conveio = solicitaOpcaoConvenio();

        secretaria.getGerenciarPacientes().inserir(nome, cpf, rg, dataNascimento, endereco, celular, email, conveio);
        System.out.println("\nPaciente " + nome + "\nCadastrado com sucesso!");

    }

    private Convenio solicitaOpcaoConvenio() {
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
            int opcao = solicitaOpcaoRelatorio();
            if (opcao == 1) {
                System.out.println(secretaria.getRelatorioConsulta().gerarRelatorio(true, 1));
            } else {
                System.out.println(secretaria.getRelatorioConsulta().gerarRelatorio(false, 1));
            }
        } else {
            System.out.println("\nAinda não existem consultas cadastradas no sistema.");
        }
    }

    private int solicitaOpcaoRelatorio() {
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
            Date data = solicitaData("Data: ");
            String horario = campoObrigatorioString("Horário: ");
            String medico = campoObrigatorioString("Médico: ");
            Paciente paciente = solicitaPacienteCpf();
            TipoConsulta tipoConsulta = solicitaOpcaoTipoConsulta();

            secretaria.getGerenciarConsultas().inserir(data, horario, medico, paciente, tipoConsulta);
            System.out.println("\nConsulta agendada com sucesso!");
        } else {
            System.out.println("\nAinda não existem pacientes cadastrados no sistema,"
                    + "\nAdicione pelo menos um.");
        }

    }

    private TipoConsulta solicitaOpcaoTipoConsulta() {
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

    private Paciente solicitaPacienteCpf() {
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
            Paciente paciente = solicitaPacienteCpf();
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

    private void desmarcarConsulta() {
        if (!secretaria.getGerenciarConsultas().getLista().isEmpty()) {
            criarBorda("DESMARCAR CONSULTA");
            int idConsulta = solicitaIdConsulta();
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

    private int solicitaIdConsulta() {
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
            Paciente paciente = solicitaPacienteCpf();

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
            Convenio conveio = solicitaOpcaoConvenio();

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
            int idConsulta = solicitaIdConsulta();
            Consulta consulta = secretaria.getGerenciarConsultas().getLista().get(idConsulta - 1);

            Date data = solicitaData("Data: ");
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

}
