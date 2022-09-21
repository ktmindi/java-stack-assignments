<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="includes/head.jsp" />
<title>Insert title here</title>
</head>
<body>
	<div id="content" class="container-fluid">
		<jsp:include page="includes/pageHeader.jsp" />
		
		<div id="active_area" class="row justify-content-center">
			<div class="col-7">
				<h1>Welcome to the District Schools Manager</h1>
				
				<p>
					Use this tool to manage each school's students and teachers.
				</p>
			</div>
			<div class="col-7">
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<a href="/user/login">Login to continue</a>
					</c:when>
					<c:otherwise>
						<a href="/school">Manage schools</a><br/>
						<a href="/teacher">Manage teachers</a><br/>
						<a href="/student">Manage students</a><br/>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>