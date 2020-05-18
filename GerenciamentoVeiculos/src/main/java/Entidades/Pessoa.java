package Entidades;


public class Pessoa {
	
	
	private String CPF;
	private String nome;
	private String email;
	private String senha;
	
	
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Pessoa [CPF=" + CPF + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
	

	
}
