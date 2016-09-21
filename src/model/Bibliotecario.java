package model;

public class Bibliotecario extends Pessoa {
	private String senha;
	
	public Bibliotecario(String nome, String idade, String email, String telefone, String senha) {
		super(nome, idade, email, telefone);
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
