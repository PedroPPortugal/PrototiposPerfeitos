package main;

import FicheirosTXT.Lerficheiros;
import configuracoes.Console;
import estatisticas.Estatisticas;
import gestao_dia_a_dia.Simulacao;
import gestao_dia_a_dia.SimulacaoDia;
import gestao_menus.GestaoMenus;
import gestao_mesas.GestaoMesas;
import gestao_mesas.mesas;
import gestao_mesas.mesas.Mesa;



public class Main {

    public static Estatisticas estatisticas = new Estatisticas();
    public static GestaoMesas gestaoMesas = new GestaoMesas();
    public static GestaoMenus gestaoMenus = new GestaoMenus(10);
    public static Mesa[] listaMesas = new Mesa[10];
    public static SimulacaoDia simulacaoDia = new SimulacaoDia(gestaoMesas);
    public static Simulacao simulacao = new Simulacao(240, 25, 10);
    public static Lerficheiros lerFicheiros = new Lerficheiros();

    public static int tempoMaximoEspera = 20;

    public static void main(String[] args) {

        gestaoMenus.carregarMenu("menu.txt");

        /**Inicializa a gestão de menus*/

        /** Entradas */
        gestaoMenus.adicionarPrato("Pão de Queijo", "entrada", 1.0, 3.0, 2);
        gestaoMenus.adicionarPrato("Coxinha", "entrada", 1.5, 4.0, 3);
        gestaoMenus.adicionarPrato("Bolinho de Bacalhau", "entrada", 2.0, 5.0, 4);

        /** Pratos principais */
        gestaoMenus.adicionarPrato("Feijoada", "principal", 5.0, 12.0, 10);
        gestaoMenus.adicionarPrato("Moqueca de Peixe", "principal", 6.0, 15.0, 9);
        gestaoMenus.adicionarPrato("Churrasco", "principal", 7.0, 18.0, 8);

        /** Sobremesas */
        gestaoMenus.adicionarPrato("Brigadeiro", "sobremesa", 1.0, 4.0, 3);
        gestaoMenus.adicionarPrato("Pudim de Leite", "sobremesa", 2.0, 6.0, 5);
        gestaoMenus.adicionarPrato("Quindim", "sobremesa", 1.5, 5.0, 4);

        /** Listar os pratos */
        gestaoMenus.listarPratos();

        /*Inicializa a gestão de mesas*/

        int totalLugares = 0;
        for (int i = 1; i <= 10; i++) {
            int capacidade = (i % 2 == 0) ? 2 : 4;
            gestao_mesas.GestaoMesas.adicionarMesa(Lerficheiros.filePathMesas, listaMesas, 100);
            totalLugares += capacidade;
        }

        System.out.println("\nTotal de mesas: 10");
        System.out.println("Total de lugares: " + totalLugares);
        System.out.println("\n--- Lista de Mesas ---");
        Lerficheiros.LerFicheiroMesas(listaMesas);

        Console console = new Console();
    }
}
