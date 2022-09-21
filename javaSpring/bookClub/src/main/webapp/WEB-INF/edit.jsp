<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 

<jsp:include page="includes/head.jsp"/>

<body>
	<div class="container">
		<h1 class="display-3 text-uppercase">EDIT YOUR ENTRY</h1>

		<jsp:include page="includes/navi.jsp"/>
	
	<br><br>
	<div class="formsizing">
	<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book" class="form">
		<input type="hidden" name="_method" value="put">
			<div class="form-group lead">
				<form:label path="title"> TITLE </form:label>
				<form:errors class="text-danger" path="title"/>
				<form:input class="form-control" path="title"/>
			</div>
			<div class="form-group lead">
				<form:label path="author"> AUTHOR NAME </form:label>
				<form:errors class="text-danger" path="author"/>
				<form:input class="form-control" path="author"/>
			</div>
			<div class="form-group lead">
				<form:label path="thoughts"> THOUGHTS </form:label>
				<form:errors class="text-danger" path="thoughts"/>
				<form:textarea class="form-control" path="thoughts"/>
			</div>
		<!-- there is a hidden input for userid -->
		<form:input type="hidden" value ="${loggedInUser.id}" path="user"/>
		<input type="submit" class="btn outline-dark btn-lg" value="UPDATE"/>
	</form:form>
	
	<c:if test="${book.user.id==loggedInUser.id}">
	<form:form action="/books/${book.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" class='btn outline-dark btn-lg' value="DELETE POST">
	</form:form>
	</c:if>
	</div>
	</div>
</body>
</html>