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
		<h2>Dipartimenti</h2>
		<table>
			<tr>
				<th>ID Dipartimento</th>
				<th>Nome Dipartimento</th>
				<th>Nome Manager</th>
				<th>Cognome Manager</th>
				<th>Dettagli Utenti</th>
			</tr>
			<c:forEach var="dep" items="${departmentsResult}">
				<tr>
					<td>${dep.getId()}</td>
					<td>${dep.getDepartmentName()}</td>
					<td>${dep.getManagerName()}</td>
					<td>${dep.getManagerSurname()}</td>
					<td><a
						href="http://localhost:8080/gestionalehr/dipartimentoselezionato?dipartimento=${dep.getId()}">
							> Vai ai dettagli del dipartimento</a></td>

				</tr>
			</c:forEach>
		</table>

	</c:if>
</body>
</html>