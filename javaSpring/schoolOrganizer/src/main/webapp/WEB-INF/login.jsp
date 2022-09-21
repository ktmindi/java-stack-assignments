<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includes/head.jsp" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content" class="container-fluid">
		<jsp:include page="includes/pageHeader.jsp" />
			
		<div id="active_area" class="row justify-content-center">
			<div class="col-5">
				<form:form method="POST" action="/user/login" modelAttribute="user">
			        <p>
			            <form:label path="email">Email:</form:label>
			            <form:input type="email" path="email"/>
						<form:errors path="email"/>
			        </p>
			        <p>
			            <form:label path="password">Password:</form:label>
			            <form:password path="password"/>
			        </p>
			        <button>Login</button>
			    </form:form>
			</div>
	    </div>
	</div>
</body>
</html>