import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instancia o objeto de configurações e carrega as configurações a partir do arquivo
        Configuracoes configuracoes = new Configuracoes(
                "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS",
                ';',
                24,
                2,
                5.50
        );
        configuracoes.carregarConfiguracoes(); // Carregar configurações a partir do arquivo

        Logs.registrar("Aplicação iniciada.");

        while (true) {
            System.out.println("\n==== Menu Principal ====");
            System.out.println("1. Gerir Mesas e Menus");
            System.out.println("2. Gerir Dia-a-Dia");
            System.out.println("3. Consultar Estatísticas e Desempenho Financeiro");
            System.out.println("4. Configurações");
            System.out.println("5. Exibir Logs");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Gerenciando Mesas e Menus...");
                    Logs.registrar("Acessado gerenciamento de Mesas e Menus.");
                    break;
                case 2:
                    System.out.println("Gerenciando Dia-a-Dia...");
                    Logs.registrar("Acessado gerenciamento do Dia-a-Dia.");
                    break;
                case 3:
                    System.out.println("Consultando Estatísticas e Desempenho Financeiro...");
                    Logs.registrar("Acessado consulta de Estatísticas e Desempenho Financeiro.");
                    break;
                case 4:
                    configuracoes.exibirMenu(scanner); // Acessa o menu de configurações
                    break;
                case 5:
                    Logs.exibirLogs();
                    break;
                case 0:
                    Logs.registrar("Aplicação encerrada.");
                    System.out.println("A sair...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
