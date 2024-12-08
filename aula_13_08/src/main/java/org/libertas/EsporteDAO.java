package org.libertas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class EsporteDAO {
	
	public void salvar(Esporte e) {
		if(e.getIdEsporte() > 0) {
			alterar(e);
		} else {
			inserir(e);
		}
	}
	
	public boolean inserir(Esporte e) {
		ConexaoEsporte conn = new ConexaoEsporte();
		
		try {
			String sql = "INSERT INTO esporte (nome, categoria, numero_de_jogadores, popularidade, regras)" 
					+ " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setString(1, e.getNome());
			prep.setString(2, e.getCategoria());
			prep.setString(3, e.getnumero_de_jogadores());
			prep.setString(4, e.getPopularidade());
			prep.setString(5, e.getRegras());
			prep.execute();
			conn.desconecta();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			conn.desconecta();
			return false;
		}
	}
	
	public boolean alterar(Esporte e) {
		ConexaoEsporte conn = new ConexaoEsporte();
		try {
			String sql1 = "SELECT * FROM esporte WHERE idEsporte = ?";
			PreparedStatement prep1 = conn.getConnection().prepareStatement(sql1);
			prep1.setInt(1, e.getIdEsporte());
			ResultSet res = prep1.executeQuery();
			if (!res.next()) {
				conn.desconecta();
				return false;
			}
			
			String sql = "UPDATE esporte SET nome = ?, categoria = ?, numero_de_jogadores = ?, popularidade = ?, regras = ? WHERE idEsporte = ?";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setString(1, e.getNome());
			prep.setString(2, e.getCategoria());
			prep.setString(3, e.getnumero_de_jogadores());
			prep.setString(4, e.getPopularidade());
			prep.setString(5, e.getRegras());
			prep.setInt(6, e.getIdEsporte());
			prep.execute();
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.desconecta();
		return false;
	}
	
	public boolean excluir(Esporte e) {
		ConexaoEsporte conn = new ConexaoEsporte();
		try {
			String sql = "SELECT * FROM esporte WHERE idEsporte = ?";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setInt(1, e.getIdEsporte());
			ResultSet res = prep.executeQuery();
			if (!res.next()) {
				conn.desconecta();
				return false;
			}
			
			String sql1 = "DELETE FROM esporte WHERE idEsporte = ?";
			PreparedStatement prep1 = conn.getConnection().prepareStatement(sql1);
			prep1.setInt(1, e.getIdEsporte());
			prep1.execute();
			conn.desconecta();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			conn.desconecta();
		}
		return false;
	}
	
	public LinkedList<Esporte> listar(String pesquisa) {
		LinkedList<Esporte> lista = new LinkedList<Esporte>();
		ConexaoEsporte conn = new ConexaoEsporte();
		try {
			String sql = "SELECT * FROM esporte WHERE nome LIKE ? ORDER BY nome";
			PreparedStatement sta = conn.getConnection().prepareStatement(sql);
			sta.setString(1, "%" + pesquisa + "%");
			ResultSet res = sta.executeQuery();
			while (res.next()) {
				Esporte e = new Esporte();
				e.setIdEsporte(res.getInt("idEsporte"));
				e.setNome(res.getString("nome"));
				e.setCategoria(res.getString("categoria"));
				e.setnumero_de_jogadores(res.getString("numero_de_jogadores"));
				e.setPopularidade(res.getString("popularidade"));
				e.setRegras(res.getString("regras"));
				lista.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.desconecta();
		return lista;
	}
	
	public Esporte consultar(int id) {
		Esporte e = new Esporte();
		ConexaoEsporte conn = new ConexaoEsporte();
		try {
			String sql = "SELECT * FROM esporte WHERE idEsporte = " + id;
			Statement sta = conn.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				e.setIdEsporte(res.getInt("idEsporte"));
				e.setNome(res.getString("nome"));
				e.setCategoria(res.getString("categoria"));
				e.setnumero_de_jogadores(res.getString("numero_de_jogadores"));
				e.setPopularidade(res.getString("popularidade"));
				e.setRegras(res.getString("regras"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.desconecta();
		return e;
	}
}
