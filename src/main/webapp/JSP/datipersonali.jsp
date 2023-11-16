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
<p>Ciao ${emp.getFirstName()}, di seguito puoi vedere i tuoi dati personali</p>

<table>
			<tr>
				<th>ID Dipendente</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Email</th>
			
			</tr>
			<tr>
					<td>${emp.getEmployeeId()}</td>
					<td>${emp.getFirstName()}</td>
					<td>${emp.getLastName()}</td>
					<td>${emp.getEmail()}</td>

				</tr>
			
		</table>
</body>
</html>