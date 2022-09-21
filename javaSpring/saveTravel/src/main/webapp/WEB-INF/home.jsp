<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">
<title>Save Travels App Home Page</title>
</head>
<body>
	<div class="container">
		<div class="toppart">
			<h1>SAVE TRAVELS</h1>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th> EXPENSE </th>
							<th> VENDOR </th>
							<th> AMOUNT </th>
							<th> ACTIONS </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="oneExp" items="${manyExp}">
							<tr>
								<td><a href="/expenses/${oneExp.id}"><c:out value="${oneExp.item}"/></a></td>
								<td><c:out value="${oneExp.seller}"/></td>
								<td>$ <c:out value="${oneExp.cost}"/></td>
								<td><a href="/expenses/edit/<c:out value="${oneExp.id}"/>">EDIT</a>
									<form action="/expenses/${oneExp.id}" method="post">
								    		<input type="hidden" name="_method" value="delete">
								    		<input type="submit" value="DELETE" class="btn-danger">
									</form>
								</td>
							</tr>
						</c:forEach>
				</tbody>
				</table>
		</div>
		
		<h2>ADD AN EXPENSE</h2>
		<div class="formsss">
			
			<form:form action="/expenses" method="post" modelAttribute="oneExp">
					<p>
						<form:label path="item"> Name of Expense: </form:label>
						<form:errors path="item"/>
						<form:input path="item"/>
					</p>
					<p>
						<form:label path="seller"> Name of Vendor: </form:label>
						<form:errors path="seller"/>
						<form:input path="seller"/>
					</p>
					<p>
						<form:label path="cost"> Total Cost: </form:label>
						<form:errors path="cost"/>
						<form:input type="float" path="cost"/>
					</p>
					<p>
						<form:label path="descript"> Description of Expense: </form:label>
						<form:errors path="descript"/>
						<form:input path="descript"/>
					</p>
					<input type="submit" value="submit"/>
			</form:form>
		</div>
	</div>

</body>
</html>

