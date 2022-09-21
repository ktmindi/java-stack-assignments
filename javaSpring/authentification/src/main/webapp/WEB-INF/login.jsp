<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
	<div class="container px-4">
	
		<div class="row">
			<h1>WELCOME!</h1>
			<p>Join our growing community</p>
		</div>
	
		<div class="row gx-5">
			<div class="col">
				<form:form action="/register" method="POST" modelAttribute="newUserView">
				<div class="mb-3 p-3">
    					<form:label path="userName">User Name:</form:label>
    					<form:errors class="text-danger" path="userName"/>
    					<form:input class="form-control" path="userName"/>  							
    			</div>
				<div class="mb-3 p-3">
    					<form:label path="email">Email:</form:label>
    					<form:errors class="text-danger" path="email"/>
    					<form:input class="form-control" path="email"/>  	
 				</div>
 				<div class="mb-3 p-3">
    					<form:label path="password">Password:</form:label>
    					<form:errors class="text-danger" path="password"/>
    					<form:password class="form-control" path="password"/>  	
 				</div>
 				<div class="mb-3 p-3">
    					<form:label path="confirm">Confirm Password:</form:label>
    					<form:errors class="text-danger" path="confirm"/>
    					<form:password class="form-control" path="confirm"/>  	
 				</div>
	  			<button type="submit" class="btn btn-light btn-lg">Register</button>
				</form:form>
  			</div>	
  				
  				<!-- LOGIN FORM -->
  			<div class="col">
				<form:form action="/login" modelAttribute="newLoginView">
				<div class="mb-3 p-3">
    					<form:label path="email">Email:</form:label>
    					<form:errors class="text-danger" path="email"/>
    					<form:input class="form-control" path="email"/>  							
    			</div>
				<div class="mb-3 p-3">
    					<form:label path="password">Password:</form:label>
    					<form:errors class="text-danger" path="password"/>
    					<form:password class="form-control" path="password"/>  	
 				</div>
	  			<button type="submit" class="btn btn-light btn-lg">Login</button>
				</form:form>
  			</div>				
  				
  				
			
			
		
	
 

		
		</div>
	</div>
</body>
</html>