package model;

public class Estante {
	private int capacidade;
	private int identificacao;
	
	public Estante(int capacidade, int identificacao) {
		super();
		this.capacidade = capacidade;
		this.identificacao = identificacao;
	}
	public int getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
}
