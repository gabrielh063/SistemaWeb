package org.libertas;

public class Esporte {
	private int idEsporte;
	private String nome;
	private String categoria;
	private int numeroJogadores;
	private String popularidade;
	private String regras;

	public int getIdEsporte() {
		return idEsporte;
	}
	public void setIdEsporte(int idEsporte) {
		this.idEsporte = idEsporte;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getNumeroJogadores() {
		return numeroJogadores;
	}
	public void setNumeroJogadores(int numeroJogadores) {
		this.numeroJogadores = numeroJogadores;
	}
	public String getPopularidade() {
		return popularidade;
	}
	public void setPopularidade(String popularidade) {
		this.popularidade = popularidade;
	}
	public String getRegras() {
		return regras;
	}
	public void setRegras(String regras) {
		this.regras = regras;
	}

	@Override
	public String toString() {
		return "";
	}
}
