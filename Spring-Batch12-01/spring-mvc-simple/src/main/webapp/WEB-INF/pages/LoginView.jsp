<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">Login</h1>
			<h3>${msg}</h3>
			<table>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="enter your login" /></td>
					<td style="color: red"><sf:errors path="login" /></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password"
							placeholder="enter your password" /></td>
					<td style="color: red"><sf:errors path="password" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signIp"></td>
				</tr>
			</table>
		</div>
	</sf:form>

</body>
</html>