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
<div class="row">
	<div id="page_header" class="col-12">
		<div class="row">
			<div class="col-12 text-center">
				<a href="/" id="page_header__page_title">School Manager</a>
			</div>
		</div>
		
		
		<div id="page_header__menu" class="row">
			<div class="col-12 text-center">
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<a href="/user/login">Login</a>
						<a href="/user/register">Register</a>
					</c:when>
					<c:otherwise>
						<a href="/user/logout">Logout</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<div id="page_header__message" class="row">
			<div class="col-12 text-center">
				<div id="page_header__message">
					<c:out value="${message}"/>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>