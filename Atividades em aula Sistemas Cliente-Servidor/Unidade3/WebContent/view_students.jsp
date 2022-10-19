<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Lista Estudantes</h2>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Sobrenome</th>
			<th>Email</th>
		</tr>
		<c:forEach var="listStudents" items="${student_list}">
			<tr>
				<td>${listStudents.firstName}</td>
				<td>${listStudents.lastName}</td>
				<td>${listStudents.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>