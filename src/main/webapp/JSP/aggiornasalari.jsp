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
<p>${errorMessage}</p>
<form action="/gestionalehr/modificasalario" method="post">
<p> Aggiorna i salari di un lavoro qui :</p>
<select name="jobId">
<option value="">Scegli un lavoro</option>
<c:forEach var="job" items="${jobs}">
<option value="${job.getJobId()}">${job.getJobId()}</option>
</c:forEach>
</select><br/>
<p>Nuovo Minimo <input type="text" name="nuovoMinimo"></p> <br/>
<p>Nuovo Massimo<input type="text" name="nuovoMassimo"></p><br/>
<input type="submit" name="aggiorna">
</form>
<c:if test="${ALTO==true}">
<form action="/gestionalehr/aggiornamentoconpercentuali">
<p> Aggiorna i salari di un lavoro qui :</p>
<select name="jobId">
<option value="">Scegli un lavoro</option>
<c:forEach var="job" items="${jobs}">
<option value="${job.getJobId()}">${job.getJobId()}</option>
</c:forEach>
</select><br/>
<p>Aumenta il massimo del</p>
<select name="aumentoMassimoPercentuale">
<option value="">Scegli una percentuale</option>
<c:forEach var="perc" items="${percentuali}">
<option value="${perc.getValore()}"> ${perc.getPercentuale()}</option>
</c:forEach>
</select><br/>
<p>Aumenta il minimo del</p>
<select name="aumentoMinimoPercentuale">
<option value="">Scegli una percentuale</option>
<c:forEach var="perc" items="${percentuali}">
<option value="${perc.getValore()}"> ${perc.getPercentuale()}</option>
</c:forEach></select><br/>

<input type="submit" name="Aggiorna con le percentuali">
</form>
</c:if>
</body>
</html>