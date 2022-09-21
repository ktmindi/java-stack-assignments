<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
			<div id="active_area" class="col-7">
				<div>name: <c:out value="${school.name}"/></div>
			</div>
			
			<div class="col-7">
				<h2>Teachers</h2>
				<hr>
			</div>
			
			<div class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
					</thead>
					<c:forEach var="teacher" items="${school.teachers}">
						<tr>
							<td><c:out value="${teacher.name}"/></td>
							<td><c:out value="${teacher.grade}"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-7">
				<a href="/school" class="btn btn-success">Back to List</a>
				<a href="/school/update/${school.id}" class="btn btn-warning">Update School</a>
				<a href="/school/delete/${school.id}" class="btn btn-danger">Delete School</a>
			</div>
		</div>
	</div>
</body>
</html>