<%@page import="org.libertas.Pessoa"%>
<%@page import="org.libertas.PessoaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<th>Nome</th>
		<th>Telefone</th>
		<th>Email</th>
		<th>Cidade</th>
		<% 
			PessoaDAO dao = new PessoaDAO();
			for(Pessoa p : dao.listar()){
				out.print("<tr>");
				out.print("<td>" + p.getNome() + "</td>");
				out.print("<td>" + p.getTelefone() + "</td>");
				out.print("<td>" + p.getEmail() + "</td>");
				out.print("<td>" + p.getCidade() + "</td>");
				out.print("<tr>");
			}
		
		%>
	</table>
	
	<a href="index.jsp">Inicio</a>
</body>
</html>