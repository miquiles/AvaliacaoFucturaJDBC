package com.fuctura.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fuctura.DAO.OrdemDao;

import Entidades.Ordem;

@SessionScoped
@ManagedBean (name = "ordembean")
public class OrdemBean {

	OrdemDao ordemDao = new OrdemDao();
	Ordem ordem = new Ordem();
	
	

	
	public void abrir_ordem() {
		
		this.ordemDao.inserir(ordem);
		this.ordemDao = new OrdemDao();
		
	}

	public OrdemDao getOrdemDao() {
		return ordemDao;
	}

	public void setOrdemDao(OrdemDao ordemDao) {
		this.ordemDao = ordemDao;
	}

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
	
	
	
	
}
