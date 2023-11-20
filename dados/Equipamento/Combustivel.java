package dados.Equipamento;

public enum Combustivel {
    DIESEL("Diesel"), GASOLINA("Gasolina"), ALCOOL("Álcool");

    private String nome;

    Combustivel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
