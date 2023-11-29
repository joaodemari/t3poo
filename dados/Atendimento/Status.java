package dados.Atendimento;

public enum Status {
    PENDENTE("pendente"), EXECUTANDO("executando"), FINALIZADO("finalizado"), CANCELADO("cancelado");

    private String nome;

    Status(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Status getStatus(String nome) {
        nome.toLowerCase();
        switch (nome) {
            case "pendente":
                return PENDENTE;
            case "executando":
                return EXECUTANDO;
            case "finalizado":
                return FINALIZADO;
            case "cancelado":
                return CANCELADO;
            default:
                return null;
        }
    }
}
