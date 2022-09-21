<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 


<jsp:include page="includes/head.jsp"/>


<body>
	<div class="container"> <!-- book must match addAttribute "word in quotes" -->
		<h1 class="display-3 text-uppercase">${book.title}</h1>
		
		<jsp:include page="includes/navi.jsp"/>
		
		<h3 class="lead text-uppercase"><c:out value="${book.user.userName}"/> read ${book.title} by ${book.author}.
		</h3>

		<div class="card">
  			<div class="card-body">
    				<h5 class="card-title display-6 text-uppercase"><c:out value="${book.user.userName}"/>'s thoughts:</h5>
    				<p class="card-text">${book.thoughts}</p>
    
    <c:if test="${book.user.id==loggedInUser.id}">
			<div class="btn-group" role="group">
				<a href="/books/${book.id}/edit" class="btn outline-dark card-link" role="button"> EDIT POST</a> 
			<form:form action="/books/${book.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" class='btn outline-dark card-link' value="DELETE POST">
	</form:form></div>
		</c:if>
  </div>
</div>

</body>
</html>