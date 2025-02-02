package gestao_dia_a_dia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulacao {
    private int unidadesTempoDia;
    public int tempoAtual;
    private int totalMesas;
    private boolean[] mesasOcupadas;
    private int[] capacidadeMesas;
    private String[][] clientesEmEspera;
    private int totalClientesEspera;

    public Simulacao(int unidadesTempoDia, int totalMesas, int maxClientesEspera) {
        this.unidadesTempoDia = unidadesTempoDia;
        this.tempoAtual = 0;
        this.totalMesas = totalMesas;
        this.mesasOcupadas = new boolean[totalMesas];
        this.capacidadeMesas = new int[totalMesas];
        this.clientesEmEspera = new String[maxClientesEspera][7];
        this.totalClientesEspera = 0;

        for (int i = 0; i < totalMesas; i++) {
            capacidadeMesas[i] = 4;
        }
    }

    public void iniciarDia(String clientes ) {
        try {
            File arquivo = new File("clientes.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dadosCliente = linha.split(",");


                if (dadosCliente.length < 7) {
                    System.out.println("Erro: Dados inválidos no arquivo para cliente.");
                    continue;
                }

                String nome = dadosCliente[0];
                int numeroPessoas = Integer.parseInt(dadosCliente[1]);
                int tempoChegada = Integer.parseInt(dadosCliente[6]);

                System.out.println("\nCliente chegou: " + nome);
                System.out.println("Número de pessoas: " + numeroPessoas);
                System.out.println("Tempo de chegada: " + tempoChegada);
                System.out.println("-----------------------------");

                /**Se chegou no tempo certo, tenta atribuir mesa imediatamente*/
                if (tempoChegada == tempoAtual) {
                    atribuirMesa(nome, numeroPessoas, tempoChegada);
                } else {
                    /**Se não pode ser atendido agora, adiciona à lista de espera*/
                    adicionarClienteEspera(dadosCliente);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de clientes não encontrado.");
        }
    }

    public void avancarTempo() {
        if (tempoAtual < unidadesTempoDia) {
            tempoAtual++;
            System.out.println("\nTempo avançado: " + tempoAtual);
            processarClientesEmEspera();
        } else {
            System.out.println("O dia já terminou!");
        }
    }

    private void processarClientesEmEspera() {
        for (int i = 0; i < totalClientesEspera; i++) {
            String nome = clientesEmEspera[i][0];
            int numeroPessoas = Integer.parseInt(clientesEmEspera[i][1]);
            int tempoChegada = Integer.parseInt(clientesEmEspera[i][6]);

            if (tempoChegada == tempoAtual) {
                boolean mesaAtribuida = atribuirMesa(nome, numeroPessoas, tempoChegada);
                if (mesaAtribuida) {
                    removerClienteEspera(i);
                    i--;
                }
            }
        }
    }

    private void adicionarClienteEspera(String[] cliente) {
        if (totalClientesEspera < clientesEmEspera.length) {
            clientesEmEspera[totalClientesEspera] = cliente;
            totalClientesEspera++;
        } else {
            System.out.println("Fila de espera cheia! Cliente " + cliente[0] + " não pode ser adicionado.");
        }
    }

    private void removerClienteEspera(int indice) {
        if (indice < 0 || indice >= totalClientesEspera) {
            return;
        }

        for (int i = indice; i < totalClientesEspera - 1; i++) {
            clientesEmEspera[i] = clientesEmEspera[i + 1];
        }

        clientesEmEspera[totalClientesEspera - 1] = null;
        totalClientesEspera--;
    }

    public boolean atribuirMesa(String nomeCliente, int numeroPessoas, int tempoChegada) {
        if (tempoChegada > tempoAtual) {
            System.out.println("Cliente " + nomeCliente + " ainda não chegou.");
            return false;
        }

        for (int i = 0; i < totalMesas; i++) {
            if (!mesasOcupadas[i] && capacidadeMesas[i] >= numeroPessoas) {
                mesasOcupadas[i] = true;
                System.out.println("Mesa " + (i + 1) + " atribuída ao cliente " + nomeCliente + ".");
                notificar("Cliente " + nomeCliente + " sentou na mesa " + (i + 1) + ".");
                return true;
            }
        }

        System.out.println("Nenhuma mesa disponível para " + nomeCliente + ".");
        return false;
    }

    public void liberarMesa(int numeroMesa) {
        if (numeroMesa >= 1 && numeroMesa <= totalMesas) {
            mesasOcupadas[numeroMesa - 1] = false;
            System.out.println("Mesa " + numeroMesa + " liberada.");
            notificar("Mesa " + numeroMesa + " foi liberada.");
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    private void notificar(String mensagem) {
        System.out.println("[NOTIFICAÇÃO] " + mensagem);
    }
}
