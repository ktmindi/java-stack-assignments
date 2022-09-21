<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 


<jsp:include page="includes/head.jsp"/>


<body>
	<div class="container px-4">
	
		<div class="row">
			<h1 class="display-3 text-uppercase">BOOK CLUB</h1>
			<h4 class="lead text-uppercase">A place for friends to share thoughts on books</h4>
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
	  			<button type="submit" class="btn btn-warning btn-lg">Register</button>
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
	  			<button type="submit" class="btn btn-warning btn-lg">Login</button>
				</form:form>
  			</div>				
  		</div>			
  	</div>
</body>