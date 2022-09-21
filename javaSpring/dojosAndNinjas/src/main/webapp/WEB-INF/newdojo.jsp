<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">
<title>Add A New Dojo</title>
</head>
<body>
	<div class ="container">
		<h1> NEW DOJO</h1>
		<form:form action="/dojos/new" method="post" modelAttribute="oneDojo">
					<p>
						<form:label path="name"> Name of Dojo: </form:label>
						<form:errors path="name"/>
						<form:input path="name"/>
					</p>
					<input type="submit" value="CREATE"/>
			</form:form>
	</div>
</body>
</html>