package br.fuctura.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	// 	pattern singleton java JDBC
	
	public static Connection getConexao() throws SQLException {
		
		

		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			conexao = DriverManager.getConnection( // Com JDBC precisamos setar no banco de dados o comando SET @@global.time_zone = '+3:00';
					"jdbc:mysql://localhost:3306/dbcarro2?useTimezone=true&ampserverTimezone=UTC​​&relaxAutoCommit=true", "root","12345");
			System.out.println("Conexão bem sucedida.");
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			
		}
		
		return conexao;
	}


	

}
