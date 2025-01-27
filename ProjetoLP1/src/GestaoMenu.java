import java.awt.*;
import java.io.*;
import java.util.Scanner;


public class GestaoMenu {


    public static void GestaoMenu() {

        Scanner scanner = new Scanner(System.in);
        int opcao;
        String caminhoFicheiro = "C:\\Users\\pport\\Desktop\\ProjetoLP1\\ProjetoLP1\\src\\FicheirosTXT\\FicheiroMenus.txt"; // Defina o caminho do ficheiro

        do {
            System.out.println("\n============================");
            System.out.println("       Gestão de Menus        ");
            System.out.println("============================= ");
            System.out.println("1- Criar Menus                ");
            System.out.println("2- Editar Menus               ");
            System.out.println("3- Remover Menus              ");
            System.out.println("0- Sair                       ");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {

                case 1:
                    try {
                        criarMenu(caminhoFicheiro); // Passar o caminho do ficheiro como parâmetro
                    } catch (IOException e) {
                        System.out.println("Erro ao criar menu: " + e.getMessage());
                    }
                    break;

                case 2:
                    Lerficheiros.LerFicheiroMenu();
                    System.out.println("Digite o prato que deseja editar:");
                    String nomeEditar = scanner.nextLine();
                    editarMenu();
                    break;

                case 3:
                    Lerficheiros.LerFicheiroMenu();
                    System.out.println("Digite o nome do prato que deseja remover: ");
                    String nomePrato = scanner.nextLine();
                    removerMenu(nomePrato);
                    break;

                case 0:
                    System.out.println("Saindo do Sistema");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public static void criarMenu(String caminhoFicheiro) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar informações do novo menu ao utilizador
        System.out.println("Insira os detalhes do novo menu:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Categoria (Entrada, Principal, Sobremesa): ");
        String categoria = scanner.nextLine();

        System.out.print("Preço de Custo: ");
        float precoCusto = Float.parseFloat(scanner.nextLine().replace(",", "."));

        System.out.print("Preço de Venda: ");
        float precoVenda = Float.parseFloat(scanner.nextLine().replace(",", "."));

        System.out.print("Tempo de Preparação (minutos): ");
        int tempoPreparacao = Integer.parseInt(scanner.nextLine());

        System.out.print("Tempo de Consumo (minutos): ");
        int tempoConsumo = Integer.parseInt(scanner.nextLine());

        System.out.print("Disponível (True/False): ");
        boolean estado = Boolean.parseBoolean(scanner.nextLine());

        // Criar a linha formatada para o ficheiro
        String novaLinha = String.format("%s;%s;%.2f;%.2f;%d;%d;%b",
                nome, categoria, precoCusto, precoVenda, tempoPreparacao, tempoConsumo, estado);

        boolean ficheiroVazio;
        try (Scanner fileScanner = new Scanner(new java.io.File(caminhoFicheiro))) {
            ficheiroVazio = !fileScanner.hasNextLine(); // Verifica se o ficheiro está vazio
        }

        // Escrever a nova linha no ficheiro
        try (FileWriter writer = new FileWriter(caminhoFicheiro, true)) {
            if (ficheiroVazio == false) {
                writer.write(System.lineSeparator()); // Adicionar uma quebra de linha somente se o ficheiro não estiver vazio
            }
            writer.write(novaLinha);
        }

        System.out.println("Novo menu adicionado com sucesso!");
    }


    public static void removerMenu( String nomePrato) {
            String caminhoFicheiro = "C://Users//pport//Desktop//ProjetoLP1//ProjetoLP1//src//FicheirosTXT//FicheiroMenus.txt";
            StringBuilder conteudoAtualizado = new StringBuilder();
            boolean encontrou = false;

            try (BufferedReader br = new BufferedReader(new FileReader(caminhoFicheiro))) {
                String linha;

                while ((linha = br.readLine()) != null) {
                    String[] partes = linha.split(";");

                    // Atribuindo valores a variáveis
                    String nome = partes[0];

                    // Verifica se o nome do prato é diferente do que queremos remover
                    if (!nome.equalsIgnoreCase(nomePrato)) {
                        conteudoAtualizado.append(linha).append(System.lineSeparator());
                    } else {
                        encontrou = true; // Marca que encontrou o prato
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
                return;
            }

            // Atualizar o ficheiro com o conteúdo modificado
            if (encontrou) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoFicheiro))) {
                    bw.write(conteudoAtualizado.toString());
                    System.out.println("O prato '" + nomePrato + "' foi removido com sucesso.");
                } catch (IOException e) {
                    System.err.println("Erro ao atualizar o ficheiro: " + e.getMessage());
                }
            } else {
                System.out.println("O prato '" + nomePrato + "' não foi encontrado no ficheiro.");
            }
        }
    private static void atualizarJornalRevista() {
        Scanner scanner = new Scanner(System.in);
        Lerficheiros.LerFicheiroMenu();
        System.out.print("Escolha o número do jornal/revista a atualizar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < Lerficheiros.LerFicheiroMenu().size()) {
            JornalRevista jr = jornaisRevistas.get(index);
            System.out.print("Novo Título (atual: " + jr.titulo + "): ");
            jr.titulo = scanner.nextLine();
            System.out.print("Nova Editora (atual: " + jr.editora + "): ");
            jr.editora = scanner.nextLine();
            System.out.print("Novo ISSN (atual: " + jr.issn + "): ");
            jr.issn = scanner.nextLine();
            System.out.print("Nova Data de Publicação (atual: " + jr.dataPublicacao + "): ");
            jr.dataPublicacao = scanner.nextLine();
            System.out.print("Nova Categoria (atual: " + jr.categoria + "): ");
            jr.categoria = scanner.nextLine();
            System.out.println("Jornal/Revista atualizado com sucesso");
        } else {
            System.out.println("Número inválido");
        }
}