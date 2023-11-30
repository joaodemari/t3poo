package dados.Equipamento;

public class Barco extends Equipamento {

	private int capacidade;

	public Barco(int id, String nome, double custoDia, int capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
	}

	public int getCapacidade() {
		return capacidade;
	}

	@Override
	public String getTipo() {
		return "Barco";
	}

	@Override
	public String toString() {
		return super.toString() + "; Capacidade: " + capacidade;
	}

}
