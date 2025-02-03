import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
    private static final String LOG_DIR = "C:\\Users\\Lenovo\\IdeaProjects\\Projeto\\TXTS\\Logs";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public static void registrar(String acao) {
        try {
            // Criar um novo nome de arquivo com base na data e hora atual
            String logFileName = LOG_DIR + "\\logs_" + LocalDateTime.now().format(FORMATTER) + ".txt";
            File logFile = new File(logFileName);

            // Escrever no novo ficheiro de logs
            try (FileWriter fw = new FileWriter(logFile, true);
                 PrintWriter pw = new PrintWriter(fw)) {

                String timestamp = LocalDateTime.now().format(FORMATTER);
                pw.println(timestamp + " - " + acao);
            }
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }

    public static void exibirLogs() {
        File diretorio = new File(LOG_DIR);
        File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".txt"));

        if (arquivos != null && arquivos.length > 0) {
            System.out.println("\n===== HISTÓRICO DE LOGS =====");
            for (File arquivo : arquivos) {
                System.out.println("Arquivo: " + arquivo.getName());
                try (java.util.Scanner scanner = new java.util.Scanner(arquivo)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o log " + arquivo.getName() + ": " + e.getMessage());
                }
            }
            System.out.println("=============================");
        } else {
            System.out.println("Nenhum log encontrado.");
        }
    }
}
