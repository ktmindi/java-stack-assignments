<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Your Omikuji</h1>
			<p> In <span class="input"><c:out value="${numberFront}"/></span> 
			years, you will live in 
			<span class="input"><c:out value="${cityFront}"/></span> 
			with <span class="input"><c:out value="${personFront}"/></span> 
			as your roommate.You guys will sell 
			<span class="input"><c:out value="${hobbyFront}"/></span> 
			for a living. The next time you see a 
			<span class="input"><c:out value="${livingFront}"/></span>
			, you will have good luck. Also, 
			<span class="input"><c:out value="${commentFront}"/></span></p>
			
		<a href="/omikuji"><button>GO BACK</button></a>
	</div>
</body>
</html>