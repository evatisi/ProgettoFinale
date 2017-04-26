<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="List" method="post">
		<! Contact contact = request.getParameter("contact"); !>
		nome:<input type="text" value="<%= %>"> <br>
		cognome:<input type="text" value="<% request.getParameter("cognome");%>"><br>
		tel:<input type="text" value="<% request.getParameter("tel");%>"><br>
		mail:<input type="text" value="<% request.getParameter("mail");%>"><br>
		
		<input type="submit" value="termina modifica">
	</form>
</body>
</html>