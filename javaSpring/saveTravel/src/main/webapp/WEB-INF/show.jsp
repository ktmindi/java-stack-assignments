<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">

<title>Details About An Expense</title>
</head>

<body>
	<div class = "container">
		<div class = "toppart">
			<h2>EXPENSE DETAILS</h2><a href="/expenses"> GO BACK</a>
		</div>
			<div>
				<table class="table table-bordered table-striped">
	  				<tr>
	    				<th>NAME OF EXPENSE:</th>
	    				<td>${oneExp.item}</td>
	  				</tr>
	  				<tr>
	   					<th>EXPENSE DESCRIPTION:</th>
	    				<td>${oneExp.descript}</td>
					</tr>
					<tr>
					    <th>EXPENSE VENDOR:</th>
					    <td>${oneExp.seller}</td>
					</tr>
					<tr>
					    <th>TOTAL EXPENSE AMOUNT:</th>
					    <td>$ ${oneExp.cost}</td>
					</tr>
				</table>
	  		
	  		</div>
	</div>
	
</body>
</html>

