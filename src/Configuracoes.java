import java.io.*;
import java.util.Scanner;

public class Configuracoes {
    private String caminhoFicheiros = "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS";
    private char separadorFicheiros;
    private int unidadesTempoPorDia;
    private int unidadesConsumoPrato;
    private double custoClienteNaoAtendido;
    private static final String CONFIG_FILE = "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS\\configuracoes.txt";
    private static final String SENHA_FILE = "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS\\Palavras-Passe\\senha.txt";

    public Configuracoes(String caminhoFicheiros, char separadorFicheiros, int unidadesTempoPorDia,
                         int unidadesConsumoPrato, double custoClienteNaoAtendido) {
        this.caminhoFicheiros = caminhoFicheiros;
        this.separadorFicheiros = separadorFicheiros;
        this.unidadesTempoPorDia = unidadesTempoPorDia;
        this.unidadesConsumoPrato = unidadesConsumoPrato;
        this.custoClienteNaoAtendido = custoClienteNaoAtendido;
    }

    public String carregarSenha() {
        File file = new File(SENHA_FILE);

        if (!file.exists()) {
            salvarSenha("admin123");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(SENHA_FILE))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao carregar a senha: " + e.getMessage());
            return "admin123";
        }
    }

    public void salvarSenha(String novaSenha) {
        try {
            File file = new File(SENHA_FILE);
            file.getParentFile().mkdirs();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(novaSenha);
            }
            Logs.registrar("Senha do administrador alterada.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a senha: " + e.getMessage());
        }
    }

    public void salvarConfiguracoes() {
        try {
            File file = new File(CONFIG_FILE);
            file.getParentFile().mkdirs();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(caminhoFicheiros + "\n");
                writer.write(separadorFicheiros + "\n");
                writer.write(unidadesTempoPorDia + "\n");
                writer.write(unidadesConsumoPrato + "\n");
                writer.write(custoClienteNaoAtendido + "\n");
            }
            Logs.registrar("Configurações salvas.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar configurações: " + e.getMessage());
        }
    }

    public void carregarConfiguracoes() {
        File file = new File(CONFIG_FILE);

        if (!file.exists()) {
            salvarConfiguracoes();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
            caminhoFicheiros = reader.readLine();
            separadorFicheiros = reader.readLine().charAt(0);
            unidadesTempoPorDia = Integer.parseInt(reader.readLine());
            unidadesConsumoPrato = Integer.parseInt(reader.readLine());
            custoClienteNaoAtendido = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            System.out.println("Erro ao carregar configurações: " + e.getMessage());
        }
    }

    public void exibirMenu(Scanner scanner) {
        System.out.print("Digite a senha para acessar o menu de configurações: ");
        String senhaDigitada = scanner.nextLine();
        String senhaCorreta = carregarSenha();

        if (!senhaDigitada.equals(senhaCorreta)) {
            System.out.println("Senha incorreta. Acesso negado.");
            return;
        }

        while (true) {
            System.out.println("\nMenu de Configurações:");
            System.out.println("1. Exibir configurações atuais");
            System.out.println("2. Alterar caminho dos ficheiros");
            System.out.println("3. Alterar separador dos ficheiros");
            System.out.println("4. Alterar unidades de tempo por dia");
            System.out.println("5. Alterar unidades de consumo por prato");
            System.out.println("6. Alterar custo por cliente não atendido");
            System.out.println("7. Alterar senha do administrador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(this);
                    break;
                case 2:
                    System.out.print("Novo caminho dos ficheiros: ");
                    caminhoFicheiros = scanner.nextLine();
                    Logs.registrar("Caminho dos ficheiros alterado para: " + caminhoFicheiros);
                    break;
                case 3:
                    System.out.print("Novo separador dos ficheiros: ");
                    separadorFicheiros = scanner.nextLine().charAt(0);
                    Logs.registrar("Separador dos ficheiros alterado para: " + separadorFicheiros);
                    break;
                case 4:
                    System.out.print("Novas unidades de tempo por dia: ");
                    unidadesTempoPorDia = scanner.nextInt();
                    scanner.nextLine();
                    Logs.registrar("Unidades de tempo por dia alteradas para: " + unidadesTempoPorDia);
                    break;
                case 5:
                    System.out.print("Novas unidades de consumo por prato: ");
                    unidadesConsumoPrato = scanner.nextInt();
                    scanner.nextLine();
                    Logs.registrar("Unidades de consumo por prato alteradas para: " + unidadesConsumoPrato);
                    break;
                case 6:
                    System.out.print("Novo custo por cliente não atendido: ");
                    custoClienteNaoAtendido = scanner.nextDouble();
                    scanner.nextLine();
                    Logs.registrar("Custo por cliente não atendido alterado para: " + custoClienteNaoAtendido);
                    break;
                case 7:
                    System.out.print("Digite a nova senha de administrador: ");
                    String novaSenha = scanner.nextLine();
                    salvarSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            // Salvar as novas configurações após cada alteração
            salvarConfiguracoes();
        }
    }

    @Override
    public String toString() {
        return "Configuracoes{" +
                "caminhoFicheiros='" + caminhoFicheiros + '\'' +
                ", separadorFicheiros=" + separadorFicheiros +
                ", unidadesTempoPorDia=" + unidadesTempoPorDia +
                ", unidadesConsumoPrato=" + unidadesConsumoPrato +
                ", custoClienteNaoAtendido=" + custoClienteNaoAtendido +
                '}';
    }
}
