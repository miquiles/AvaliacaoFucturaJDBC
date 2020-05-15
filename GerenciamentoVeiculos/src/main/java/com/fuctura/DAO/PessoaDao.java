package com.fuctura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidades.Pessoa;
import br.fuctura.util.JDBCUtil;

public class PessoaDao {

	public void inserir(Pessoa pessoa) {

		String sql = "insert into PESSOA (cpf, nome, email) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement insert = conexao.prepareStatement(sql);
			
			insert.setString(1, "444");
			insert.setString(2, "Amanda");
			insert.setString(3, "@hotmail.com");

			insert.execute();
			conexao.commit(); // salvando registros acima
			//insert.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
