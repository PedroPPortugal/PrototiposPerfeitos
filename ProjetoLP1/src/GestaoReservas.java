import FicheirosTXT.LerFicheiros;

import java.io.*;
import java.util.Scanner;

public class GestaoReservas {

    public static void GestaReservasMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String caminhoFicheiro = "C:\\Users\\pport\\Desktop\\ProjetoLP1\\ProjetoLP1\\src\\FicheirosTXT\\FicheiroReservas.txt";

        do {
            System.out.println("\n============================");
            System.out.println("       Gestão de Reservas     ");
            System.out.println("=============================");
            System.out.println("1- Criar Reserva              ");
            System.out.println("2- Editar Reserva             ");
            System.out.println("3- Remover Reserva            ");
            System.out.println("0- Sair                       ");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    try {
                        criarReserva(caminhoFicheiro);
                    } catch (IOException e) {
                        System.out.println("Erro ao criar Reserva: " + e.getMessage());
                    }
                    break;

                case 2:
                   LerFicheiros.lerFicheiroReservas();
                    try {
                        editarReserva(caminhoFicheiro);
                    } catch (IOException e) {
                        System.out.println("Erro ao editar Reserva: " + e.getMessage());
                    }
                    break;

                case 3:
                    LerFicheiros.lerFicheiroReservas();
                    try {
                        removerReserva(caminhoFicheiro);
                    } catch (IOException e) {
                        System.out.println("Erro ao remover Reserva: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do Sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void criarReserva(String caminhoFicheiro) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira os detalhes da nova Reserva:");
        System.out.print("Nome da Reserva: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade de pessoas: ");
        int pessoas = scanner.nextInt();
        System.out.print("Horário da Reserva: ");
        int tempo = scanner.nextInt();

        String novaLinha = String.format("%s;%d;%d", nome, pessoas, tempo);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoFicheiro, true))) {
            bw.newLine();
            bw.write(novaLinha);
            System.out.println("Reserva adicionada com sucesso!");
        }
    }

    public static void editarReserva(String caminhoFicheiro) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da reserva que deseja editar: ");
        String nomeEditar = scanner.nextLine();

        File ficheiroOriginal = new File(caminhoFicheiro);
        File ficheiroTemp = new File("temp.txt");

        boolean encontrado = false;

        try (
                BufferedReader br = new BufferedReader(new FileReader(ficheiroOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiroTemp))
        ) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length > 0 && partes[0].equalsIgnoreCase(nomeEditar)) {
                    encontrado = true;
                    System.out.println("Reserva encontrada: " + linha);

                    // Solicita novos valores
                    System.out.print("Novo nome da reserva: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova quantidade de pessoas: ");
                    int novasPessoas = scanner.nextInt();
                    System.out.print("Novo horário da reserva: ");
                    int novoTempo = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha

                    // Nova linha formatada
                    String novaLinha = String.format("%s;%d;%d", novoNome, novasPessoas, novoTempo);
                    bw.write(novaLinha);
                } else {
                    bw.write(linha);
                }
                bw.newLine();
            }
        }

        // Substitui o ficheiro original pelo ficheiro atualizado
        if (ficheiroOriginal.delete() && ficheiroTemp.renameTo(ficheiroOriginal)) {
            if (encontrado) {
                System.out.println("Reserva editada com sucesso!");
            } else {
                System.out.println("Reserva não encontrada.");
            }
        } else {
            System.out.println("Erro ao atualizar o ficheiro.");
        }
    }

    public static void removerReserva(String caminhoFicheiro) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da reserva que deseja remover: ");
        String nomeRemover = scanner.nextLine();

        File ficheiroOriginal = new File(caminhoFicheiro);
        File ficheiroTemp = new File("temp.txt");

        boolean encontrado = false;

        try (
                BufferedReader br = new BufferedReader(new FileReader(ficheiroOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiroTemp))
        ) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length > 0 && partes[0].equalsIgnoreCase(nomeRemover)) {
                    encontrado = true;
                    System.out.println("Reserva removida: " + linha);
                    continue; // Pula a linha a ser removida
                }
                bw.write(linha);
                bw.newLine();
            }
        }

        // Substitui o ficheiro original pelo ficheiro atualizado
        if (ficheiroOriginal.delete() && ficheiroTemp.renameTo(ficheiroOriginal)) {
            if (encontrado) {
                System.out.println("Reserva removida com sucesso!");
            } else {
                System.out.println("Reserva não encontrada.");
            }
        } else {
            System.out.println("Erro ao atualizar o ficheiro.");
        }
    }
}
