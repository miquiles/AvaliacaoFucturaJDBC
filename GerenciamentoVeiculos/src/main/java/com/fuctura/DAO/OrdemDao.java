package com.fuctura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidades.Ordem;
import br.fuctura.util.JDBCUtil;

public class OrdemDao {


	public void inserir(Ordem ordem) {
		
		String sql = "insert into ordem (peca,servico,tecnico,fk_placa) values (?,?,?,?)";
		
		Connection connectionFactory;
		
		try {
			
			connectionFactory = JDBCUtil.getConexao();
			PreparedStatement statement = connectionFactory.prepareStatement(sql);
			
			statement.setString(1, ordem.getPeca());
			statement.setString(2, ordem.getServico());
			statement.setString(3, ordem.getTecnico());
			statement.setString(4, ordem.getPlaca_carro());
			
			statement.execute();
			
			connectionFactory.commit();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
}
