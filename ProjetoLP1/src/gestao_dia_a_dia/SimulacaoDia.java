package gestao_dia_a_dia;

import gestao_mesas.GestaoMesas;
import gestao_mesas.Mesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimulacaoDia {
    private GestaoMesas gestaoMesas;

    public SimulacaoDia(GestaoMesas gestaoMesas) {
        this.gestaoMesas = gestaoMesas;
    }

    public static void processarReservas(String clientes) {
        try {
            File arquivo = new File("clientes,txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(",");

                if (dados.length < 2) {
                    System.out.println("Erro: Dados de reserva inválidos.");
                    continue;
                }

                String nomeReserva = dados[0];
                int numPessoas;

                try {
                    numPessoas = Integer.parseInt(dados[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Número inválido para a reserva '" + nomeReserva + "'.");
                    continue;
                }

                boolean reservaFeita = false;

                for (Mesa mesa : gestao_mesas.GestaoMesas.GetMesas()) {
                    if (!mesa.isOcupada() && mesa.getCapacidade() >= numPessoas) {
                        mesa.setOcupada(true);
                        System.out.println("Reserva '" + nomeReserva + "' encaminhada para a mesa " + mesa.getNumeroMesa());
                        reservaFeita = true;
                        break;
                    }
                }

                if (!reservaFeita) {
                    System.out.println("Nenhuma mesa disponível para a reserva '" + nomeReserva + "'.");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de reservas não encontrado (" + "clientes.txt" + ").");
        }
    }
}
