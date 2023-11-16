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
<p>Ecco i dati del dipendente ${dipendente.getName()}:
	<p>Username: ${dipendente.getName()}</p>
	<p>Nome: ${dipendente.getLastName()}</p>
	<p>Cognome: ${dipendente.getEmail()}</p>
	<p>PhoneNumber: ${dipendente.getPhoneNumber()}</p>
	<p>Salario: ${dipendente.getSalary()}</p>
	<p>Nome Dipartimento: ${dipendente.getNomeDipartimento()}</p>
	<p>Nome Manager: ${dipendente.getNomeManager()}</p>
	<p>Job Title: ${dipendente.getJobTitle()}</p>
</body>
</html>