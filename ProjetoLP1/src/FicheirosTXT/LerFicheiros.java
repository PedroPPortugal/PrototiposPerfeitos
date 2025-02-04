package FicheirosTXT;

import gestao_mesas.mesas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerFicheiros {

    public static String filePathMenus = "C://Users//gisel//OneDrive//Ambiente de Trabalho//Agora vau//PrototiposPerfeitos//ProjetoLP1//src//FicheirosTXT//FicheiroMenus.txt";
    public static String filePathMesas = "C://Users//gisel//OneDrive//Ambiente de Trabalho//Agora vau//PrototiposPerfeitos//ProjetoLP1//src//FicheirosTXT//FicheiroMesas.txt";
    public static String filePathReservas = "C://Users//gisel//OneDrive//Ambiente de Trabalho//Agora vau//PrototiposPerfeitos//ProjetoLP1//src//FicheirosTXT//FicheiroReservas.txt";

    /** Método para ler ficheiro de mesas e armazenar em memória */
    public static int lerFicheiroMesas(mesas.Mesa[] mesas) {
        int contadorMesas = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathMesas))) {
            String linha;
            while ((linha = reader.readLine()) != null && contadorMesas < mesas.length) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    int numero = Integer.parseInt(partes[0].replace("Mesa", "").trim());
                    int lugares = Integer.parseInt(partes[1].replace(" lugares", "").trim());
                    String estado = partes[2].trim();

                    mesas[contadorMesas] = new mesas.Mesa(numero, lugares, estado);
                    contadorMesas++;
                } else {
                    System.out.println("Erro no formato da linha: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro de mesas: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro de conversão de número: " + e.getMessage());
        }

        return contadorMesas;
    }

    /** Método para ler ficheiro de menu */
    public static int lerFicheiroMenu() {
        int contadorItens = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePathMenus))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 7) {
                    String nome = partes[0];
                    String categoria = partes[1];
                    double precoCusto = Double.parseDouble(partes[2].replace(",", "."));
                    double precoVenda = Double.parseDouble(partes[3].replace(",", "."));
                    int tempoPreparacao = Integer.parseInt(partes[4]);
                    int dificuldade = Integer.parseInt(partes[5]);
                    boolean disponivel = Boolean.parseBoolean(partes[6]);

                    // Exibir os dados lidos
                    System.out.println("Nome: " + nome);
                    System.out.println("Categoria: " + categoria);
                    System.out.println("Preço de Custo: R$" + precoCusto);
                    System.out.println("Preço de Venda: R$" + precoVenda);
                    System.out.println("Tempo de Preparação: " + tempoPreparacao + " unidades de tempo");
                    System.out.println("Dificuldade: " + dificuldade);
                    System.out.println("Disponível: " + disponivel);
                    System.out.println("-------------------------");

                    contadorItens++;
                } else {
                    System.out.println("Erro no formato da linha: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro de menus: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }

        return contadorItens;
    }

    /** Método para ler ficheiro de reservas */
    public static int lerFicheiroReservas() {
        int contadorReservas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePathReservas))) {
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

                    contadorReservas++;
                } else {
                    System.out.println("Erro no formato da linha: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro de reservas: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }

        return contadorReservas;
    }
}
