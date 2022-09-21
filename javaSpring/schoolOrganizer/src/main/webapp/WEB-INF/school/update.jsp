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
	<div class="container-fluid">
	
		<jsp:include page="/WEB-INF/includes/pageHeader.jsp" />
		
		<div class="row justify-content-center">
			<div class="col-7">
				
				<form:form method="POST" action="/school/update" modelAttribute="school">
					<div class="row justify-content-center">
						<form:input type="hidden" path="id"/>
						
						<div class="col-12 col-md-6">
							<form:label path="name">
									Name:
									<form:errors path="name"/>
									<form:input type="text" path="name" class="form-control"/>
							</form:label>
						</div>
					
						<button class="btn btn-success mt-2 col-7 col-md-7">Update</button>
					</div>
				</form:form>
			</div>
			
			<div class="col-7">
				<h2>Teachers</h2>
				<hr>
			</div>
			
			<div class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
						<th></th>
					</thead>
					<c:forEach var="teacher" items="${school.teachers}">
						<tr>
							<td><c:out value="${teacher.name}"/></td>
							<td>
								<a href="/school/remove-teacher/${school.id}/${teacher.id}">remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-7">
				<hr>
				<h3>Add Teacher</h3>
				<form:form action="/school/add-teacher/${school.id}" method="POST">
					<select name="teacher_id" class="form-control">
						<c:forEach var="teacher" items="${teachers}">
							<option value="${teacher.id}">
								<c:out value="${teacher.name}"/>
							</option>
						</c:forEach>
					</select>
					<button class="btn btn-info">Add Teacher</button>
				</form:form>
			</div>
			
			</div class="col-7">
				<div id="buttons">
					<a href="/school" class="btn btn-danger">Cancel</a> 
				</div>
			</div>
	</div>
</body>
</html>