package model;

public class Pessoa {
	protected String nome;
	protected String idade;
	protected String email; 
	protected String telefone;
	
	public Pessoa(String nome, String idade, String email, String telefone) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
