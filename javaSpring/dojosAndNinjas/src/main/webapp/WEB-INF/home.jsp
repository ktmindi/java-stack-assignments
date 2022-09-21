<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="header">
		<h1> ALL DOJO LOCATIONS </h1>
		<a href="/dojos/new">Create A New Dojo</a>
		<a href="/ninjas/new">Register A New Ninja</a>
	</div>
	<table class="table table-striped table-bordered">
		<thead>		
			<tr>
				<th>Id</th>
				<th>Location</th>
				<th>Action</th>
			</tr>
		</thead><tbody>
				<c:forEach var="oneDojo" items="${listDojos}">
					<tr>
						<td><c:out value="${oneDojo.id}"/></td>
						<td><c:out value="${oneDojo.name}"/></td>
						<td><a href="/dojos/<c:out value="${oneDojo.id}"/>">See Students</a></td>
					</tr>
				</c:forEach>
				</tbody>	
	</table>

</body>
</html>