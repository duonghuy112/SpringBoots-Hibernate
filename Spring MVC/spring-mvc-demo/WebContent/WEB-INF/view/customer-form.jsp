<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form action="processForm" modelAttribute="customer">
		First name: <form:input path="firstName"/>
		<br>
		Last name (*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"></form:errors>
		<br>
		Free Passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"></form:errors>
		<br>
		Postal Code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"></form:errors>
		<br>
		Course Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"></form:errors>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>