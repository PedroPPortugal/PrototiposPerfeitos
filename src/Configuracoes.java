import java.util.Scanner;

public class Configuracoes {


    private String caminhoFicheiros = "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS";
    private char separadorFicheiros;
    private int unidadesTempoPorDia;
    private int unidadesConsumoPrato;
    private double custoClienteNaoAtendido;
    private String passwordConfiguracoes;


    public Configuracoes(String caminhoFicheiros, char separadorFicheiros, int unidadesTempoPorDia,
                         int unidadesConsumoPrato, double custoClienteNaoAtendido, String passwordConfiguracoes) {
        this.caminhoFicheiros = caminhoFicheiros;
        this.separadorFicheiros = separadorFicheiros;
        this.unidadesTempoPorDia = unidadesTempoPorDia;
        this.unidadesConsumoPrato = unidadesConsumoPrato;
        this.custoClienteNaoAtendido = custoClienteNaoAtendido;
        this.passwordConfiguracoes = passwordConfiguracoes;
    }



    public String getCaminhoFicheiros() {
        return caminhoFicheiros;
    }

    public void setCaminhoFicheiros(String caminhoFicheiros) {
        this.caminhoFicheiros = caminhoFicheiros;
    }

    public char getSeparadorFicheiros() {
        return separadorFicheiros;
    }

    public void setSeparadorFicheiros(char separadorFicheiros) {
        this.separadorFicheiros = separadorFicheiros;
    }

    public int getUnidadesTempoPorDia() {
        return unidadesTempoPorDia;
    }

    public void setUnidadesTempoPorDia(int unidadesTempoPorDia) {
        this.unidadesTempoPorDia = unidadesTempoPorDia;
    }

    public int getUnidadesConsumoPrato() {
        return unidadesConsumoPrato;
    }

    public void setUnidadesConsumoPrato(int unidadesConsumoPrato) {
        this.unidadesConsumoPrato = unidadesConsumoPrato;
    }

    public double getCustoClienteNaoAtendido() {
        return custoClienteNaoAtendido;
    }

    public void setCustoClienteNaoAtendido(double custoClienteNaoAtendido) {
        this.custoClienteNaoAtendido = custoClienteNaoAtendido;
    }

    public String getPasswordConfiguracoes() {
        return passwordConfiguracoes;
    }

    public void setPasswordConfiguracoes(String passwordConfiguracoes) {
        this.passwordConfiguracoes = passwordConfiguracoes;
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


    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite a senha para acessar o menu de configurações: ");
        String senhaDigitada = scanner.nextLine();

        if (!senhaDigitada.equals(passwordConfiguracoes)) {
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
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println(this);
                    break;
                case 2:
                    System.out.print("Novo caminho dos ficheiros: ");
                    setCaminhoFicheiros(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Novo separador dos ficheiros: ");
                    setSeparadorFicheiros(scanner.nextLine().charAt(0));
                    break;
                case 4:
                    System.out.print("Novas unidades de tempo por dia: ");
                    setUnidadesTempoPorDia(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Novas unidades de consumo por prato: ");
                    setUnidadesConsumoPrato(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Novo custo por cliente não atendido: ");
                    setCustoClienteNaoAtendido(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
