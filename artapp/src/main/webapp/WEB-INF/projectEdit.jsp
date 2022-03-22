<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/input.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<title>Post a Project</title>
</head>
<body class="background">
<div class="container">
	<div class="d-flex flex-column justify-content-center align-items-center">
		<img class="icon" src="/images/camera.png" />
		<h2>Edit Your Creation</h2> 
	</div>
	<hr>
	<div class="d-flex justify-content-center">
		<a class="links" style="color: #0DCAF0" href="/home">Home</a> | <a class="links" style="color: #0DCAF0" href="/logout">Log out</a>
	</div>
	<hr>
	<div class="d-flex justify-content-center">
		<form:form method="POST" action="/projects/${project.id}/edit" modelAttribute="project">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<form:label path="title">Title:</form:label>
				<form:errors path="title"/>
				<form:input class="form-group" path="title"/>
			</div>
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:textarea class="form-group" path="description"/>
			</div>
			<p>
				<form:input type="hidden" value="${project.image_url}" path="image_url"/>
			</p>
			<p>
				<form:input type="hidden" value="${userId}" path="user"/>
			</p>
				<button class="btn-lg btn-info">Update Project!</button>
		</form:form>
	</div>
</div>
</body>
</html>