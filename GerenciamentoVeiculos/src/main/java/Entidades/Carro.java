package Entidades;



public class Carro {
	
	
	
	private String CPF_Pessoa;
	private String marca;
	private String modelo;
	private String ano;
	private String placa;
	
	
	
	
	
	public String getCPF_Pessoa() {
		return CPF_Pessoa;
	}
	public void setCPF_Pessoa(String cPF_Pessoa) {
		CPF_Pessoa = cPF_Pessoa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Carro [CPF_Pessoa=" + CPF_Pessoa + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + "]";
	}
	
	
	
	
}
