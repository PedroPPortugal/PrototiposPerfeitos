package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String CAMINHO_LOG = "logs.txt";

    public static void log(String mensagem) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String logMensagem = "[" + dataHora + "] " + mensagem;

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(CAMINHO_LOG, true))) {
            escritor.write(logMensagem);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
