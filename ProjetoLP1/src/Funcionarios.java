
class Funcionarios {
    String nome;
    String id;
    String tipoFuncionario;

    //Construtores
    public Funcionarios(String nome, String id, String tipoFuncionario) {
        this.nome = nome;
        this.id = id;
        this.tipoFuncionario = tipoFuncionario;

    }

    //Getters
    public String getNome() {return nome;}

    public String getId() {return id;}

    public String getTipoFuncionario() {return tipoFuncionario;}

}