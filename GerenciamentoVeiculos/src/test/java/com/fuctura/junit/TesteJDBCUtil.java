package com.fuctura.junit;
import java.sql.SQLException;

import org.junit.Test;

import com.fuctura.DAO.PessoaDao;
import com.fuctura.DAO.UsuarioDao;

import Entidades.Pessoa;





public class TesteJDBCUtil {

		@Test
		public void initBanco() throws SQLException  {
			
		UsuarioDao usuarioDao = new UsuarioDao();
		//Pessoa pessoa = new Pessoa();
		
		usuarioDao.listarTodos();
		
	
		
		}
	}
		
		
		
		
		
		