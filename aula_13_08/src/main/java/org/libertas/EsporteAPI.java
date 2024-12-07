package org.libertas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import com.google.gson.Gson;

/**
 * Servlet implementation class EsporteAPI
 */
@WebServlet("/EsporteAPI/*")
public class EsporteAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EsporteAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EsporteDAO edao = new EsporteDAO();
		Gson gson = new Gson();
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
		}
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	
		String pesquisa = request.getParameter("pesquisa");

		String resposta;
		if (id == 0) {
			// listar todos os esportes
			resposta = gson.toJson(edao.listar(pesquisa));
		} else {
			// listar apenas 1 esporte
			resposta = gson.toJson(edao.consultar(id));
		}
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pega o body da requisicao
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		// converte o body para um objeto java
		Gson gson = new Gson();
		Esporte e = gson.fromJson(body, Esporte.class);
		// salvar novo esporte	
		EsporteDAO edao = new EsporteDAO();
		Retorno r = new Retorno();
		
		// envia resposta
		r.setSucesso(edao.inserir(e));
		r.Mensagem(r);
		String resposta = gson.toJson(r);
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pega o body da requisicao
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		// converte o body para um objeto java			
		Gson gson = new Gson();
		Esporte e = gson.fromJson(body, Esporte.class);
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
		}
		// alterar um esporte	
		Retorno r = new Retorno();
		EsporteDAO edao = new EsporteDAO();
		// envia resposta
		e.setIdEsporte(id);
		r.setSucesso(edao.alterar(e));
		r.Mensagem(r);
		String resposta = gson.toJson(r);
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
			
		}
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson gson = new Gson();
		Retorno r = new Retorno();
		EsporteDAO edao = new EsporteDAO();
		Esporte e = new Esporte();

		e.setIdEsporte(id);
		r.setSucesso(edao.excluir(e));
		r.Mensagem(r);
		String resposta = gson.toJson(r);
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}
}
