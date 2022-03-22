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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<title>Post a Project</title>
</head>
<body class="background">
<div class="container">
	<div class="d-flex flex-column justify-content-center align-items-center">
		<img class="icon" src="/images/camera.png" />
		<h2>Post Your Creation</h2> 
	</div>
	<hr>
	<div class="d-flex justify-content-center">
		<a class="links" style="color: #0DCAF0" href="/home">Home</a> | <a class="links" style="color: #0DCAF0" href="/logout">Log out</a>
	</div>
	<hr>
	<div class="d-flex justify-content-center">
		<form method="POST" action="/projects/new" enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title:</label>
				<input  class="form-group" type="text" name="title"/>
			</div>
			<div class="form-group">
				<label for="image_url">Picture:</label>
				<input type="file" size="100" name="image_url" class="form-control-file form-group" id="inlineFormInput" />
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea class="form-group" name="description" id="exampleFormControlTextarea1" placeholder="Enter a description."></textarea>
			</div>
			<p>
				<input type="hidden" value="${userId}" name="user"/>
			</p>
			<button class="btn-lg btn-info">Share Project!</button>
		</form>
	</div>
</div>
</body>
</html>