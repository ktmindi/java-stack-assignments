<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
					<c:forEach var="school" items="${schools}">
						<tr>
							<td>
								<a href="/school/${school.id}">
									<c:out value="${school.name}"/>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-7">
				<a href="/school/add" class="btn btn-success">Add School</a>
			</div>
		</div>
	</div>
</body>
</html>