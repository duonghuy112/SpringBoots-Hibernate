<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security</title>
</head>
<body>
	<h2>Home Page</h2>
	<hr/>
	<p>Welcome to my page</p><br/>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>
	
</body>
</html>