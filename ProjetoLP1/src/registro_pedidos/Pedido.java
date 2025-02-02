package registo_pedidos;

public class Pedido {
    private int numeroMesa;
    private String nomePrato;
    private int quantidade;
    private double precoVenda;

    public Pedido(int numeroMesa, String nomePrato, int quantidade, double precoVenda) {
        if (numeroMesa <= 0) {
            throw new IllegalArgumentException("Número da mesa deve ser maior que zero.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser pelo menos 1.");
        }
        if (precoVenda < 0) {
            throw new IllegalArgumentException("O preço do prato não pode ser negativo.");
        }

        this.numeroMesa = numeroMesa;
        this.nomePrato = nomePrato;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public double calcularTotal() {
        return quantidade * precoVenda;
    }

    public String toString() {
        return "Pedido [Mesa " + numeroMesa + "] - " + quantidade + "x " + nomePrato + " (Total: R$ " + calcularTotal() + ")";
    }
}
