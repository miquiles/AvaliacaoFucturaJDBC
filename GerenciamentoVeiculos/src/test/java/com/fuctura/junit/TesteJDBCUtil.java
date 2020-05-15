package com.fuctura.junit;
import java.sql.SQLException;

import org.junit.Test;

import com.fuctura.DAO.PessoaDao;

import Entidades.Pessoa;


public class TesteJDBCUtil {

		@Test
		public void initBanco() throws SQLException  {
			
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = new Pessoa();
		
		pessoaDao.inserir(pessoa);
		
		
	}
}
