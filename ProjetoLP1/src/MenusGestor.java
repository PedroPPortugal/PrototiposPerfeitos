import java.util.Scanner;

public class  MenusGestor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Exibe o menu

        do {
            // Exibe o menu com um design mais atrativo
            System.out.println("\n============================");
            System.out.println("        MENU DO GESTOR          ");
            System.out.println("=============================");
            System.out.println("1-   Gestão de Mesas         ");
            System.out.println("2-   Gestão de menus         ");
            System.out.println("3-   Opção 3");
            System.out.println("0-   Sair");
            System.out.println("============================");
            System.out.print("Escolha uma opção: ");

            // Lê a opção do usuário
            opcao = scanner.nextInt();

            // Executa a ação correspondente
            switch (opcao) {
                case 1:
                    GestaoMesas.MenuMesas();
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2.");
                    break;
                case 3:
                    GestaoMesas.exibirMesas();
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
}
