package gestao_mesas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestaoMesas {
    public static Mesa[] mesas;
    private static int totalMesas;
    private static final String filePath = "C://Users//pport//Desktop//ProjetoLP1//ProjetoLP1//src//FicheirosTXT//FicheirosMesas.txt";
    private static int contadorMesas;

    static {
        mesas = new Mesa[100];
        totalMesas = 0;
        contadorMesas = Lerficheiros.lerFicheiroMesas(filePath, mesas);
    }

    public GestaoMesas(int maxMesas) {
        mesas = new Mesa[maxMesas];
        totalMesas = 0;
    }

    public static Mesa[] GetMesas() {
    }

    public static void Menu() {
    }

    public boolean adicionarMesa(int numeroMesa, int capacidade) {
        if (totalMesas < mesas.length) {
            mesas[totalMesas] = new Mesa(numeroMesa, capacidade);
            totalMesas++;
            return true;
        }
        return false;
    }

    public void listarMesas() {
        for (int i = 0; i < totalMesas; i++) {
            System.out.println(mesas[i]);
        }
    }

    public int atribuirClientesAMesa(int numeroClientes) {
        for (int i = 0; i < totalMesas; i++) {
            if (!mesas[i].isOcupada() && mesas[i].getCapacidade() >= numeroClientes) {
                mesas[i].setOcupada(true);
                return mesas[i].getNumeroMesa();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n============================");
            System.out.println("       Gestão de Mesas      ");
            System.out.println("=============================");
            System.out.println("1- Exibir Total de Mesas");
            System.out.println("2- Editar Mesas");
            System.out.println("3- Opção 3");
            System.out.println("0- Sair");
            System.out.println("============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirMesas();
                    break;
                case 2:
                    editarFicheiroMesas(filePath, mesas, contadorMesas);
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
        if (contadorMesas == 0) {
            System.out.println("Não há mesas registradas.");
        } else {
            for (int i = 0; i < contadorMesas; i++) {
                System.out.println(mesas[i]);
            }
        }
    }

    public static void editarFicheiroMesas(String filePath, Mesa[] mesas, int contadorMesas) {
        Scanner scanner = new Scanner(System.in);

        if (contadorMesas == 0) {
            System.out.println("Nenhuma mesa encontrada.");
            return;
        }

        System.out.println("Escolha uma mesa para alterar seu estado:");
        for (int i = 0; i < contadorMesas; i++) {
            System.out.println(mesas[i].getNumeroMesa() + ". " + mesas[i]);
        }

        int numeroMesa = -1;
        boolean numeroValido = false;

        while (!numeroValido) {
            System.out.print("Digite o número da mesa que deseja alterar: ");

            if (scanner.hasNextInt()) {
                numeroMesa = scanner.nextInt();
                numeroValido = true;
            } else {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next();
            }
        }

        Mesa mesaEscolhida = null;
        for (int i = 0; i < contadorMesas; i++) {
            if (mesas[i] != null && mesas[i].getNumeroMesa() == numeroMesa) {
                mesaEscolhida = mesas[i];
                break;
            }
        }

        if (mesaEscolhida == null) {
            System.out.println("Mesa não encontrada!");
            return;
        }

        System.out.println("O estado atual da mesa " + numeroMesa + " é: " + (mesaEscolhida.isOcupada() ? "Ocupada" : "Livre"));

        System.out.print("Deseja realmente alterar o estado da mesa (sim/não)? ");
        scanner.nextLine();
        String confirmacao = scanner.nextLine().trim().toLowerCase();

        if (confirmacao.equals("sim")) {
            mesaEscolhida.setOcupada(!mesaEscolhida.isOcupada());
            System.out.println("O estado da mesa " + numeroMesa + " foi alterado para " + (mesaEscolhida.isOcupada() ? "Ocupada" : "Livre"));
            salvarAlteracoes(filePath, mesas, contadorMesas);
        } else {
            System.out.println("A alteração do estado foi cancelada.");
        }
    }

    public static void salvarAlteracoes(String filePath, Mesa[] mesas, int contadorMesas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < contadorMesas; i++) {
                if (mesas[i] != null) {
                    String linhaEditada = "Mesa" + mesas[i].getNumeroMesa() + ", " +
                            mesas[i].getCapacidade() + " lugares, " +
                            (mesas[i].isOcupada() ? "Ocupada" : "Livre");
                    writer.write(linhaEditada);
                    writer.newLine();
                }
            }
            System.out.println("Alterações salvas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o ficheiro: " + e.getMessage());
        }
    }

    public static Mesa[] getMesas() {
        return mesas;
    }
}