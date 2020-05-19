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

		String sql = "insert into PESSOA (cpf, nome, email,senha) values (?,?,?,?)";

		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement insert = conexao.prepareStatement(sql);
			
			
			
	
			insert.setString(1, pessoa.getCPF());
			insert.setString(2, pessoa.getNome());
			insert.setString(3, pessoa.getEmail());
			insert.setString(4, pessoa.getSenha());
			
			
			insert.execute();
			conexao.commit(); 
			//insert.close();
		
			System.out.println(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	public List<Pessoa> listarUsuario() {

		Pessoa pessoa = new Pessoa();
		String sql = "select nome,cpf,email,senha from PESSOA where cpf="+ pessoa.getCPF();
		
		List<Pessoa> listaUser = new ArrayList<Pessoa>();
		
		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
			
				
				
				pessoa.setNome(res.getString("NOME"));
				pessoa.setCPF(res.getString("CPF"));
				pessoa.setEmail(res.getString("EMAIL"));
				pessoa.setSenha(res.getString("SENHA"));
				
				listaUser.add(pessoa);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaUser;

	}
	
	
	public List<Pessoa> listarTodos() {

		
		String sql = "select nome,cpf,email,senha from PESSOA";
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
			
				Pessoa pessoa = new Pessoa();
				
				pessoa.setNome(res.getString("NOME"));
				pessoa.setCPF(res.getString("CPF"));
				pessoa.setEmail(res.getString("EMAIL"));
				pessoa.setSenha(res.getString("SENHA"));
				
				listaPessoas.add(pessoa);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPessoas;

	}
	
	

	
	// nao mexer
	public void atualizar(Pessoa pessoa) {
		
		

		String sql = "update pessoa set cpf=?, nome=?, email=?,senha=? where cpf="+pessoa.getCPF();

		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement insert = conexao.prepareStatement(sql);
			
			insert.setString(1, pessoa.getCPF());
			insert.setString(2, pessoa.getNome());
			insert.setString(3, pessoa.getEmail());
			insert.setString(4, pessoa.getSenha());
			
			
		
			
			
			
			

			insert.execute();
			conexao.commit(); // salvando registros acima
			//insert.close();
		
			System.out.println(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	
	
	public Pessoa pesquisar(String cpf) {
		Pessoa pessoa = new Pessoa();

		String sql = "select cpf, nome, email, senha from PESSOA  where cpf ="+pessoa.getCPF();
		
		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, pessoa.getCPF());

			ResultSet res = ps.executeQuery();

			
				
				pessoa.setCPF(res.getString("CPF"));
				pessoa.setNome(res.getString("NOME"));
				pessoa.setEmail(res.getString("EMAIL"));
				pessoa.setSenha(res.getString("SENHA"));
			
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pessoa;
	}
	
	
	public void remover(Pessoa pessoa) {

		String sql = "DELETE FROM PESSOA WHERE cpf = ?";

		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, pessoa.getCPF());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
}