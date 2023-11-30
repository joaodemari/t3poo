package dados.Equipamento;

public enum Combustivel {
    DIESEL("Diesel"), GASOLINA("Gasolina"), ALCOOL("Álcool");

    private String nome;

    Combustivel(String nome) {
        this.nome = nome;
    }

    public static Combustivel getCombustivel(String nome) {
        nome.toLowerCase();
        switch (nome) {
            case "diesel":
                return DIESEL;
            case "gasolina":
                return GASOLINA;
            case "alcool":
                return ALCOOL;
            default:
                return null;
        }
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
