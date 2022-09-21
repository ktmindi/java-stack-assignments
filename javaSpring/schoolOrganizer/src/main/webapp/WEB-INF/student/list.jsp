<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		
		<div class="row justify-content-center mt-3">
			<div id="active_area" class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
					</thead>
					<c:forEach var="teacher" items="${teachers}">
						<tr>
							<td>
								<a href="/teacher/${teacher.id}">
									<c:out value="${teacher.name}"/>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-7">
				<a href="/teacher/add" class="btn btn-success">Add teacher</a>
			</div>
		</div>
	</div>
</body>
</html>