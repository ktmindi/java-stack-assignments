
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<title>Edit Your Expense</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h2>EDIT AN EXPENSE</h2><a href="/expenses"> GO BACK</a>
		</div>
		<div class="form">	
			<form:form action="/expenses/edit/${oneExp.id}" method="post" modelAttribute="oneExp" class="form">
				<input type="hidden" name="_method" value="put">
				<p>
					<form:label path="item"> Name of Expense: </form:label>
					<form:errors path="item"/>
					<form:input path="item"/>
				</p><br>
				<p>
					<form:label path="seller"> Name of Vendor: </form:label>
					<form:errors path="seller"/>
					<form:input path="seller"/>
				</p><Br>
				<p>
					<form:label path="cost"> Total Cost: </form:label>
					<form:errors path="cost"/>
					<form:input type="float" path="cost"/>
				</p><Br>
				<p>
					<form:label path="descript"> Description of Expense: </form:label>
					<form:errors path="descript"/>
					<form:input path="descript"/>
				</p>
				<input type="submit" value="UPDATE" class="btn-primary"/>
			</form:form>
		</div>
	</div>

</body>
</html>
