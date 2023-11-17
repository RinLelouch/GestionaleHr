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
	<form action="/gestionalehr/searchusers" method="post">
	<c:if test="${autorizzato == true}">

		<c:if test="${ALTO == true}">
		<h2>Ricerca un Utente o più Utenti</h2>
		<p>
			Ricerca per id: <input type="text" name="id">
		</p>
		<br />
		<p>
			Ricerca per nome: <input type="text" name="nome">
		</p>
		<br />
		<p>
			Ricerca per cognome: <input type="text" name="cognome">
		</p>
		<p>
			Ricerca per email: <input type="text" name="email">
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
		</select> <br /> <select name="jobTitle">
			<option value="">Scegli il Job Title</option>
			<c:forEach var="job" items="${jobs}">
				<option value="${job.getJobId()}">${job.getJobTitle()}</option>
			</c:forEach>
		</select> <br />
		<p>
			Ricerca per data assunzione: <input type="date" name="data">
		</p>
		
		</c:if>
<c:if test="${MEDIO == true}">
<h2>Ricerca un Utente o più Utenti</h2>
		<p>
			Ricerca per id: <input type="text" name="id">
		</p>
		<br />
		<p>
			Ricerca per nome: <input type="text" name="nome">
		</p>
		<br />
		<p>
			Ricerca per cognome: <input type="text" name="cognome">
		</p>
		<p>
			Ricerca per email: <input type="text" name="email">
		</p>

		 <br /> <select name="jobTitle">
			<option value="">Scegli il Job Title</option>
			<c:forEach var="job" items="${jobs}">
				<option value="${job.getJobId()}">${job.getJobTitle()}</option>
			</c:forEach>
		</select> <br />
		<p>
			Ricerca per data assunzione: <input type="date" name="data">
		</p>
</c:if>
</c:if>
<input type="submit" value="Ricerca">
</form>
<c:if test="${ALTO == true}">
<form action="/gestionalehr/search">
<label>
<input type="radio" name="search" value="all">
Cerca Tutti i Dipendenti
</label>
<label>
<input type="radio" name="search" value="managers">
Cerca Managers
</label>
<label>
<input type="radio" name="search" value="dipendenti">
Cerca solo i Dipendenti
</label>
<input type="submit" value="Ricerca">
</form>
</c:if>
</body>
</html>