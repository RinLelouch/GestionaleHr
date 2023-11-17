<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${autorizzato == true }">
	
		<h2>Dipendenti Alto</h2>
		<table>
			<tr>
				<th>ID Dipendente</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Email</th>
				<th>Dettagli Utenti</th>
			</tr>
			<c:forEach var="gen" items="${listaRicercati}">
				<tr>
					<td>${gen.getEmployeeId()}</td>
					<td>${gen.getFirstName()}</td>
					<td>${gen.getLastName()}</td>
					<td>${gen.getEmail()}</td>
					<td><a
						href="http://localhost:8080/gestionalehr/utenteselezionato?id_dipendente=${gen.getEmployeeId()}">
							> Vai ai dettagli dell'utente</a></td>

				</tr>
			</c:forEach>
		</table>
</c:if>
</body>
</html>