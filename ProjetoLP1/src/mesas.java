 class mesas {

    // Classe para armazenar as informações de cada mesa
    public static class Mesa {
        int numero;
        int lugares;
        String estado;

        public Mesa(int numero, int lugares, String estado) {
            this.numero = numero;
            this.lugares = lugares;
            this.estado = estado;
        }

        @Override
        public String toString() {
            return "Mesa " + numero + ": " + lugares + " lugares, " + estado;
        }
    }
}