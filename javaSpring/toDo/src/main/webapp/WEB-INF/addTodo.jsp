<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix=”c” uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add todo</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id="content">
		<div id="page_header"> Add TODO
			<div id="page_header_message">
				<c:out value="${message}"/>
				<%--this is called templating allows us to insert data --%>
			
			</div>
		
		</div>
		
		<div id="active_area">
		<%--to submit information to the backend we need a form this is how we would call on the form method --%>
			<form method="POST" action="/todo/add">
				<label path="text"> Text
					<input type="text" name="text"/>
				</label>
				<button>Add</button>
			
			</form>
		
		
		</div>
		<div id="buttons">
			<a href="/">cancel</a>
		</div>
	</div>

</body>
</html>