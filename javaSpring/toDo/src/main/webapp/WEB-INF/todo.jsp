<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix=”c” uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Our to do list</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id="content">
		<div id="page_header">
			<div>MY TO DO LIST</div>
		</div>
		<div id="page_header_message">
			<c:out value="${message}"/>
		</div>
	</div>
	
	<div id="active_area">
		<table>
			<c:forEach var="item" items="${items}">
				<tr>
					<td><c:out value="${item.text}" /></td>
					<td>
						<a href="/todo/<c:out value="${item.id}"/>"> view</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	<div id="buttons">
		<a href="/todo/add"> add todo</a>
	</div>
</body>
</html>