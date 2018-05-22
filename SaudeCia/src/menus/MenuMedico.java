package menus;

import medicos.Medico;

public class MenuMedico extends Menu{

    //Atributos
    private final Medico medico = new Medico();
    
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
                //Implementar
                break;
            case 2:
                //Implementar
                break;
            case 3:
                //Implementar
                break;
            case 4:
                //Implementar
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
    
    

}
