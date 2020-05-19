package com.fuctura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Entidades.Relatorio;
import br.fuctura.util.JDBCUtil;

public class RelatorioDao {
	
public List<Relatorio> listarTodos() {

		
		String sql = "SELECT\r\n" + 
				"		p.cpf,\r\n" + 
				"		p.nome,\r\n" + 
				"       c.marca,\r\n" + 
				"       c.modelo,\r\n" + 
				"       o.peca,\r\n" + 
				"       o.servico,\r\n" + 
				"       c.placa\r\n" + 
				"		\r\n" + 
				"FROM pessoa as p \r\n" + 
				"INNER JOIN carro as c ON p.cpf = c.fk_cpf\r\n" + 
				"INNER JOIN ordem as o ON c.placa = o.fk_placa";
		
		List<Relatorio> listarRelatorio = new ArrayList<Relatorio>();
		
		Connection conexao;
		try {
			conexao = JDBCUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
			
				Relatorio relatorio = new Relatorio();
				
				relatorio.setTxtCpf(res.getString("CPF"));
				relatorio.setTxtNome(res.getString("NOME"));
				relatorio.setTxtMarca(res.getString("MARCA"));
				relatorio.setTxtModelo(res.getString("MODELO"));
				relatorio.setTxtPeca(res.getString("PECA"));
				relatorio.setTxtServico(res.getString("SERVICO"));
				relatorio.setTxtPlaca(res.getString("PLACA"));
				
				listarRelatorio.add(relatorio);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listarRelatorio;

	}
	
	

	

}
