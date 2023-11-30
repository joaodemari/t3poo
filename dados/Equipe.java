package dados;

import java.util.ArrayList;

import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;

public class Equipe implements Comparable<Equipe> {
	private String codigo;
	private int quantidadeMembros;
	private double latitude;
	private double longitude;
	private ArrayList<Atendimento> atendimentos;
	private ArrayList<Equipamento> equipamentos;

	public Equipe(String codigo, int quantidadeMembros, double latitude, double longitude) {
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
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
		return this.codigo.compareTo(outraEquipe.codigo);
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + "; Membros: " + quantidadeMembros + "; Latitude: " + latitude + "; Longitude: "
				+ longitude;
	}

	public boolean estaDisponivel(String dataInicio, int duracao) {
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.getDataInicio().equals(dataInicio)) {
				return false;
			}
		}
		return true;
	}
}
