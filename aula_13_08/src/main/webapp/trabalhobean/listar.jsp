<%@page import="org.libertas.CidadeDAO"%>
<%@page import="org.libertas.Cidade"%>

<%@ page import="java.util.LinkedList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:useBean id="cdao" scope="page" class="org.libertas.CidadeDAO"/>
<div class="container mt-5">
    <h2 class="text-center">Lista de Cidades</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome da Cidade</th>
                <th>Uf</th>
                <th>CEP</th>
                <th>Populacao</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="c" items="${cdao.listar()}">
			<tr>
				<td>${c.nomeCidade}</td>
				<td>${c.uf}</td>
				<td>${c.cep}</td>
				<td>${c.populacao}</td>
				<td>
					<a href="formulario.jsp?idPessoa=${p.idCidade}">Alterar</a>
					<a href="excluir.jsp?idPessoa=${p.idCidade}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
    </table>
    <div class="text-center">
        <a href="formulario.jsp" class="btn btn-primary">Adicionar Nova Cidade</a>
        <a href="index.jsp" class="btn btn-secondary">Início</a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>