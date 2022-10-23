<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Adicionar o elemento para trabalhar com Form, mas temos que colocar a taglib que trabalhe com isso, so que nesse
caso não é jstl mas sim do framework spring -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Empregado</title>
</head>
<body>
<!-- 
	Quando essa pagina estiver carregada, ela vai ser associada aos campos
	que foi colocado no EmployeeController -> model.addAttribute("employee", employee); que 
	vem da classe Employee
 -->	
 
 	<h2>Registrar Empregado</h2>
 	<!-- Os elementos agora sao do framework do spring mvc e nao diretamente do html -->
 	<!-- modelAttribute é para associar tudo que eu colocar nesse form criado aqui, eu vou associar a esse elemento que eu acabei de adicionar-->
 	<!--  ou seja todos os atributos vindo da classe employee, que vem do EmployeeController do metodo model.addAttribute() passados pro atributo do elemento form do spring mvc suposto HTML modelAttribute 
 	que futuramente é passados para outros elementos HTML spring por exemplo o input
 	-->
 	<!-- Esse action é para a onde a gente vai enviar, ou seja o EmplpyeeController vai receber e dele é mapeado /processForm -->
 	<form:form action="processForm" modelAttribute="employee">
 	<!--  Eu vou colocar o atributo path do input que vem do spring mvc que vai ser relacionado ao atributo da classe employee -->
 	<!-- Ou seja quando esse input for criado na tela ele vai ficar associado ao atributo id do employee que esta vindo do framework usando o model.addAttribute() -->	
 		id:<form:input path="id"/>
 		<!-- a tratativa ocorre pelo mesmo elemento que foi criado no Employee. Ou seja na hora de submeter e der erro nas regras vai ser nessa tag de erros que ele vai escrever-->
 		<form:errors path="id"></form:errors>
 		<br/><br/>
 		
 		Nome:<form:input path="firstName"/>
 		<form:errors path="firstName"></form:errors>
 		<br/><br/>
 		
 		Sobrenome:<form:input path="lastName"/>
 		<br/><br/>
 		
		Sobrenome:<form:input path="lastName"/>
 		<br/><br/>
 		
 		Cidade:
 		<form:select path="city">
 			<form:options items="${employee.citiesOptions}"/>
 		</form:select>
 		<input type="submit" value="Enviar"/>
 	</form:form>
</body>
</html>