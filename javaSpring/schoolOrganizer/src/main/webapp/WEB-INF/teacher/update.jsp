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
				
				<form:form method="POST" action="/teacher/update" modelAttribute="teacher">
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
						<a href="/teacher" class="btn btn-danger mt-2 col-7 col-md-7">Cancel</a> 
					</div>
				</form:form>
			</div>
			
			<div class="col-7">
				<h2>Students</h2>
				<hr>
			</div>
			
			<div class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
						<th>Grade</th>
						<th></th>
					</thead>
					<c:forEach var="teacherStudent" items="${teacher.teacherStudent}">
						<tr>
							<td><c:out value="${teacherStudent.student.name}"/></td>
							<td>
								<a href="/teacher/remove-student/${teacher.id}/${teacherStudent.student.id}">remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-7">
				<hr>
				<h3>Add Student</h3>
				<form:form action="/teacher/add-student/${teacher.id}" method="POST">
					<select name="student_id" class="form-control">
						<c:forEach var="student" items="${students}">
							<option value="${student.id}">
								<c:out value="${student.name}"/>
							</option>
						</c:forEach>
					</select>
					<button class="btn btn-info">Add Student</button>
				</form:form>
			</div>
	</div>
</body>
</html>