package org.libertas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PessoaDAO {
//	private static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	public void salvar(Pessoa p) {
		if(p.getIdPessoa()>0) {
			alterar(p);
		}else {
			inserir(p);
		}
	}
	
	
	public void inserir(Pessoa p) {
//		lista.add(p);
		Conexao conn = new Conexao();
		
		try {
			String sql = "INSERT INTO pessoa (nome, telefone, email, cidade, endereco, cep)" + " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCidade());
			prep.setString(5, p.getEndereco());
			prep.setString(6, p.getCep());
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
			String sql = "UPDATE pessoa SET" + "nome = ?, telefone = ?, " + " email = ?, cidade = ?, endereco = ?, cep = ? " + "WHERE idPessoa = ?";
			PreparedStatement prep = conn.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCidade());
			prep.setInt(5, p.getIdPessoa());
			prep.setString(6, p.getEndereco());
			prep.setString(7, p.getCep());
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
				p.setEndereco(res.getString("endereco"));
				p.setCep(res.getString("cep"));
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.desconecta();
		return lista;
	}
	public Pessoa consultar(int id) {
		Pessoa p = new Pessoa();
		Conexao conn = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa WHERE idPessoa = " + id;
			Statement sta = conn.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				p.setIdPessoa(res.getInt("idPessoa"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				p.setEndereco(res.getString("endereco"));
				p.setCep(res.getString("cep"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return p;
		}
		conn.desconecta();
	}

}
