<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>

	<h1><c:out value="${findDojo.name}"/> Location Ninjas</h1>
	
	<table class="table table-striped table-bordered">
		<thead>		
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<tr>	
				<c:forEach var="ninja" items="${findDojo.ninjas}">
					<td><c:out value="${ninja.firstName}"/></td>
					<td><c:out value="${ninja.lastName}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>