<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Post a Project</title>
</head>
<body>
<div class="container">
<h1>Post a new project</h1>
<p>
<a href="/home">Home |</a>
<a href="/logout">Log out</a>
</p>
<hr>
<p>${message}</p>
<form method="POST" action="/projects/new" enctype="multipart/form-data">
<div class="form-group">
<label for="title">Title:</label>
<input type="text" name="title"/>
</div>
<div class="form-group">
<label for="image_url">Picture:</label>
<input type="file" size="100" name="image_url" class="form-control-file" id="inlineFormInput" />
</div>
<div class="col-auto">
<label for="description">Description:</label>
<textarea class="form-group" name="description" id="exampleFormControlTextarea1" placeholder="Enter a description."></textarea>
</div>
<p>
<input type="hidden" value="${userId}" name="user"/>
</p>
<button class="btn btn-primary">Create Project!</button>
</form> 
</div>
</body>
</html>