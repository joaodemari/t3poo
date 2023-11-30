package dados.Equipamento;

public abstract class Equipamento {

	private int id;

	private String nome;

	private double custoDia;

	public Equipamento(int id, String nome, double custoDia) {
		this.id = id;
		this.nome = nome;
		this.custoDia = custoDia;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getCustoDia() {
		return custoDia;
	}

	public abstract String getTipo();

	@Override
	public String toString() {
		return "ID: " + id + "; Nome: " + nome + "; Custo por dia: " + custoDia + "; Tipo: " + getTipo();
	}
}
