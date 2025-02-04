 class Reservas {

    String nome;
    int pessoas;
    int tempo;

     public Reservas(String nome, int pessoas, int tempo) {
        this.nome = nome;
        this.pessoas = pessoas;
        this.tempo = tempo;

     }
     public String getNome() {return nome;}

     public int getPessoas() {return pessoas;}

     public int getTempo() {return tempo;}


    public String toString() {return "Nome da Reserva: " + nome + " Pessoas: " + pessoas + " Tempo da marcação: " + tempo;}
}
