package com.fuctura.bean;



import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fuctura.DAO.PessoaDao;


import Entidades.Pessoa;



@SessionScoped
@ManagedBean (name = "pessoabean")
public class PessoaBean {
	
	private List<Pessoa> listaPessoas;
	private List<Pessoa> listaUser;

	
	private List<Pessoa> listarPessoas = new ArrayList<Pessoa>();

	
	
	Pessoa pessoa = new Pessoa();
	
	PessoaDao pessoaDao = new PessoaDao();
	
	
	
	public PessoaBean(){
		this.pessoaDao = new PessoaDao();
		
		this.setListaPessoas(new ArrayList<Pessoa>());
		
		
	}
	
	
	
	
public void carregarPessoas() {
	
		
		this.listaPessoas = this.pessoaDao.listarTodos();
		
		
		
	}

public void carregarUser() {
	
	
	this.setListaUser(this.pessoaDao.listarUsuario());
	
	
	
}



// Se der merda, volta o metodo que está comentado

public String edit_user() {
	carregarPessoas();
	//carregarUser();
	System.out.println("Era pra carregar todos os usuário");
	return "";	
} 


// nao mexer
public String update() {
	
	this.pessoaDao.atualizar(pessoa);
	this.pessoa = new Pessoa();
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuário Atualizado com sucesso"));
	


	return "";
	
	
}
	
	
	
	
	// usuario com validação por cpf existente.
	public String salvar() {
		
		Pessoa novo = new Pessoa();

		novo.setNome(this.pessoa.getNome());
		novo.setCPF(this.pessoa.getCPF());
		novo.setEmail(this.pessoa.getEmail());
		novo.setSenha(this.pessoa.getSenha());

		
		boolean contemUser = false;
		
		this.listaPessoas = this.pessoaDao.listarTodos();
		
		for (Pessoa pessoaPesquisa : listaPessoas) {
			if (pessoaPesquisa.getCPF().equals(this.pessoa.getCPF()) ) {
				contemUser = true;
			}
		}
		if (contemUser) {
			
			System.out.println("Usuário já existe no sistema.");
			
		}else {
	
	
	this.pessoaDao.inserir(this.pessoa);
	
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Salvo com sucesso"));
	
	
	
		return "principal.xhtml";
	
		}	
		
		return "";
	}
	
	
	public String remove() {
		this.pessoaDao.remover(pessoa);
	
		this.pessoa = new Pessoa();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Removido com sucesso"));
		return "";
		
		
	}
	
	public String pesquisar() {
		this.pessoaDao.pesquisar(pessoa.getCPF());
		this.pessoa = new Pessoa();
		return"";
		
		
	}
	


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}


	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}


	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public List<Pessoa> getListarPessoas() {
		return listarPessoas;
	}

	public void setListarPessoas(List<Pessoa> listarPessoas) {
		this.listarPessoas = listarPessoas;
	}






	public List<Pessoa> getListaUser() {
		return listaUser;
	}




	public void setListaUser(List<Pessoa> listaUser) {
		this.listaUser = listaUser;
	}



}
