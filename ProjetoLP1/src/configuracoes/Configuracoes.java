package configuracoes;

public class Configuracoes {
    private String caminhoArquivos;
    private String separador;
    private int unidadesTempoDia;
    private int tempoEsperaCliente;
    private double custoClienteNaoAtendido;

    public Configuracoes(String caminhoArquivos, String separador, int unidadesTempoDia, int tempoEsperaCliente, double custoClienteNaoAtendido) {
        this.caminhoArquivos = caminhoArquivos;
        this.separador = separador;
        this.unidadesTempoDia = unidadesTempoDia;
        this.tempoEsperaCliente = tempoEsperaCliente;
        this.custoClienteNaoAtendido = custoClienteNaoAtendido;
    }

    public String getCaminhoArquivos() {
        return caminhoArquivos;
    }

    public String getSeparador() {
        return separador;
    }

    public int getUnidadesTempoDia() {
        return unidadesTempoDia;
    }

    public int getTempoEsperaCliente() {
        return tempoEsperaCliente;
    }

    public double getCustoClienteNaoAtendido() {
        return custoClienteNaoAtendido;
    }
}