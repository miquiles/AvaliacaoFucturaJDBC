package com.fuctura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Pessoa;

import br.fuctura.util.JDBCUtil;

public class PessoaDao {

	public void inserir(Pessoa pessoa) {

		String sql = "insert into PESSOA (cpf, nome, email, tipo, ddd, numero) values (?, ?, ?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement insert = conexao.prepareStatement(sql);
			
			insert.setString(1, pessoa.getCPF());
			insert.setString(2, pessoa.getNome());
			insert.setString(3, pessoa.getEmail());
			insert.setString(4, pessoa.getTipo());
			insert.setString(5, pessoa.getDdd());
			insert.setString(6, pessoa.getNumero());
			
			
		
			
			
			
			

			insert.execute();
			conexao.commit(); // salvando registros acima
			//insert.close();
		
			System.out.println(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	public List<Pessoa> listarTodos() {

		String sql = "select nome,cpf,email,numero,tipo, ddd from PESSOA";
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setCPF(res.getString("CPF"));
				pessoa.setNome(res.getString("NOME"));
				pessoa.setEmail(res.getString("EMAIL"));
				pessoa.setTipo(res.getString("NUMERO"));
				pessoa.setDdd(res.getString("TIPO"));
				pessoa.setNumero(res.getString("DDD"));
				
				listaPessoas.add(pessoa);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPessoas;

	}

	
	
}