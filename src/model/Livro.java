package model;

public class Livro {
	private String nome;
	private String autor;
	private String anoPublicacao;
	private String sessao;
	private boolean disponivel = true;
	
	public Livro(String nome, String autor, String anoPublicacao, String sessao){
		this.nome = nome;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;	
		this.sessao = sessao;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getSessao() {
		return sessao;
	}
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	@Override
	public String toString() {
		if(disponivel){
			return "Livro [nome=" + nome + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", sessao=" + sessao
					+ ", disponivel=sim" + "]";
		}else{
		return "Livro [nome=" + nome + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", sessao=" + sessao
				+ ", disponivel=não" + "]";
		}
	}
	
}
