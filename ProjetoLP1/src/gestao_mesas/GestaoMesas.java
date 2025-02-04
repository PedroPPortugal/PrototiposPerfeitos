package gestao_mesas;

public class GestaoMesas {
    public static Mesa[] mesas;
    private static int totalMesas;

    public GestaoMesas(int maxMesas) {
        mesas = new Mesa[maxMesas];
        totalMesas = 0;
    }

    public boolean adicionarMesa(int numeroMesa, int capacidade) {
        if (totalMesas < mesas.length) {
            mesas[totalMesas] = new Mesa(numeroMesa, capacidade);
            totalMesas++;
            return true;
        }
        return false;
    }
    public void listarMesas() {
        for (int i = 0; i < totalMesas; i++) {
            System.out.println(mesas[i]);
        }
    }

    public int atribuirClientesAMesa(int numeroClientes) {
        for (int i = 0; i < totalMesas; i++) {
            if (!mesas[i].isOcupada() && mesas[i].getCapacidade() >= numeroClientes) {
                mesas[i].setOcupada(true);
                return mesas[i].getNumeroMesa();
            }
        }
        return -1;
    }

    public static Mesa[] GetMesas() { return mesas; }
}