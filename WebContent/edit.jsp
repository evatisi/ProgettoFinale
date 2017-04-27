<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Update" method="post">
		nome:<input type="text" name="contactNome" value="${contact.nome}"> <br>
		cognome:<input type="text" name="contactCognome" value="${contact.cognome}"><br>
		tel:<input type="text" name="contactTel" value="${contact.tel}"><br>
		mail:<input type="text" name="contactMail" value="${contact.mail}"><br>
		<input type="hidden" name="contactId" value="${contact.id}"><br>
		<input type="submit" value="termina modifica">
	</form>
</body>
</html>