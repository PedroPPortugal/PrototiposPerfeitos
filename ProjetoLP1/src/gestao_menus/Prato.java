package gestao_menus;

public class Prato {
    private String nome;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int tempoPreparacao;
    private boolean disponivel;

    public Prato(String nome, String categoria, double precoCusto, double precoVenda, int tempoPreparacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.tempoPreparacao = tempoPreparacao;
        this.disponivel = true;
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrecoCusto() { return precoCusto; }
    public double getPrecoVenda() { return precoVenda; }
    public int getTempoPreparacao() { return tempoPreparacao; }
    public boolean isDisponivel() { return disponivel; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPrecoCusto(double precoCusto) { this.precoCusto = precoCusto; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }
    public void setTempoPreparacao(int tempoPreparacao) { this.tempoPreparacao = tempoPreparacao; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() {
        return nome + " (" + categoria + ") - PVP: " + precoVenda + "€ - Tempo: " + tempoPreparacao;
    }
}
