<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 

<jsp:include page="includes/head.jsp"/>

<body>
	<div class="container">
		<h1 class="display-3 text-uppercase">WELCOME, <c:out value="${loggedInUser.userName}"/></h1>
		
		<jsp:include page="includes/navi.jsp"/>
		
		
		<h3 class="lead text-uppercase">All TV Shows in DataBase:</h3>
		
		<div class="table-wrapper-scroll-y my-custom-scrollbar">
			<table class="table table-hover mb-0">
    			<thead>
        			<tr>
				        <th scope="col">SHOW NAME</th>
				        <th scope="col">NETWORK</th>
				        <!-- <th scope="col">AVERAGE RATING</th> 
			        </tr> -->
			    	</thead>
    				<tbody><!-- var is what you declare items is from our controller the model add attribute -->
					<c:forEach var="tvs" items="${tv}">
					<tr>
						<td><a href="/shows/${tvs.id}" class="dbtitle">${tvs.title}</a></td>
						<td>${tvs.network}</td>
					


					</tr>	
					</c:forEach>
    				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>
