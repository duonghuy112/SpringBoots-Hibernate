<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<form:form action="searchCustomer" method="POST">
		Search customer: <input type="text" name="searchName" />
                
		<input type="submit" value="Search" class="add-button" />
     </form:form>
	
	<div id="container">
		<div id="content">
			
			<input type="button" value="Add Customer" 
					onclick="window.location.href='showFormForAdd'; return fasle"
					class="add-button">
			
			<table>
				<tr>
					<th><a href="${pageContext.request.contextPath}/customer/list?sortBy=firstName">First Name: </a></th>				
					<th><a href="${pageContext.request.contextPath}/customer/list?sortBy=lastName">Last Name: </a></th>				
					<th><a href="${pageContext.request.contextPath}/customer/list?sortBy=email">Email: </a></th>				
					<th>Action</th>				
				</tr>
				<c:forEach items="${customers}" var="C">
					<tr>
						<td>${C.firstName}</td>
						<td>${C.lastName}</td>
						<td>${C.email}</td>
						<td>
							<a href="${pageContext.request.contextPath}/customer/updateCustomer?customerId=${C.id}">Update</a>
							|
							<a href="${pageContext.request.contextPath}/customer/deleteCustomer?customerId=${C.id}"
								onclick="if (!(confirm('Are you sure you want to delete the customer?'))) return false">Detele</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>