<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gravar.jsp" method="post">
		Nome:
		<input type="text" name="nome"/>
		<br>
		Telefone:
		<input type="text" name="telefone"/>
		<br>
		E-mail:
		<input type="text" name="email"/>
		<br>
		Cidade:
		<input type="text" name="cidade"/>
		<br>
		<input type="submit" name="salvar"/>
	</form>
</body>
</html>