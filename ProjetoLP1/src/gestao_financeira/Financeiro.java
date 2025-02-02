package gestao_financeira;

import java.io.*;

public class Financeiro {
    private double totalFaturado;
    private double totalGastos;

    public Financeiro() {
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
    }

    /** Adiciona um valor ao faturamento, garantindo que seja positivo */
    public void adicionarFaturamento(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do faturamento deve ser positivo.");
            return;
        }
        this.totalFaturado += valor;
        System.out.println("Faturamento de " + valor + "€ adicionado.");
    }

    /** Adiciona um valor aos gastos, garantindo que seja positivo */
    public void adicionarGasto(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do gasto deve ser positivo.");
            return;
        }
        this.totalGastos += valor;
        System.out.println("Gasto de " + valor + "€ adicionado.");
    }

    /** Retorna o total faturado */
    public double getTotalFaturado() {
        return totalFaturado;
    }

    /** Retorna o total de gastos */
    public double getTotalGastos() {
        return totalGastos;
    }

    /** Calcula e retorna o lucro */
    public double getLucro() {
        return totalFaturado - totalGastos;
    }

    /** Exibe um resumo financeiro formatado */
    public void exibirResumo() {
        System.out.println("\n--- Resumo Financeiro ---");
        System.out.println("Total Faturado: " + totalFaturado + "€");
        System.out.println("Total Gastos: " + totalGastos + "€");
        System.out.println("Lucro: " + getLucro() + "€");
    }

    /** Salva os dados financeiros em um arquivo */
    public void salvarFinanceiro(String financeiro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("financeiro.txt"))) {
            writer.write(totalFaturado + ";" + totalGastos);
            System.out.println("Dados financeiros salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados financeiros.");
        }
    }

    /** Carrega os dados financeiros de um arquivo */
    public void carregarFinanceiro(String financeiro) {
        try (BufferedReader reader = new BufferedReader(new FileReader("financeiro.txt"))) {
            String linha = reader.readLine();
            if (linha != null) {
                String[] valores = linha.split(";");
                this.totalFaturado = Double.parseDouble(valores[0]);
                this.totalGastos = Double.parseDouble(valores[1]);
                System.out.println("Dados financeiros carregados com sucesso.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados financeiros.");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato inválido no arquivo de dados financeiros.");
        }
    }
}
