<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/includes/head.jsp" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content" class="container-fluid">
		<jsp:include page="/WEB-INF/includes/pageHeader.jsp" />
		
		<div id="active_area" class="row justify-content-center">
			<div class="col-7">
			
				<form:form method="POST" action="/school/add" modelAttribute="school">
				
					<form:label path="name">
						Name:
						<form:errors path="name"/>
						<form:input type="text" path="name" cssClass="form-control"/>
					</form:label>
					
					
					<button class="btn btn-success">Add</button>
				</form:form>
			</div>
		
			<div id="buttons" class="col-7">
				<a class="btn btn-danger mt-2" href="/school">Cancel</a> 
			</div>
		</div>
	</div>
</body>
</html>