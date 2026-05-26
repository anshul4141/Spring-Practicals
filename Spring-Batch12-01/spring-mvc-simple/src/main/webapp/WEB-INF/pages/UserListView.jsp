<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>User List</h1>
		<h3>${msg}</h3>

		<sf:form method="post" modelAttribute="form">
			<table width="100%" border="1px">
				<tr>
					<th>Select</th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
					<th>Address</th>
				</tr>

				<c:forEach items="${list}" var="user">
					<tr align="center">
						<td align="center"><sf:checkbox path="ids" value="${user.id}" /></td>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.firstName}"></c:out></td>
						<td><c:out value="${user.lastName}"></c:out></td>
						<td><c:out value="${user.login}"></c:out></td>
						<td><c:out value="${user.password}"></c:out></td>
						<td><c:out value="${user.dob}"></c:out></td>
						<td><c:out value="${user.address}"></c:out></td>
					</tr>
				</c:forEach>
			</table>

			<br>
			<table style="width: 100%">
				<tr>
					<td><input type="submit" name="operation" value="previous" /></td>
					<td style="text-align: center;"><input type="submit"
						name="operation" value="delete"></td>
					<td style="text-align: right;"><input type="submit"
						name="operation" value="next"></td>
				</tr>
			</table>
			<sf:hidden path="pageNo" />
		</sf:form>

	</div>
</body>
</html>