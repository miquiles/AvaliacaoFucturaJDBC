package com.fuctura.bean;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fuctura.DAO.PessoaDao;

import Entidades.Pessoa;



@ViewScoped
@ManagedBean (name = "pessoabean")
public class PessoaBean {
	
	private List<Pessoa> listaPessoas;
	
	Pessoa pessoa = new Pessoa();
	
	PessoaDao pessoaDao = new PessoaDao();
	
	// usuario com validação por cpf existente.
	public String salvar() {
		
		Pessoa novo = new Pessoa();

		novo.setNome(this.pessoa.getNome());
		novo.setCPF(this.pessoa.getCPF());
		novo.setEmail(this.pessoa.getEmail());
		novo.setDdd(this.pessoa.getDdd());
		novo.setNumero(this.pessoa.getNumero());
		novo.setTipo(this.pessoa.getTipo());

		
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
	this.pessoa = new Pessoa();

	
		}	return "";
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



	
	

}
