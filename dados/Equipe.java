package dados;

import java.lang.reflect.Array;
import java.util.ArrayList;

import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;

public class Equipe implements Comparable<Equipe> {
	private String codinome;
	private int quantidadeMembros;
	private double latitude;
	private double longitude;
	private ArrayList<Atendimento> atendimentos;
	private ArrayList<Equipamento> equipamentos;

	public Equipe(String codinome, int quantidadeMembros, double latitude, double longitude) {
		this.codinome = codinome;
		this.quantidadeMembros = quantidadeMembros;
		this.latitude = latitude;
		this.longitude = longitude;
		this.atendimentos = new ArrayList<>();
		this.equipamentos = new ArrayList<>();
	}

	public void addAtendimento(Atendimento atendimento) {
		atendimentos.add(atendimento);
	}

	public void vincularEquipamento(Equipamento equipamento) {
		equipamentos.add(equipamento);
	}

	public String getCodinome() {
		return codinome;
	}

	public int getQuantidadeMembros() {
		return quantidadeMembros;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public int compareTo(Equipe outraEquipe) {
		return this.codinome.compareTo(outraEquipe.codinome);
	}

	@Override
	public String toString() {
		return "Codinome: " + codinome + "; Membros: " + quantidadeMembros + "; Latitude: " + latitude + "; Longitude: "
				+ longitude;
	}
}
