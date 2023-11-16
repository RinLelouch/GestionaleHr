
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:if test="${autorizzato == true}">

		<c:if test="${ALTO == true}">
			<form action="/gestionalehr/searchuserpage" method="post">
				<input type="submit" value="Ricerca Dipendenti">
			</form>
			<form action="/gestionalehr/searchdepartmentpage" method="get">
				<input type="submit" value="Ricerca Dipartimenti">
			</form>
		</c:if>

		<c:if test="${MEDIO == true}">
			<form action="/gestionalehr/searchuserpage" method="post">
				<input type="submit" value="Ricerca Dipendenti">
			</form>
		</c:if>
		<form action="/gestionalehr/datipersonali" method="post">
			<input type="submit" value="Dati Personali">
		</form>
		<form action="/gestionalehr/Logout" method="get">
			<input type="submit" value="Logout">
		</form>
	</c:if>
</body>
</html>