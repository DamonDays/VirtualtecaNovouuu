package model;

import java.util.ArrayList;

public class Sessao {
	private String identificacao;
	private String nome;
	private String estante;
	private String identificacaoEstante;
	private ArrayList<Livro> listaDeLivros = new ArrayList<>();

	public Sessao(String identificacao, String nome, String estante, String identificacaoEstante) {
		super();
		this.identificacao = identificacao;
		this.nome = nome;
		this.estante = estante;
		this.identificacaoEstante = identificacaoEstante;
	}
	public String getIdentificacaoEstante() {
		return identificacaoEstante;
	}
	public void setIdentificacaoEstante(String identificacaoEstante) {
		this.identificacaoEstante = identificacaoEstante;
	}
	public ArrayList<Livro> getListaDeLivros() {
		return listaDeLivros;
	}
	public void addListaDeLivros(Livro livro) {
		listaDeLivros.add(livro);
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstante() {
		return estante;
	}
	public void setEstante(String estante) {
		this.estante = estante;
	}
}
