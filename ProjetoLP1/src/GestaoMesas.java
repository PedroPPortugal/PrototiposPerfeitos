import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Scanner;

public class GestaoMesas {


    public static void MenuMesas() {

        // Caminho para o arquivo de mesas
        final String filePath = "C://Users//pport//Desktop//ProjetoLP1//ProjetoLP1//src//FicheirosTXT//FicheirosMesas.txt/";
        final int MAX_MESAS = 100; // Número máximo de mesas suportadas
        mesas.Mesa[] mesas = new mesas.Mesa[MAX_MESAS]; // Array para armazenar mesas
        int contadorMesas = Lerficheiros.lerFicheiroMesas(filePath,mesas); // Contador de mesas carregadas

        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Carrega as mesas do arquivo na inicialização
        int opcao;

        // Exibe o menu

        do {
            // Exibe o menu com um design mais atrativo
            System.out.println("\n============================");
            System.out.println("       Gestão de Mesas      ");
            System.out.println("============================= ");
            System.out.println("1-  Exibir Total de Mesas     ");
            System.out.println("2-   Editar Mesas            ");
            System.out.println("3-   Opção 3");
            System.out.println("0-   Sair");
            System.out.println("============================");
            System.out.print("Escolha uma opção: ");

            // Lê a opção do usuário
            opcao = scanner.nextInt();

            // Executa a ação correspondente
            switch (opcao) {
                case 1:
                    Lerficheiros.lerFicheiroMesas(filePath,mesas);
                    exibirMesas();
                    break;
                case 2:
                  editarFicheiroMesas(filePath,mesas,contadorMesas);
                  salvarAlteracoes(filePath, mesas, contadorMesas);
                    break;
                case 3:
                    System.out.println("Você escolheu a Opção 3.");
                    break;
                case 0:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }


    public static void exibirMesas() {
        final int MAX_MESAS = 100; // Defina o número máximo de mesas
        mesas.Mesa[] mesas = new mesas.Mesa[MAX_MESAS]; // Array fixo para armazenar as mesas
        int contadorMesas = 0; // Variável para contar o número de mesas adicionadas

        // Exibindo as mesas registradas
        if (contadorMesas == 0) {
            System.out.println("Não há mesas registradas.");
        } else {
            for (int i = 0; i < contadorMesas; i++) {
                System.out.println(mesas[i]);
            }
        }
    }

    public static void editarFicheiroMesas(String filePath, mesas.Mesa[] mesas, int contadorMesas) {
        Scanner scanner = new Scanner(System.in);

        if (contadorMesas == 0) {
            System.out.println("Nenhuma mesa encontrada.");
            return;
        }

        // Exibir as mesas para o usuário escolher
        System.out.println("Escolha uma mesa para alterar seu estado:");
        for (int i = 0; i < contadorMesas; i++) {
            System.out.println(mesas[i].getNumero() + ". " + mesas[i]);
        }

        // Solicitar o número da mesa
        int numeroMesa = -1;
        boolean numeroValido = false;

        while (!numeroValido) {
            System.out.print("Digite o número da mesa que deseja alterar: ");

            // Verifica se o próximo valor é um inteiro
            if (scanner.hasNextInt()) {
                numeroMesa = scanner.nextInt();
                numeroValido = true;
            } else {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        // Encontrar a mesa correspondente
        mesas.Mesa mesaEscolhida = null;
        for (int i = 0; i < contadorMesas; i++) {
            if (mesas[i] != null && mesas[i].getNumero() == numeroMesa) {
                mesaEscolhida = mesas[i];
                break;
            }
        }

        if (mesaEscolhida == null) {
            System.out.println("Mesa não encontrada!");
            return;
        }

        // Exibir o estado atual da mesa
        System.out.println("O estado atual da mesa " + numeroMesa + " é: " + mesaEscolhida.getEstado());

        // Perguntar se o usuário realmente deseja alterar o estado
        System.out.print("Deseja realmente alterar o estado da mesa (sim/não)? ");
        scanner.nextLine();  // Limpar o buffer
        String confirmacao = scanner.nextLine().trim().toLowerCase();

        if (confirmacao.equals("sim")) {
            // Alternar o estado da mesa
            String novoEstado = mesaEscolhida.getEstado().equalsIgnoreCase("ocupado") ? "livre" : "ocupado";
            mesaEscolhida.setEstado(novoEstado);
            System.out.println("O estado da mesa " + numeroMesa + " foi alterado para " + novoEstado);

            // Salvar as alterações no arquivo
            salvarAlteracoes(filePath, mesas, contadorMesas);
        } else {
            System.out.println("A alteração do estado foi cancelada.");
        }
    }

    // Método para salvar as alterações no arquivo
    public static void salvarAlteracoes(String filePath, mesas.Mesa[] mesas, int contadorMesas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {  // Substituir conteúdo do arquivo
            for (int i = 0; i < contadorMesas; i++) {
                if (mesas[i] != null) {
                    String linhaEditada = "Mesa" + mesas[i].getNumero() + ", " +
                            mesas[i].getLugares() + " lugares, " +
                            mesas[i].getEstado();
                    writer.write(linhaEditada);
                    writer.newLine();
                }
            }
            System.out.println("Alterações salvas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o ficheiro: " + e.getMessage());
        }
    }

}


