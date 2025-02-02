package gestao_menus;

import java.io.*;

public class GestaoMenus {
    private Prato[] pratos;
    private int totalPratos;

    public GestaoMenus(int maxPratos) {
        pratos = new Prato[maxPratos];
        totalPratos = 0;
    }

    /** Método auxiliar para validar valores */
    private boolean validarValores(double PC, double PV, int tempoPreparacao) {
        return PC > 0 && PV > 0 && tempoPreparacao > 0;
    }

    public void adicionarPrato(String nome, String categoria, double PC, double PV, int tempoPreparacao) {
        if (totalPratos >= pratos.length) {
            System.out.println("Erro: Limite de pratos atingido.");
            return;
        }

        if (buscarPrato(nome) != null) {
            System.out.println("Erro: Já existe um prato com esse nome.");
            return;
        }

        if (!validarValores(PC, PV, tempoPreparacao)) {
            System.out.println("Erro: Preços e tempo de preparação devem ser positivos.");
            return;
        }

        pratos[totalPratos] = new Prato(nome, categoria, PC, PV, tempoPreparacao);
        totalPratos++;
        System.out.println("Prato '" + nome + "' adicionado ao menu.");
    }

    public void listarPratos() {
        if (totalPratos == 0) {
            System.out.println("Nenhum prato cadastrado.");
            return;
        }

        System.out.println("\n--- Menu do Restaurante ---");
        for (int i = 0; i < totalPratos; i++) {
            System.out.println(pratos[i]);
        }
    }

    public void removerPrato(String prato) {
        for (int i = 0; i < totalPratos; i++) {
            if (pratos[i].getNome().equalsIgnoreCase(prato)) {
                pratos[i] = pratos[totalPratos - 1];
                pratos[totalPratos - 1] = null;
                totalPratos--;
                System.out.println("Prato '" + prato + "' removido.");
                return;
            }
        }
        System.out.println("Erro: Prato não encontrado.");
    }

    public void editarPrato(String nome, String novaCategoria, double novoPrecoCusto, double novoPrecoVenda, int novoTempoPreparacao) {
        Prato prato = buscarPrato(nome);
        if (prato == null) {
            System.out.println("Erro: Prato não encontrado.");
            return;
        }

        if (!validarValores(novoPrecoCusto, novoPrecoVenda, novoTempoPreparacao)) {
            System.out.println("Erro: Valores inválidos.");
            return;
        }

        prato.setCategoria(novaCategoria);
        prato.setPrecoCusto(novoPrecoCusto);
        prato.setPrecoVenda(novoPrecoVenda);
        prato.setTempoPreparacao(novoTempoPreparacao);
        System.out.println("Prato atualizado com sucesso!");
    }

    public Prato buscarPrato(String nome) {
        for (int i = 0; i < totalPratos; i++) {
            if (pratos[i].getNome().equalsIgnoreCase(nome)) {
                return pratos[i];
            }
        }
        return null;
    }

    /** Salvar o menu em um arquivo */
    public void salvarMenu(String FicheiroMenus ) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("FicheiroMenus.txt")) {
            for (int i = 0; i < totalPratos; i++) {
                Prato p = pratos[i];
                writer.write(p.getNome() + ";" + p.getCategoria() + ";" + p.getPrecoCusto() + ";" + p.getPrecoVenda() + ";" + p.getTempoPreparacao());
                writer.newLine();
            }

            System.out.println("Menu salvo com sucesso.");
        } catch (IOException ) {
            System.out.println("Erro ao salvar menu.");
        }
    }

    /** Carregar o menu de um arquivo */
    public void carregarMenu(String FicheiroMenus) {
        try (BufferedReader reader = new BufferedReader(new FileReader("FicheiroMenus.txt"))) {
            String linha;
            totalPratos = 0;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                adicionarPrato(dados[0], dados[1], Double.parseDouble(dados[2]), Double.parseDouble(dados[3]), Integer.parseInt(dados[4]));
            }
            System.out.println("Menu carregado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar menu.");
        }
    }
}
