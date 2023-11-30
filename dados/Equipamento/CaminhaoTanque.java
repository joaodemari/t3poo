package dados.Equipamento;

public class CaminhaoTanque extends Equipamento {

	private double capacidade;

	public CaminhaoTanque(int id, String nome, double custoDia, double capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
	}

	public double getCapacidade() {
		return capacidade;
	}

	@Override
	public String getTipo() {
		return "Caminhão Tanque";
	}

	@Override
	public String toString() {
		return super.toString() + "; Capacidade: " + capacidade;
	}

}
