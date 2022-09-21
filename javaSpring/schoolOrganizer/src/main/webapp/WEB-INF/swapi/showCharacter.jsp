<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TODO App</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
	<div id="container-fluid">
		<div class="row justify-content-center">
			<div class="col-6">
				<table class="table">
					<thead>
						<th>Attribute</th>
						<th></th>
					</thead>
					<tbody>
						<tr>
							<td>Name</td>
							<td>${character.name}</td>
						</tr>
						<tr>
							<td>Height</td>
							<td>${character.height}</td>
						</tr>
						<tr>
							<td>Hair Color</td>
							<td>${character.hair_color}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-7 text-center">
				<a href="/swapi" class="btn btn-info">home</a>
			</div>
		</div>
	</div>
</body>
</html>