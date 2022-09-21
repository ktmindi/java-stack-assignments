<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Student Projects <c:out value="${loggedInUser.userName}"/> </h1>
		<p> HOME , NEW, <a href="/logout">LOGOUT</a> </p>
	
	</div>
</body>
</html>