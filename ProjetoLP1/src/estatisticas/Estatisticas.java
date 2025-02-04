package estatisticas;

public class Estatisticas {
    private int totalClientesAtendidos;
    private int totalPedidosAtendidos;
    private int totalPedidosNaoAtendidos;
    private double totalFaturado;
    private double totalGastos;
    private int totalTempoEspera;
    private int totalTempoAtendimento;
    private String[] pratos;
    private int[] quantidadePratos;
    private static final int MAX_PRATOS = 50;

    public Estatisticas() {
        this.totalClientesAtendidos = 0;
        this.totalPedidosAtendidos = 0;
        this.totalPedidosNaoAtendidos = 0;
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
        this.totalTempoEspera = 0;
        this.totalTempoAtendimento = 0;
        this.pratos = new String[MAX_PRATOS];
        this.quantidadePratos = new int[MAX_PRATOS];
    }

    /** Atualizar estatísticas */
    public void adicionarClientesAtendidos(int quantidade, int tempoEspera) {
        if (quantidade > 0) {
            this.totalClientesAtendidos += quantidade;
            this.totalTempoEspera += tempoEspera;
        }
    }

    public void adicionarPedidoAtendido(String prato, double valorFaturado, double custo, int tempoAtendimento) {
        if (valorFaturado >= 0 && custo >= 0) {
            this.totalPedidosAtendidos++;
            this.totalFaturado += valorFaturado;
            this.totalGastos += custo;
            this.totalTempoAtendimento += tempoAtendimento;
            registrarPrato(prato);
        }
    }

    public void adicionarPedidoNaoAtendido() {
        this.totalPedidosNaoAtendidos++;
    }

    private void registrarPrato(String prato) {
        for (int i = 0; i < MAX_PRATOS; i++) {
            if (pratos[i] == null) {
                pratos[i] = prato;
                quantidadePratos[i] = 1;
                return;
            } else if (pratos[i].equals(prato)) {
                quantidadePratos[i]++;
                return;
            }
        }
    }

    /** Calcular estatísticas */
    public String getPratoMaisPedido() {
        int maxIndex = 0;
        for (int i = 1; i < MAX_PRATOS; i++) {
            if (pratos[i] != null && quantidadePratos[i] > quantidadePratos[maxIndex]) {
                maxIndex = i;
            }
        }
        return pratos[maxIndex] != null ? pratos[maxIndex] : "Nenhum pedido registrado";
    }

    public double getTempoMedioEspera() {
        return totalClientesAtendidos > 0 ? (double) totalTempoEspera / totalClientesAtendidos : 0;
    }

    public double getTempoMedioAtendimento() {
        return totalPedidosAtendidos > 0 ? (double) totalTempoAtendimento / totalPedidosAtendidos : 0;
    }

    public void exibirRelatorio() {
        System.out.println("\n===== RELATÓRIO DO DIA =====");
        System.out.println("Clientes atendidos: " + totalClientesAtendidos);
        System.out.println("Pedidos atendidos: " + totalPedidosAtendidos);
        System.out.println("Pedidos não atendidos: " + totalPedidosNaoAtendidos);
        System.out.println("Total faturado: R$ " + totalFaturado);
        System.out.println("Total gasto: R$ " + totalGastos);
        System.out.println("Lucro do dia: R$ " + (totalFaturado - totalGastos));
        System.out.println("Prato mais pedido: " + getPratoMaisPedido());
        System.out.println("Tempo médio de espera: " + getTempoMedioEspera() + " min");
        System.out.println("Tempo médio de atendimento: " + getTempoMedioAtendimento() + " min");
        System.out.println("===========================\n");
    }

    public String getTotalClientesAtendidos() {
    }

    public String getTotalPedidosAtendidos() {
    }

    public String getTotalPedidosNaoAtendidos() {
    }


    public String getTotalFaturado() {
    }

    public String getTotalGastos() {
    }

    public String getLucro() {
    }
}
