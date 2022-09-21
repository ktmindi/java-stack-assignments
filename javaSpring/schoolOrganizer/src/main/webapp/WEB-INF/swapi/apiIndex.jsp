
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SWAPI</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
	<div id="container-fluid">
		<div class="row justify-content-center">
			<div class="col-6">
				<form action="/swapi/character" method="GET">
					<select class="form-control" name="id">
						<c:forEach var="character" items="${characters}" varStatus="loop">
							<option value="${loop.index + 1}">${character.name}</option>
						</c:forEach>
					</select>
					<button class="btn btn-success">Get Character</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>