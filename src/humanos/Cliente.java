package humanos;

public class Cliente extends Pessoa {
    private String numeroContato;
    private String endereco;
    private double quantidadeDinheiro;

    @Override
    void visualizar() {
        super.visualizar();
        System.out.println("numero para contato :" + numeroContato);
        System.out.println("endereço :" + endereco);

    }

    public Cliente(String nome, String numeroContato, String endereco, double quantidadeDinheiro) {
        super(nome);
        this.numeroContato = numeroContato;
        this.endereco = endereco;
        this.quantidadeDinheiro = quantidadeDinheiro;
    }

    public Cliente() {
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getQuantidadeDinheiro() {
        return quantidadeDinheiro;
    }

    public void setQuantidadeDinheiro(double quantidadeDinheiro) {
        this.quantidadeDinheiro = quantidadeDinheiro;
    }
}

