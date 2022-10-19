<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Lista de alunos</h2>
		</div>
	</div>

	<div id="container">
		<h3>Adicioar Estudante</h3>

		<form action="StudentControllerServlet" method="GET">
			<input type="hidden" name="command" value="ADD" />

			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" /></td>
				</tr>

				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="save" /></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>