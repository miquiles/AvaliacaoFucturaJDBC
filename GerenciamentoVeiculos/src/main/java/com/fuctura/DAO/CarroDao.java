package com.fuctura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import Entidades.Carro;

import br.fuctura.util.JDBCUtil;

public class CarroDao {
	
	public void inserir(Carro carro) {

		String sql = "insert into CARRO (fk_cpf,marca,modelo,ano,placa) values (?,?,?,?,?)";

		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement insert = conexao.prepareStatement(sql);
			
			
			

			insert.setString(1, carro.getCPF_Pessoa());
			insert.setString(2, carro.getMarca());
			insert.setString(3, carro.getModelo());
			insert.setString(4, carro.getAno());
			insert.setString(5, carro.getPlaca());
			
			
			insert.execute();
			conexao.commit(); 
			//insert.close();
		
			System.out.println(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	
	
	
		

}
