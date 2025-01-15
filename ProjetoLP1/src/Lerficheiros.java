import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lerficheiros {

    // Método para ler o ficheiro e armazenar as mesas em memória
    public static int lerFicheiroMesas(String filePath, mesas.Mesa[] mesas) {
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
}