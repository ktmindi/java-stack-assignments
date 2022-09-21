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
<title>Add A New Ninja</title>
</head>
<body>
	<div class = "container">
		<h1>NEW NINJA</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="oneNinja">
					
					<p>
						<form:label path="firstName"> First Name: </form:label>
						<form:errors path="firstName"/>
						<form:input path="firstName"/>
					</p>
					<p>
						<form:label path="lastName"> Last Name: </form:label>
						<form:errors path="lastName"/>
						<form:input type="lastName" path="lastName"/>
					</p>
					<p>
						<form:label path="age"> Age: </form:label>
						<form:errors path="age"/>
						<form:input type="int" path="age"/>
					</p>
					<p>
						<form:label path="dojo"> Select Dojo Location: </form:label>
						<form:select path="dojo">
							<c:forEach var="oneDojo" items="${manyDojo}">
								<option value="${oneDojo.id}"><c:out value="${oneDojo.name}"/></option>}
							</c:forEach>
						</form:select>
					</p>
					<input type="submit" value="CREATE"/>
		</form:form>
		
	
	</div>
</body>
</html>