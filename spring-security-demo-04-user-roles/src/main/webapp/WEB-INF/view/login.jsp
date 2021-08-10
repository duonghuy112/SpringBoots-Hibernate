<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security</title>
</head>
<body>
	<h2>My Custom Login Page</h2>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
	
		<c:if test="${param.error != null}">
			<i>Your Username or Password is incorrect!</i><br/><br/>
		</c:if>
		
		User name: <input type="text" name="username"><br/><br/>
		Password: <input type="password" name="password"><br/><br/>
		<input type="submit" value="Login"><br/><br/>
	</form:form>
</body>
</html>