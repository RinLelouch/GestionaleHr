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
	<p>Ecco i dati del dipartimento ${dip.getDepartmentName()}:
	<p>Nome Dipartimento: ${dip.getDepartmentName()}</p>
	<p>Id: ${dip.getId()}</p>
	<p><a href="http://localhost:8080/gestionalehr/utenteselezionato?id_dipartimento=${dip.getId()}">Nome Manager: ${dip.getManagerName()}</a></p>
	<p>Cognome Manager: ${dip.getManagerSurname()}</p>
	<p>City: ${dip.getCity()}</p>

	<p>Lista dipendenti del dipartimento</p>
	<table>
		<tr>
			<th>ID Dipendente</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>JobTitle</th>
			<th>Dettagli Utenti</th>
		</tr>

		<c:forEach var="e" items="${emp}">
			<tr>
				<td>${e.getId()}</td>
				<td>${e.getName()}</td>
				<td>${e.getLastName()}</td>
				<td>${e.getJobTitle()}</td>
				<td><a
					href="http://localhost:8080/gestionalehr/utenteselezionato?id_dipendente=${e.getId()}">
						> Vai ai dettagli del dipendente</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>