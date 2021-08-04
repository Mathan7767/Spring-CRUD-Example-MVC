<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Operations</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="POST" action="/Spring-MVC-CRUD-Example/updateStudent">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="studID" readonly="true"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="studName" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="studAge"/></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><form:input path="studEmail" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Update Details" /></td>
			</tr>
		</table>
	</form:form>
	<br><br>
	<a href="viewStudent">View Students</a>
</body>
</html>