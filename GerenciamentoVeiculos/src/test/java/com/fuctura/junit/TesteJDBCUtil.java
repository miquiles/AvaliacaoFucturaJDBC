package com.fuctura.junit;
import java.sql.SQLException;

import org.junit.Test;

import com.fuctura.DAO.PessoaDao;


import Entidades.Pessoa;





public class TesteJDBCUtil {

		@Test
		public void initBanco() throws SQLException  {
			

		Pessoa pessoa = new Pessoa();
		
		PessoaDao pessoaDao = new PessoaDao();
		
		pessoaDao.listarCPF();
		
		pessoa.setCPF("112");
		
		System.out.println(pessoa.getCPF());
		
		
		
		
		
		}
	}
		
		
		
		
		
		