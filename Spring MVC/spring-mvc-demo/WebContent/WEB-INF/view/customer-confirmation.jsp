<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<style>
	.error {color:red}
</style>
</head>
<body>
	The customer is confirmed: ${customer.firstName} ${customer.lastName}
	<br>
	Free Passes: ${customer.freePasses}
	<br>
	Postal Code: ${customer.postalCode}
	<br>
	Course Code: ${customer.courseCode}
</body>
</html>