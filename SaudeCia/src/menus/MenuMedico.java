package menus;

import dados.Datas;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import medicos.DadosAdicionaisPaciente;
import medicos.Medico;
import medicos.Prontuario;
import secretaria.Consulta;
import secretaria.Convenio;
import secretaria.Paciente;
import secretaria.Secretaria;
import secretaria.TipoConsulta;

public class MenuMedico extends Menu {

    //Atributos
    private final Medico medico = new Medico();
    private final Secretaria secretaria = new Secretaria();

    //Metodos
    @Override
    public void executarMenu() {
        try {
            secretaria.getGerenciarPacientes().inserir("teste1", "06197312905", "100722291", Datas.formatoData.parse("12/12/1212"), "enderecoteste1", "999999999", "asd@cvb.com", Convenio.PARTICULAR);
            secretaria.getGerenciarPacientes().inserir("teste2", "06197312805", "100721191", Datas.formatoData.parse("13/14/1212"), "enderecoteste2", "888888888", "asdrp@cvb.com", Convenio.PLANO_DE_SAUDE);

            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("28/05/2018"), "9:30", "Dr.123", secretaria.getGerenciarPacientes().getLista().get(0), TipoConsulta.NORMAL);
            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("29/05/2018"), "10:30", "Dr.123", secretaria.getGerenciarPacientes().getLista().get(1), TipoConsulta.NORMAL);
            secretaria.getGerenciarConsultas().inserir(Datas.formatoData.parse("29/05/2018"), "9:30", "Dr.123", secretaria.getGerenciarPacientes().getLista().get(0), TipoConsulta.RETORNO);

        } catch (ParseException e) {
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
        System.out.println("3) Cadastrar Prontuário");
        System.out.println("4) Editar Prontuário");
        System.out.println("5) Excluir Prontuário");
        System.out.println("6) Gerar Receita Médica");
        System.out.println("7) Gerar Atestado Médico");
        System.out.println("8) Gerar Declaração de Acompanhamento");
        System.out.println("9) Gerar Relatório de Clientes Atendidos no mês");
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
                insereDadosAdicionais();
                break;
            case 2:
                editaDadosAdicionais();
                break;
            case 3:
                cadastrarProntuario();
                break;
            case 4:
                editaProntuario();
                break;
            case 5:
                excluiProntuario();
                break;
            case 6:
                gerarReceitaMedica();
                break;
            case 7:
                gerarAtestadoMedico();
                break;
            case 8:
                gerarDeclaracaoAcompanhante();
                break;
            case 9:
                gerarRelatorioPassienteAtendidoMes();
                break;
            default:
                System.out.println("Erro desconhecido.");
        }
    }

    //Concluido
    private void insereDadosAdicionais() {
        if (!secretaria.getGerenciarPacientes().getLista().isEmpty()) {
            criarBorda("DADOS ADICIONAIS DO PACIENTE");
            Paciente paciente = solicitaPacienteCpf();

            if (!checaListaDadosAdicionais(paciente)) {
                System.out.print("\nPara as proximas respostas digite S para afirmativo ou N para negativo\n");
                boolean fuma = campoBooleanObrigatorio("Fuma: ");
                boolean bebe = campoBooleanObrigatorio("Bebe: ");
                boolean colesterol = campoBooleanObrigatorio("Colesterol: ");
                boolean diabete = campoBooleanObrigatorio("Diabete: ");
                boolean cardiaco = campoBooleanObrigatorio("Cardiaco: ");
                List<String> cirurgias = carregaListas("Cirurgia");
                List<String> alergias = carregaListas("Alergia");

                medico.getGerenciarDadosAdicionaisPacientes().inserir(paciente, fuma,
                        bebe, colesterol, diabete, cardiaco, cirurgias, alergias);

                System.out.print("Paciente cadastrado com sucesso!!!\n");
            } else {
                System.out.println("\nPaciente ja possui dados adicionais inserido");
            }

        } else {
            System.out.println("Não existem pacientes cadastrados");
        }
    }

    private void editaDadosAdicionais() {
        if (!medico.getGerenciarDadosAdicionaisPacientes().getLista().isEmpty()) {
            criarBorda("EDITAR DADOS ADICIONAIS");
            Paciente paciente = solicitaPacienteCpf();

            DadosAdicionaisPaciente dadosAdicionais = medico.getGerenciarDadosAdicionaisPacientes().buscaDadosId(paciente.getId());

            int opcao = -1;
            menuEditarDadosAdicionais(opcao, dadosAdicionais);

        } else {
            System.out.println("Nenhum paciente possui dados adicionais inserido!");
        }

    }

    private void cadastrarProntuario() {
        if (!secretaria.getGerenciarConsultas().getLista().isEmpty()) {
            listarConsultas();
            String cpf;
            System.out.println("Digite o CPF do paciente no qual a consulta será executada");
            cpf = leitor.next();

            Paciente paciente = secretaria.getGerenciarPacientes().getPacientePorCpf(cpf);
            if (!paciente.equals(null)) {
                Date data = solicitaData("Data: ");
                String nomeMedico = campoObrigatorioString("Medico: ");
                String sintomas = campoObrigatorioString("Sintomas: ");
                String diagnosticoDoenca = campoObrigatorioString("Diagnóstico: ");
                String prescricaoTratamento = campoObrigatorioString("Prescrição: ");

                medico.getGerenciarProntuarios().inserir(data, nomeMedico, paciente, sintomas, diagnosticoDoenca, prescricaoTratamento);
                System.out.println("Prontuario do Paciente " + paciente.getNome() + " foi executado com sucesso!");
            } else {
                System.out.println("Paciente não encontrado");
            }

        } else {
            System.out.println("Não existem consultas cadastradas");
        }
    }

    private void editaProntuario() {

    }

    private void excluiProntuario() {
        if (!medico.getGerenciarProntuarios().getLista().isEmpty()) {
            criarBorda("EXCLUIR PRONTUARIO");
            Paciente paciente = solicitaPacienteCpf();
            Prontuario prontuario = medico.getGerenciarProntuarios().buscarProntuarioPorCpf(paciente.getCpf());
            for (Prontuario p : medico.getGerenciarProntuarios().getLista()) {
                if (p.getPaciente().getCpf().equals(prontuario.getPaciente().getCpf())) {
                    System.out.println(p.toString());
                }
            }
            System.out.print("\nDigite o ID do prontuario que deseja excluir\n");
            System.out.print("ID: ");
            int id = leitor.nextInt();

            System.out.println("\nTem certeza de que deseja excluir\n"
                    + "o prontuario do paciente " + paciente.getNome() + " ?");
            int opcao = getOpcaoConfirmacao();
            if (opcao == 1) {
                System.out.println("\nProntuario do paciente " + paciente.getNome() + "\nexcluído do sistema.");
                medico.getGerenciarProntuarios().remover(id);
            } else {
                System.out.println("\nProcedimento de exclusão cancelado.");
            }
        } else {
            System.out.println("\nAinda não existem prontuarios cadastrados no sistema.");

        }
    }

    private void gerarReceitaMedica() {
        if (!medico.getGerenciarProntuarios().getLista().isEmpty()) {
            String cpf;
            System.out.println("Digite o cpf do Paciente a ser gerado a receita");
            cpf = leitor.next();
            Prontuario prontuario = medico.getGerenciarProntuarios().buscarProntuarioPorCpf(cpf);
            if (prontuario == null) {
                System.out.println("cpf inexistente");
            } else {
                criarBorda("RECEITA MEDICA");
                System.out.println(medico.getGerenciarRelatorios().gerarReceita(prontuario));
            }

        }
    }

    private void gerarDeclaracaoAcompanhante() {
        if (!medico.getGerenciarProntuarios().getLista().isEmpty()) {
            String cpf;
            System.out.println("Digite o cpf do Paciente a ser gerado a receita");
            cpf = leitor.next();
            Prontuario prontuario = medico.getGerenciarProntuarios().buscarProntuarioPorCpf(cpf);
            if (prontuario == null) {
                System.out.println("cpf inexistente");
            } else {
                criarBorda("DECLARACAO DE ACOMPANHANTE");
                System.out.print(medico.getGerenciarRelatorios().gerarDeclaracaoAcompanhante(prontuario, "teste21", "06694310202", "Pai"));
            }
        }
    }

    private void gerarAtestadoMedico() {
        if (!medico.getGerenciarProntuarios().getLista().isEmpty()) {
            String cpf;
            System.out.println("Digite o cpf do Paciente a ser gerado a receita");
            cpf = leitor.next();
            Prontuario prontuario = medico.getGerenciarProntuarios().buscarProntuarioPorCpf(cpf);
            if (prontuario == null) {
                System.out.println("cpf inexistente");
            } else {
                criarBorda("DECLARACAO DE ACOMPANHANTE");
                System.out.print(medico.getGerenciarRelatorios().gerarAtestado(prontuario, 120));
            }
        }
    }

    private void gerarRelatorioPassienteAtendidoMes() {
        System.out.print(medico.getGerenciarRelatorios().gerarClientesAtendidosMes());
    }

    //Metodos Auxiliares.
    private boolean campoBooleanObrigatorio(String solicitando) {
        String campo;
        while (true) {
            System.out.print(solicitando);
            campo = leitor.nextLine().toLowerCase();

            if (campo.length() == 0) {
                System.out.println("O campo " + solicitando.substring(0, solicitando.length() - 2)
                        + " é obrigatório.");
            } else {
                if ("s".equals(campo) || "n".equals(campo)) {
                    return "s".equals(campo);
                } else {
                    System.out.println("Por favor responda com S ou N");
                }
            }
        }
    }

    private List<String> carregaListas(String solicitando) {
        List<String> lista = new ArrayList<>();
        System.out.println("O paciente tem alguma " + solicitando + " que gostaria de inserir?");
        System.out.println("Responda \"Sim\" para adicionar ou precione qualquer tecla para sair");
        System.out.print("resposta: ");
        String resposta;
        resposta = leitor.nextLine().toLowerCase();

        if (resposta.equals("sim")) {
            System.out.println("Precione \"ENTER\" para sair\n");
            while (!"".equals(resposta)) {
                System.out.print("Digite o nome da " + solicitando + ": ");
                resposta = leitor.nextLine();
                if (!"".equals(resposta)) {
                    lista.add(resposta);
                } else {
                    System.out.print("\n");
                }
            }
        }
        return lista;
    }

    private void listarConsultas() {
        for (Consulta consulta : secretaria.getGerenciarConsultas().getLista()) {
            Calendar calendario = Calendar.getInstance();
            if (Datas.formatoData.format(calendario.getTime()).equals(Datas.formatoData.format(consulta.getData()))) {
                System.out.println(consulta.toString() + "\n");
            }
        }
    }

    private String booleanToString(boolean atributo) {

        if (atributo) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    private void menuEditarDadosAdicionais(int opcao, DadosAdicionaisPaciente dadosAdicionais) {
        boolean fuma = dadosAdicionais.isFuma();
        boolean bebe = dadosAdicionais.isBebe();
        boolean diabete = dadosAdicionais.isDiabete();
        boolean colesterol = dadosAdicionais.isColesterol();
        boolean cardiaco = dadosAdicionais.isDoencaCardiaca();
        List<String> cirurgias = dadosAdicionais.getCirurgias();
        List<String> alergias = dadosAdicionais.getAlergias();

        while (opcao != 0) {
            System.out.print("\n1-Fuma: " + booleanToString(dadosAdicionais.isFuma())
                    + "\n2-Bebetzzn: " + booleanToString(dadosAdicionais.isBebe())
                    + "\n3-Colesterol: " + booleanToString(dadosAdicionais.isColesterol())
                    + "\n4-Diabete: " + booleanToString(dadosAdicionais.isDiabete())
                    + "\n5-Cardiaco: " + booleanToString(dadosAdicionais.isDoencaCardiaca()));
            if (dadosAdicionais.getCirurgias() == null) {
                System.out.print("\n6-Cirurgias: Não existem cirurgias cadastradas para este paciente");
            } else {
                System.out.print("\n6-Cirurgias: " + dadosAdicionais.getCirurgias().toString());
            }

            if (dadosAdicionais.getAlergias() == null) {
                System.out.print("\n7-Alergias: Não existem alergias cadastradas para este paciente");
            } else {
                System.out.print("\n7-Alergias: " + dadosAdicionais.getAlergias());
            }
            System.out.print("\n0-Sair\n");
            System.out.println("\nDigite o numero referente a qual atributo será alterado");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um novo valor para 'Fuma'");
                    fuma = campoBooleanObrigatorio("Fuma? ");

                    break;
                case 2:
                    System.out.println("Digite um novo valor para 'Bebe'");
                    bebe = campoBooleanObrigatorio("Bebe? ");

                    break;
                case 3:
                    System.out.println("Digite um novo valor para 'Colesterol'");
                    colesterol = campoBooleanObrigatorio("Colesterol? ");

                    break;
                case 4:
                    System.out.println("Digite um novo valor para 'Diabete'");
                    diabete = campoBooleanObrigatorio("Diabete? ");

                    break;
                case 5:
                    System.out.println("Digite um novo valor para 'Cardiaco'");
                    cardiaco = campoBooleanObrigatorio("Cardiaco? ");

                    break;
                case 6:
                    int acaoCirurgia = -1;
                    while (acaoCirurgia != 0) {
                        System.out.println("O que deseja fazer?"
                                + "\n1-Alterar"
                                + "\n2-Incluir"
                                + "\n0-Sair");
                        acaoCirurgia = leitor.nextInt();
                        switch (acaoCirurgia) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Digite o nome da Cirurgia a ser alterada");
                                String alterarCirurgia = leitor.next();
                                if (cirurgias.contains(alterarCirurgia)) {
                                    int i = 0;
                                    for (String nome : cirurgias) {
                                        if (alterarCirurgia.equals(nome)) {
                                            System.out.println("Digite o novo nome");
                                            alterarCirurgia = leitor.next();
                                            cirurgias.set(i, alterarCirurgia);
                                            break;
                                        }
                                        i++;
                                    }
                                } else {
                                    System.out.println("Cirurgia não cadastrada");
                                }

                                break;
                            case 2:
                                cirurgias = carregaListas("Cirurgia");
                                break;
                            default:
                                System.out.println("Opção não existe");
                        }
                    }

                    break;
                case 7:
                    int acaoAlergia = -1;
                    while (acaoAlergia != 0) {
                        System.out.println("O que deseja fazer?"
                                + "\n1-Alterar"
                                + "\n2-Incluir"
                                + "\n0-Sair");
                        acaoAlergia = leitor.nextInt();
                        switch (acaoAlergia) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Digite o nome da Alergia a ser alterada");
                                String alterarAlergia = leitor.next();
                                if (alergias.contains(alterarAlergia)) {
                                    int i = 0;
                                    for (String nome : alergias) {
                                        if (alterarAlergia.equals(nome)) {
                                            System.out.println("Digite o novo nome");
                                            alterarAlergia = leitor.next();
                                            alergias.set(i, alterarAlergia);
                                            break;
                                        }
                                        i++;
                                    }
                                } else {
                                    System.out.println("Alergia não cadastrada");
                                }

                                break;
                            case 2:
                                alergias = carregaListas("Alergia: ");
                                break;
                            default:
                                System.out.println("Opção não existe");
                        }
                    }
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        medico.getGerenciarDadosAdicionaisPacientes().alterar(dadosAdicionais.getId(), fuma, bebe, colesterol, diabete, cardiaco, cirurgias, alergias);

    }

    private boolean checaListaDadosAdicionais(Paciente paciente) {
        if (medico.getGerenciarDadosAdicionaisPacientes().getLista().isEmpty()) {
            return false;
        } else {
            for (DadosAdicionaisPaciente dadosAdicionais : medico.getGerenciarDadosAdicionaisPacientes().getLista()) {
                return dadosAdicionais.getPaciente().getId().equals(paciente.getId());
            }
        }
        return true;
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
}
