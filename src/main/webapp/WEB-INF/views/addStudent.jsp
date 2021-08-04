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
	<h1>Save Employee</h1>
	<form:form method="POST" action="saveStudent" >
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="studID" value=""/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="studName" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="studAge" value=""/></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><form:input path="studEmail" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save Details" /></td>
			</tr>
		</table>
	</form:form>
	<br><br>
	<a href="viewStudent">View Students</a>
</body>
</html>