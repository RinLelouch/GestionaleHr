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
<form action="/gestionalehr/sceltalavoro">
<p>${errorMessage}</p>
<h4>INSERISCI QUI I DATI DEL NUOVO DIPENDENTE</h4>
<p>Inserisci il Nome<input type="text" name="name"></p>
<p>Inserisci il Cognome<input type="text" name="cognome"></p>
<p>Inserisci il Numero di Telefono<input type="text" name="phone"></p>
<c:if test="${ALTO==true }">
<select name="dipartimentoScelto">
<option value="">Scegli il dipartimento a cui farà capo</option>
<c:forEach var="dep" items="${listaDep}">
<option value="${dep.getDepartmentId()}">${dep.getDepartmentName()}</option>
</c:forEach>
</select>
</c:if>
<input type="submit" name="Avanti">
</form>
</body>
</html>