<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><% out.println("Unidade 1"); %></title>
</head>
<style>
	.cor {
		color: red;
		
	
	}

</style>
<body>
	<!--action: quem é que vai receber a requisção ao enviar os dados  
	se tirar o method as info aparecem na url
	-->
	<form action="estudante-response.jsp" method="post">
		Nome: <input type="text" name='nome' class='cor'/>
		<br/><br/>
		RGM: <input type="text" name='rgm'/>
		<br/><br/>
		<input type="submit" value='Enviar'/>
	</form>
</body>
</html>