package gestao_mesas;

import gestao_menus.Prato;

import static main.Main.gestaoMesas;

public class Mesa {
    public int numeroMesa;
    public int capacidade;
    public boolean ocupada;
    public QuantidadePrato[] pratos;


    public Mesa(int numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.ocupada = false;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Mesa " + numeroMesa + " (Capacidade: " + capacidade + ") - " + (ocupada ? "Ocupada" : "Livre");
    }

    public void AdiconarPrato_Mesa(Prato prato, int mesaId){

        boolean executar = true;
        String nomeprato = prato.getNome();

        for (int i = 0; i < gestaoMesas.mesas[mesaId-1].pratos.length; i++) {
            String nome = gestaoMesas.mesas[mesaId-1].pratos[i].prato.getNome();
            if(nome.equals(nomeprato)){
                gestaoMesas.mesas[mesaId-1].pratos[i].quantidade ++;
                executar = false;
                break;
            }
        }

        if (executar){
            gestaoMesas.mesas[mesaId-1].pratos[gestaoMesas.mesas[mesaId-1].pratos.length].prato = prato;
            gestaoMesas.mesas[mesaId-1].pratos[gestaoMesas.mesas[mesaId-1].pratos.length].quantidade = 1;
        }
    }
}