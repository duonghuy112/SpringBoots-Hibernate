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
	<h2>Home Page</h2>
	<hr/>
	<p>Welcome to my page</p><br/>
	
	<hr/>
	
	<p>
		User: <sec:authentication property="principal.username"/><br/><br/>
		Role: <sec:authentication property="principal.authorities"/><br/><br/>
	</p>
	
	<hr/>
	
		<sec:authorize access="hasRole('MANAGER')">
			<p>
				<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			</p>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ADMIN')">
			<p>
				<a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
			</p>
		</sec:authorize>
	
	<hr/>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>
	
</body>
</html>