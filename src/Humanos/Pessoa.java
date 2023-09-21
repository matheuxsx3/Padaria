package Humanos;

public abstract class Pessoa {
    private String nome;


    public Pessoa(String nome) {
        this.nome = nome;
    }

    protected Pessoa() {
    }

    void visualizar() {
        System.out.println("nome : " + nome);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
