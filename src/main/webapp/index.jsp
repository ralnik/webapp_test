<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>
 
	<center>
		<img src="<c:url value="/resource/image/logo.png"/>">
		<h2>copyright by ralnik@mail.ru</h2>
		<h3>
			<a href="colors">test task 1</a>
		</h3>
		
		<h3>
			<a href="getInfo?input='test value'">test task 2</a>
		</h3>
	</center>
</body>
</html>