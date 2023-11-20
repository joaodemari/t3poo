package dados.Equipamento;

public class Escavadeira extends Equipamento {

	private Combustivel combustivel;

	private double carga;

	public Escavadeira(int id, String nome, double custoDia, Combustivel combustivel, double carga) {
		super(id, nome, custoDia);
		this.combustivel = combustivel;
		this.carga = carga;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public double getCarga() {
		return carga;
	}

}
