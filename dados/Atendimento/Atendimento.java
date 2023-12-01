package dados.Atendimento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dados.Equipe;
import dados.events.Event;

public class Atendimento {

	private int cod;

	private Date dataInicio;

	private int duracao;

	private Status status;

	private Equipe equipe;

	private Event event;

	public Atendimento(int cod, String dataInicio, int duracao, Status status, Equipe equipe, Event event)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.cod = cod;
		this.dataInicio = dateFormat.parse(dataInicio);
		this.duracao = duracao;
		this.status = status;
		this.equipe = equipe;
		this.event = event;
	}

	public Atendimento(int cod, String dataInicio, int duracao, Equipe equipe, Event event) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.cod = cod;
		this.dataInicio = dateFormat.parse(dataInicio);
		this.duracao = duracao;
		this.status = Status.PENDENTE;
		this.equipe = equipe;
		this.event = event;
	}

	public Atendimento(int cod, String dataInicio, int duracao, Event event) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.cod = cod;
		this.dataInicio = dateFormat.parse(dataInicio);
		this.duracao = duracao;
		this.status = Status.PENDENTE;
		this.equipe = null;
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setEquipe(Equipe equipe) {
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
		return 0;
	}

	@Override
	public String toString() {
		return "Código: " + cod + "; Data de Início: " + dataInicio + "; Duração: " + duracao + "; Status: " + status
				+ "; Equipe: " + equipe.getCodigo();
	}

}
