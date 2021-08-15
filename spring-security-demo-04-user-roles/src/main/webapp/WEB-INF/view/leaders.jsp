<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security</title>
</head>
<body>
	<h2>Leaders Page</h2>
	<hr/>
	<p>Welcome to Leader page</p><br/>
	
	<hr/>
	
		<p>
			<a href="${pageContext.request.contextPath}/">Back To Home</a>
		</p>
	
	<hr/>
	
</body>
</html>