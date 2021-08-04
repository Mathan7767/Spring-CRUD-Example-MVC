<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Operations</title>
</head>
<body>
	<h1>Students List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.studID}</td>
				<td>${student.studName}</td>
				<td>${student.studAge}</td>
				<td>${student.studEmail}</td>
				<td><a href="edit/${student.studID}">Edit</a></td>
				<td><a href="delete/${student.studID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="addStudent">Add a Student</a>
</body>
</html>