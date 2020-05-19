package com.fuctura.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Entidades.Relatorio;

import com.fuctura.DAO.RelatorioDao;

@SessionScoped
@ManagedBean (name = "relatoriobean")
public class RelatorioBean {
	
	private List<Relatorio> listarRelatorio = new ArrayList<Relatorio>();
	
	Relatorio relatorio = new Relatorio();
	RelatorioDao relatorioDao = new RelatorioDao();
	
	
	public RelatorioBean() {
		
		this.relatorioDao = new RelatorioDao();
		this.setListarRelatorio(new ArrayList<Relatorio>());
		
	}
	
	
	public void CarregarRelatorio() {
		
		
		this.listarRelatorio = this.relatorioDao.listarTodos();
		
	}
	
	public String carregarLista() {
		
		CarregarRelatorio();
		return "";
	}





	public Relatorio getRelatorio() {
		return relatorio;
	}


	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}


	public RelatorioDao getRelatorioDao() {
		return relatorioDao;
	}


	public void setRelatorioDao(RelatorioDao relatorioDao) {
		this.relatorioDao = relatorioDao;
	}


	
	public List<Relatorio> getListarRelatorio() {
		return listarRelatorio;
	}


	public void setListarRelatorio(List<Relatorio> listarRelatorio) {
		this.listarRelatorio = listarRelatorio;
	}
	
	
	
}
