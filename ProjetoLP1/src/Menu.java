
class Menu {

   String nome;
   String categoria;
   float PC;
   float PV;
   double tempoPreparacao;
   double tempoConsumo;
   boolean estado;

    //Construtores
    public Menu(String nome, String categoria, float PC, float PV, boolean estado) {
        this.nome = nome;
        this.categoria = categoria;
        this.PC = PC;
        this.PV = PV;
        this.estado = estado;

    }
    //Getters
    public String getNome() {return nome;}

    public String getCategoria() {return categoria;}

    public float getPC() {return PC;}

    public float getPV() {return PV;}

    public double getTempoPreparacao() {return tempoPreparacao;}

    public double getTempoConsumo() {return tempoConsumo;}

    public boolean isEstado() {return estado;}


}


