package gestao_financeira;

public class Financeiro {
    private double totalFaturado;
    private double totalGastos;
    private int totalPedidosAtendidos;
    private int totalPedidosNaoAtendidos;

    public Financeiro() {
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
        this.totalPedidosAtendidos = 0;
        this.totalPedidosNaoAtendidos = 0;
    }

    /** Registrar um pedido atendido */
    public void registrarPedidoAtendido(double valorFaturado, double custo) {
        if (valorFaturado >= 0 && custo >= 0) {
            this.totalPedidosAtendidos++;
            this.totalFaturado += valorFaturado;
            this.totalGastos += custo;
        }
    }

    /** Registrar um pedido não atendido */
    public void registrarPedidoNaoAtendido() {
        this.totalPedidosNaoAtendidos++;
    }

    /** Obter total faturado */
    public double getTotalFaturado() {
        return this.totalFaturado;
    }

    /** Obter total de gastos */
    public double getTotalGastos() {
        return this.totalGastos;
    }

    /** Obter lucro total */
    public double getLucroTotal() {
        return this.totalFaturado - this.totalGastos;
    }

    /** Obter número de pedidos atendidos */
    public int getTotalPedidosAtendidos() {
        return this.totalPedidosAtendidos;
    }

    /** Obter número de pedidos não atendidos */
    public int getTotalPedidosNaoAtendidos() {
        return this.totalPedidosNaoAtendidos;
    }

    /** Exibir relatório financeiro */
    public void exibirRelatorioFinanceiro() {
        System.out.println("\n===== RELATÓRIO FINANCEIRO =====");
        System.out.println("Total faturado: R$ " + getTotalFaturado());
        System.out.println("Total gasto: R$ " + getTotalGastos());
        System.out.println("Lucro total: R$ " + getLucroTotal());
        System.out.println("Pedidos atendidos: " + getTotalPedidosAtendidos());
        System.out.println("Pedidos não atendidos: " + getTotalPedidosNaoAtendidos());
        System.out.println("================================\n");
    }
}
