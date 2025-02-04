package FicheirosTXT;

import gestao_mesas.mesas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lerficheiros {

    //Metodo para ler ficheiro e guardar em memoria
    public static int LerFicheiroMesas(String filePath, mesas.Mesa[] mesas) {
        final int MAX_MESAS = 100; // Defina o número máximo de mesas
        int contadorMesas = 0; // Variável para contar o número de mesas carregadas

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(","); // Divide a linha pelas vírgulas
                if (partes.length == 3) {
                    // Extrai os dados e cria um objeto Mesa
                    int numero = Integer.parseInt(partes[0].replace("Mesa", "").trim());
                    int lugares = Integer.parseInt(partes[1].replace(" lugares", "").trim());
                    String estado = partes[2].trim();

                    // Adiciona o objeto Mesa ao array (se houver espaço)
                    if (contadorMesas < MAX_MESAS) {
                        mesas[contadorMesas] = new mesas.Mesa(numero, lugares, estado);
                        contadorMesas++;
                    } else {
                        System.err.println("Erro: Número máximo de mesas atingido.");
                    }
                } else {
                    System.err.println("Erro no formato da linha: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão de número: " + e.getMessage());
        }

        return contadorMesas;  // Retorna o número de mesas carregadas
    }


    public static int LerFicheiroMenu() {
        String caminhoFicheiro = "C://Users//pport//Desktop//ProjetoLP1//ProjetoLP1//src//FicheirosTXT//FicheiroMenus.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoFicheiro))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                // Atribuindo valores a variáveis
                String nome = partes[0];
                String categoria = partes[1];
                double precoCusto = Double.parseDouble(partes[2].replace(",", "."));
                double precoVenda = Double.parseDouble(partes[3].replace(",", "."));
                int tempoPreparacao = Integer.parseInt(partes[4]);
                int dificuldade = Integer.parseInt(partes[5]);
                boolean disponivel = Boolean.parseBoolean(partes[6]);

                // Exemplo de saída
                System.out.println("Nome: " + nome);
                System.out.println("Categoria: " + categoria);
                System.out.println("Preço de Custo: " + precoCusto);
                System.out.println("Preço de Venda: " + precoVenda);
                System.out.println("Tempo de Preparação: " + tempoPreparacao + "unidades de tempo");
                System.out.println("Dificuldade: " + dificuldade);
                System.out.println("Disponível: " + disponivel);
                System.out.println("-------------------------");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número: " + e.getMessage());
        }
        return 0;
    }

    public static int LerFicheiroReservas() {

        String caminhoFicheiro = "C://Users//pport//Desktop//ProjetoLP1//ProjetoLP1//src//FicheirosTXT//FicheiroReservas.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoFicheiro))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String nome = partes[0];
                    int quantidadePessoas = Integer.parseInt(partes[1]);
                    int unidadeTempo = Integer.parseInt(partes[2]);

                    // Exibir os dados lidos
                    System.out.println("Nome: " + nome +
                            ", Quantidade de Pessoas: " + quantidadePessoas +
                            ", Unidade de Tempo: " + unidadeTempo);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }
        return 0;
    }
}



