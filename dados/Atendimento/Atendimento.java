package dados.Atendimento;

import java.sql.Date;

import dados.Equipe;

public class Atendimento {

	private int cod;

	private Date dataInicio;

	private int duracao;

	private Status status;

	private Equipe equipe;

	public Atendimento(int cod, Date dataInicio, int duracao, Equipe equipe) {
		this.cod = cod;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.status = Status.PENDENTE;
		this.equipe = equipe;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public int getCod() {
		return cod;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public int getDuracao() {
		return duracao;
	}

	public Status getStatus() {
		return status;
	}

	public double calculaCusto() {
		// custo da equipe + custo dos equipamentos + custo de deslocamento
		return 0;
	}

}
