<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br>
		Last name: <form:input path="lastName"/>
		<br>
		Gender: <br>
		Male<form:radiobutton path="gender" value="Male"/>
		Female<form:radiobutton path="gender" value="Female"/>
		Others<form:radiobutton path="gender" value="Others"/>
		<br>
		Country:
		<form:select path="country">
			<form:options items="${countryOptions}"/>
		</form:select>
		<br>
		Programming Language:
		<form:select path="language">
			<form:options items="${student.languageOptions}"/>
		</form:select>
		<br>
		Operating Systems:
		Windows<form:checkbox path="os" value="Windows"/>
		Mac OS<form:checkbox path="os" value="Mac OS"/>
		Linus<form:checkbox path="os" value="Linus"/>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>