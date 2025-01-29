import java.util.Scanner;

public class Menu{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuracoes configuracoes = new Configuracoes(
                "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS",
                ';',
                24,
                2,
                5.50,
                "admin123"
        );

        while (true) {
            System.out.println("\n==== Menu Principal ====");
            System.out.println("1. Gerir Mesas e Menus");
            System.out.println("2. Gerir Dia-a-Dia");
            System.out.println("3. Consultar Estatísticas e Desempenho Financeiro");
            System.out.println("4. Configurações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Gerenciando Mesas e Menus...");
                    // Chamar função para gerir mesas e menus
                    break;
                case 2:
                    System.out.println("Gerenciando Dia-a-Dia...");
                    // Chamar função para gerir logs e começar novo dia
                    break;
                case 3:
                    System.out.println("Consultando Estatísticas e Desempenho Financeiro...");
                    // Chamar função para estatísticas
                    break;
                case 4:
                    configuracoes.exibirMenu();
                    break;
                case 0:
                    System.out.println("A sair...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
