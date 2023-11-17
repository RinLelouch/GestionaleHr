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
<p>Ecco i dati del dipendente ${dipendente.getName()} ${manager.getName()} :
	<p>Nome: ${dipendente.getName()} ${manager.getName()}</p>
	<p>Cognome: ${dipendente.getLastName()} ${manager.getLastName()}</p>
	<p>Email: ${dipendente.getEmail()} ${manager.getEmail()}</p>
	<p>PhoneNumber: ${dipendente.getPhoneNumber()} ${manager.getPhoneNumber()}<p>
	<p>Salario: ${dipendente.getSalary()} ${manager.getSalary()}</p>
	<p>Nome Dipartimento: ${dipendente.getNomeDipartimento()} ${manager.getNomeDipartimento()}</p>
	<p>Nome Manager: ${dipendente.getNomeManager()} ${manager.getNomeManager()}</p>
	<p>Job Title: ${dipendente.getJobTitle()} ${manager.getJobTitle()}</p>
</body>
</html>