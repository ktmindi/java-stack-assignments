<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="includes/head.jsp"/>

<body>
	<div class="container">
		<h1 class="display-3 text-uppercase">WELCOME, <c:out value="${loggedInUser.userName}"/></h1>
		
		<jsp:include page="includes/navi.jsp"/>
		
		
		<h3 class="lead text-uppercase">Books from everyone's shelves:</h3>
		
		<div class="table-wrapper-scroll-y my-custom-scrollbar">
			<table class="table table-hover mb-0">
    				<thead>
        				<tr>
			            <th scope="col">ID</th>
			            <th scope="col">TITLE</th>
			            <th scope="col">AUTHOR NAME</th>
			            <th scope="col">POSTED BY</th>
			            <th scope="col">TOTAL LIKES</th>
			            <th scope="col">LIKE/UNLIKE</th>
			        </tr>
			    </thead>
    				<tbody><!-- var is what you declare items is from our controller the model add attribute -->
					<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}"></c:out></td>
						<td><a href="/books/${book.id}" class="dbtitle"><c:out value="${book.title}"></c:out></a></td>
						<td><c:out value="${book.author}"></c:out></td>
						<td><c:out value="${book.user.userName}"></c:out>
						</td>
						<td>
						${book.likers.size()}
						</td>
						<td>
						<c:choose>
							<c:when test="${book.likers.contains(thisUserView)}">
								<a href="/books/${book.id}/unlike" class="link-danger">UNLIKE</a></c:when>
							<c:otherwise>
								<a href="/books/${book.id}/like"class="link-success">LIKE</a></c:otherwise>
						</c:choose>
						</td>
					</tr>	
					</c:forEach>
    				</tbody>
			</table>
		</div>
	
	</div>
</body>
</html>