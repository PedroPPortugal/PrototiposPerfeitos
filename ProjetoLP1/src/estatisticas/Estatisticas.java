package estatisticas;

public class Estatisticas {
    private int totalClientesAtendidos;
    private int totalPedidosAtendidos;
    private int totalPedidosNaoAtendidos;
    private double totalFaturado;
    private double totalGastos;

    public Estatisticas() {
        this.totalClientesAtendidos = 0;
        this.totalPedidosAtendidos = 0;
        this.totalPedidosNaoAtendidos = 0;
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
    }

    /** Atualizar estatísticas */
    public void adicionarClientesAtendidos(int quantidade) {
        if (quantidade > 0) {
            this.totalClientesAtendidos += quantidade;
        }
    }

    public void adicionarPedidoAtendido(double valorFaturado, double custo) {
        if (valorFaturado >= 0 && custo >= 0) {
            this.totalPedidosAtendidos++;
            this.totalFaturado += valorFaturado;
            this.totalGastos += custo;
        }
    }

    public void adicionarPedidoNaoAtendido() {
        this.totalPedidosNaoAtendidos++;
    }

    /** Calcular estatísticas */
    public int getTotalClientesAtendidos() {
        return this.totalClientesAtendidos;
    }

    public int getTotalPedidosAtendidos() {
        return this.totalPedidosAtendidos;
    }

    public int getTotalPedidosNaoAtendidos() {
        return this.totalPedidosNaoAtendidos;
    }

    public double getTotalFaturado() {
        return this.totalFaturado;
    }

    public double getTotalGastos() {
        return this.totalGastos;
    }

    public double getLucro() {
        return this.totalFaturado - this.totalGastos;
    }

    /** Exibir relatório final do dia */
    public void exibirRelatorio() {
        System.out.println("\n===== RELATÓRIO DO DIA =====");
        System.out.println("Clientes atendidos: " + totalClientesAtendidos);
        System.out.println("Pedidos atendidos: " + totalPedidosAtendidos);
        System.out.println("Pedidos não atendidos: " + totalPedidosNaoAtendidos);
        System.out.println("Total faturado: R$ " + totalFaturado);
        System.out.println("Total gasto: R$ " + totalGastos);
        System.out.println("Lucro do dia: R$ " + getLucro());
        System.out.println("===========================\n");
    }

    /** Resetar estatísticas ao final do dia */
    public void resetEstatisticas() {
        this.totalClientesAtendidos = 0;
        this.totalPedidosAtendidos = 0;
        this.totalPedidosNaoAtendidos = 0;
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
    }
}
