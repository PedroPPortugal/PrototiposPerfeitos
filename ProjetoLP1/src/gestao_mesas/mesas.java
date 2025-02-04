package gestao_mesas;

public class mesas {

    // Classe para armazenar as informações de cada mesa
    public static class Mesa {
        int numero;
        int lugares;
        String estado;

        //Construtores
        public Mesa(int numero, int lugares, String estado) {
            this.numero = numero;
            this.lugares = lugares;
            this.estado = estado;
        }

        //Getters e Setters
        public int getNumero() {
            return numero;
        }

        public int getLugares() {
            return lugares;
        }

        public String getEstado() {
            return estado;
        }
        public void setNumero(int numero) {
            this.numero = numero;
        }
        public void setLugares(int lugares) {
            this.lugares = lugares;
        }
        public void setEstado(String estado) {
            this.estado = estado;
        }
        @Override
        public String toString() {
            return "Mesa " + numero + ": " + lugares + " lugares, " + estado;
        }

        public boolean isOcupada() {
            return estado.equals("ocupada");
        }

        public int getCapacidade() {
            return lugares * 2;
        }

        public void setOcupada(boolean b) {
            return ;
        }

        public String getNumeroMesa() {
            return numero + "";
        }
    }
}

