<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">User Registration</h1>
			<h2 style="color: green">${successMsg}</h2>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName" placeholder="Enter first name" /></td>
					<td style="color: red"><sf:errors path="firstName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName" placeholder="Enter last name" /></td>
					<td style="color: red"><sf:errors path="lastName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="Enter login ID" /></td>
					<td style="color: red"><sf:errors path="login"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:password path="password" placeholder="Enter password" /></td>
					<td style="color: red"><sf:errors path="password"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Address :</th>
					<td><sf:input path="address" placeholder="Enter address" /></td>
					<td style="color: red"><sf:errors path="address"></sf:errors></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%@ include file="Footer.jsp"%>
</body>
</html>