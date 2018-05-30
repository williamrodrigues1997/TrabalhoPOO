package menus;

import datas.Datas;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Super classe Menu com operações úteis para os demais Menus do sistema.
 */
public abstract class Menu {

    //Atributos
    /**
     * Scanner utilizado para leitura de informações atravez da porta de entrada
     * padrão do sistema do usuário
     */
    protected final Scanner leitor = new Scanner(System.in);

    //Métodos
    /**
     * Método utilizado para destacar titulos de operações nos Menus
     *
     * @param mensagem String que será impressa com uma borda
     */
    protected void criarBorda(String mensagem) {
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

    /**
     * Método utilizado para obter confirmação de determinada ação do usuário
     *
     * @return 1 caso o usuário queria confirmar 2 caso o usuário queria
     * cancelar a operação
     */
    protected int getOpcaoConfirmacao() {
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

    /**
     * Método utilizado para solicitar/tratar inserção de datas do usuário
     *
     * @param solicitando String que será exibida solicitando ao usuário uma
     * data por exemplo "Data de nascimento: " ou "Data: "
     *
     * @return Retorna um objeto do tipo Date referente a string informada pelo
     * usuário
     */
    protected Date solicitaData(String solicitando) {
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

    /**
     * Método utilizado para solicitar um campo obrigatório do tipo String
     *
     * @param solicitando String que será exibida solicitando ao usuário uma
     * informação por exemplo: "Nome: " ou "Endereço: "
     *
     * @return Retorna uma String com o campo informado pelo usuário
     */
    protected String campoObrigatorioString(String solicitando) {
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

    //Métodos Abstratos (Precisam ser implementados obbrigatóriamente)
    abstract void executarMenu();

    abstract void printCabecalho();

    abstract void printMenu();

    abstract int solicitaOpcaoMenu();

    abstract void executarAcao(int opcao);
}
