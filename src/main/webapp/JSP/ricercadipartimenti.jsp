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
<form action="/gestionalehr/searchdepartments">
	<p>
			Ricerca per id: <input type="text" name="id">
		</p>
		<select name="nomeDipartimento">
			<option value="">Scegli il dipartimento</option>
			<c:forEach var="dipartimento" items="${departments}">
				<option value="${dipartimento.getDepartmentName()}">${dipartimento.getDepartmentName()}</option>
			</c:forEach>
		</select> <br /> <select name="località">
			<option value="">Scegli la località</option>
			<c:forEach var="location" items="${locations}">
				<option value="${location.getCountryId()}">${location.getCity()}</option>
			</c:forEach>
		</select> <br />
</form>
</body>
</html>