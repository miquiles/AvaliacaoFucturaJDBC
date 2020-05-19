package com.fuctura.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.fuctura.DAO.CarroDao;

import Entidades.Carro;


@SessionScoped
@ManagedBean (name = "carrobean")
public class CarroBean {
	
	Carro carro = new Carro();
	CarroDao carroDao = new CarroDao();
	
	
	
	public CarroBean() {
		
		
		this.carro = new Carro();
		this.carroDao = new CarroDao();
		//this.loginBean = new LoginBean();
	}
	
	
	
	
	public String salvar_carro() {
		
		this.carroDao.inserir(this.carro);
		this.carroDao = new CarroDao();
		
		return"";
	}
	
	
	
	
	






	public Carro getCarro() {
		return carro;
	}






	public void setCarro(Carro carro) {
		this.carro = carro;
	}






	public CarroDao getCarroDao() {
		return carroDao;
	}






	public void setCarroDao(CarroDao carroDao) {
		this.carroDao = carroDao;
	}










	
	
	
}
