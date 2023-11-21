<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/gestionalehr/dipendenteinserito">
<h4>Di seguito il riepilogo dei dati</h4>
<p>Nome : ${name}</p>
<p>Cognome : ${cognome}</p>
<p>Numero Telefono : ${phone}</p>
<p>Nome del Dipartimento : ${depName}</p>
<p>Manager : ${managerId}</p>
<p>Impiego : ${job}</p>
<input type="submit" value ="conferma">
</form>
<form action="/gestionalehr/Logout">
<input type="submit" value="annulla e torna alla schermata di login">
</form>
</body>
</html>