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
	<form action="/gestionalehr/login" method="post">
	<p> ${failToLogin}</p>
		<p>UserName: <input type="text" name="email"></p><br/>
		<p>Password : <input type = "password" name="password"></p><br/>
	<input type="submit" value="Login">
		</form>
 </body>
</html>