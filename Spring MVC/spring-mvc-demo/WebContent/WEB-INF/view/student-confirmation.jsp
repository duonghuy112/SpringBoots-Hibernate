<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<h4>The student is confirmed: ${student.firstName} ${student.lastName}</h4>
	<h4>Gender: ${student.gender}</h4>
	<h4>Country: ${student.country}</h4>
	<h4>Programming Language: ${student.language}</h4>
	<h4>Operating Systems:</h4>
	<ul>
		<c:forEach items="${student.os}" var="os">
			<li>${os}</li>
		</c:forEach>
	</ul>
</body>
</html>