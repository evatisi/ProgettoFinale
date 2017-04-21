<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista contatti</title>
</head>
<body>

<form action="List" method="get">
	
		
			
	
</form>

<table>
	<tr>
    <th>ID</th>
    <th>Nome</th> 
    <th>Cognome</th>
    <th>Tel</th>
    <th>Mail</th>
  </tr>
  <!--  ciclo i contatti della lista $list -->
  <c:forEach  items="${list}" var="contact" >
  <tr>
    <td>${contact.nome}</td>
    <td>${contact.cognome}</td>
    <td>${contact.tel}</td>
    <td>${contact.mail}</td>
    
  </tr>
  
  </c:forEach>
  
  
</table>
		
<a href="add.jsp"> 	<input type="submit" value="Elimina"> </a>
		
<a href="edit.jsp"> oppure 	<input type="submit" value="Modifica"> </a>
	

</body>
</html>