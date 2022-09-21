<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includes/head.jsp" />
</head>
<body>
	<div class="container-fluid">
	
		<jsp:include page="/WEB-INF/includes/pageHeader.jsp" />
			
		<div class="row justify-content-center">
			<div id="active_area" class="col-7">
				<div>name: <c:out value="${teacher.name}"/></div>
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
							<td><c:out value="${teacherStudent.student.grade}"/></td>
							<td>
								<a href="/teacher/remove-student/${teacher.id}/${teacherStudent.student.id}">remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-7">
				<a href="/teacher" class="btn btn-success">Back to List</a>
				<a href="/teacher/update/${teacher.id}" class="btn btn-warning">Update teacher</a>
				<a href="/teacher/delete/${teacher.id}" class="btn btn-danger">Delete teacher</a>
			</div>
		</div>
	</div>
</body>
</html>