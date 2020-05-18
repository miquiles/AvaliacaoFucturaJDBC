package com.fuctura.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import com.fuctura.DAO.PessoaDao;


import Entidades.Pessoa;


@ViewScoped
@ManagedBean (name = "loginbean")
public class LoginBean {
	

	private String txtEmail;
	private String txtSenha;
	
	private List<Pessoa> listaPessoas;
	private Pessoa pessoa; // Objeto para cadastro


	private PessoaDao pessoaDao;
	
	public LoginBean(){
		this.listaPessoas = new ArrayList<Pessoa>();
		this.pessoa = new Pessoa();
		this.pessoaDao = new PessoaDao();
	
	}
	
	
	public String entrar() {

		boolean achou = false;

		this.listaPessoas = this.pessoaDao.listarTodos();
		
		for (Pessoa pessoaPesquisa : listaPessoas) {

			if (pessoaPesquisa.getEmail().equals(this.txtEmail) && pessoaPesquisa.getSenha().equals(this.txtSenha))  {

				achou = true;
			}
		}

		if (achou){
			System.out.println("Seja bem vindo");
			return "principal.xhtml";
			
		} else {
			System.out.println("Usuário não existe. Cadastre para acessar o sistema");
			return "login.xhtml";
		}

	}
	
	
	
	


	

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}








	public String getTxtSenha() {
		return txtSenha;
	}








	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}








	





	

}
