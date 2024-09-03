package org.libertas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PessoaDAO {
//	private static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	public void inserir(Pessoa p) {
//		lista.add(p);
		Conexao conn = new Conexao();
		
		try {
			String sql = "INSERT INTO pessoa (nome, telefone, email, cidade)" + " VALUES (?, ?, ?, ?)";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCidade());
			prep.execute();
;		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.desconecta();
	}
	
	public void alterar(Pessoa p) {
		Conexao conn = new Conexao();
		try {
			String sql = "UPDATE pessoa SET" + "nome = ?, telefone = ?, " + " email = ?, cidade = ? " + "WHERE idPessoa = ?";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCidade());
			prep.setInt(5, p.getIdPessoa());
			prep.execute();
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.desconecta();
	}
	
	public void excluir(Pessoa p) {
		Conexao conn = new Conexao();
		try {
			String sql = "DELETE FROM pessoa WHERE idPessoa = ?";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setInt(1, p.getIdPessoa());
			prep.execute();
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.desconecta();
	}

	public LinkedList<Pessoa> listar() {
		LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
		Conexao conn = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa";
			Statement sta = conn.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pessoa p = new Pessoa();
				p.setIdPessoa(res.getInt("idPessoa"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.desconecta();
		return lista;
	}
	
}