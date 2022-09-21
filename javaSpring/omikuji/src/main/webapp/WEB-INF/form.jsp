<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>
<link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
	<div class="container">
		<h1> Send An Omikuji!</h1>
		<div class="form_container">
			<form action="/omikujipost" method="POST">
				<p>PICK A NUMBER 5 TO 25<input type="number" name="number"></p>
				<p>ENTER CITY NAME<input type="text" name="city"></p>
				<p>ENTER NAME OF ANY PERSON<input type="text" name="person"></p>
				<p>ENTER HOBBY<input type="text" name="hobby"></p>
				<p>ENTER ANY TYPE OF LIVING THING<input type="text" name="living"></p>
				<p>ENTER A NICE COMMENT<input type="text" name="comment"></p>
				<h5>SEND AND SHOW A FRIEND</h5>
				<button>SEND</button>
				
			</form>
		</div>
	</div>
</body>
</html>