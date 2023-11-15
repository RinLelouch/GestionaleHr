<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.advanciastage.gestionalehr.entity.EmployeeDTO"%>

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
		<h2>Dipendenti</h2>
		<table>
			<tr>
				<th>ID Dipendente</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Email</th>
			</tr>
			<c:forEach var="gen" items="${listaRicercati}">
				<tr>
					<td>${gen.getId()}</td>
					<td>${gen.getName()}</td>
					<td>${gen.getLastName()}</td>
					<td>${gen.getEmail()}</td>

				</tr>
			</c:forEach>
		</table>

	</c:if>
</body>
</html>