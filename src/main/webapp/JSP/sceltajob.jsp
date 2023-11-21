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
<p>${errorMessage}</p>
<form action="/gestionalehr/riepilogoinserimento">
<h4>Scegli un Lavoro</h4>
<select name="job">
<option value="">Scegli un lavoro dal dipartimento selezionato</option>
<c:forEach var="job" items="${jobs}">
<option value="${job.getJobId()}">${job.getJobTitle()}</option>
</c:forEach>
</select>
<input type="submit" name="Avanti">
</form>
</body>
</html>