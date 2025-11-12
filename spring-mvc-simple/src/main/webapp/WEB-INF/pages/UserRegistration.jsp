<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">User Registration</h1>
			<h2 style="color: green">${successMsg}</h2>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName" placeholder="Enter first name" /></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName" placeholder="Enter last name" /></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="Enter login ID" /></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:password path="password" placeholder="Enter password" /></td>
				</tr>
				<tr>
					<th align="left">Address :</th>
					<td><sf:input path="address" placeholder="Enter address" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>