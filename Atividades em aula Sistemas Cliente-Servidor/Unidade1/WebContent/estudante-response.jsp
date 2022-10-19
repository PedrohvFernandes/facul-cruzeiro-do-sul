<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação do Estudante</title>
</head>
<body>
	<!-- recuperar uma info que esta vindo nesse caso do index -->
	<!-- Toda vez que a gente usa um paradigma de programçcao client-server
	todas as info que são enviadas, elas são enviadas atraves do objeto request
	 
	o atributo name dentro dos input são os parametros que vamos conseguir recuperar
	no request
	-->
	
	<!-- o = é a mesma coisa que o out.println
	
	o request é para que toda vez que a gente submete atraves de um form
	para eu conseguir recuperar as info que estao contidas dentro do form
	ele fica encpasulado dentro desse objeto request, que vem dentro do http url

	
	 -->
	 
	Aluno: <%=request.getParameter("nome") %>
	<br/>
	RGM: <%=request.getParameter("rgm") %>
	<br/>
	<p align="center">
		Última atualização 
		<!-- Isso é java, é tipo PHP, REACT etc -->
		<%
			//new java.util.Date();
		
			//formatado:
			
			Calendar calendar = new GregorianCalendar();
			
			String am_pm;
			int hour = calendar.get(calendar.HOUR);
			int minute = calendar.get(calendar.MINUTE);
			int second = calendar.get(calendar.SECOND);
			
			
			if(calendar.get(calendar.AM_PM) == 0){
				am_pm = "AM";
			} else {
				am_pm = "PM";
			}
			
			String CT = "Hora: "+hour+" Minutos: "+minute+" Segundos: "+second + ":"+am_pm ;
			
			out.print(CT);
		%>
	</p>
</body>
</html>