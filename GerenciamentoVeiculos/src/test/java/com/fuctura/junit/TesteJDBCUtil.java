package com.fuctura.junit;
import java.sql.SQLException;

import org.junit.Test;

import com.fuctura.DAO.PessoaDao;
import com.fuctura.DAO.RelatorioDao;

import Entidades.Pessoa;
import Entidades.Relatorio;





public class TesteJDBCUtil {

		@Test
		public void initBanco() throws SQLException  {
			

		Relatorio relatorio = new Relatorio();
		
		RelatorioDao relatorioDao = new RelatorioDao();
		
	
		relatorioDao.listarTodos();
		System.out.println(relatorioDao.listarTodos());
		
		
		
		
		
		
		}
	}
		
		
		
		
		
		