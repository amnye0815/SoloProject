<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<title>Post a Project</title>
</head>
<body>
<div class="container">
<h2>Edit</h2>
<p>
<a href="/home">Home |</a>
<a href="/logout">Log out</a>
</p>
<hr>
<form:form method="POST" action="/projects/${project.id}/edit" modelAttribute="project">
<input type="hidden" name="_method" value="put">
<div class="form-group">
<form:label path="title">Title:</form:label>
<form:errors path="title"/>
<form:input path="title"/>
</div>
<div class="form-group">
<form:label path="description">Description:</form:label>
<form:errors path="description"/>
<form:input path="description"/>
</div>
<p>
<form:input type="hidden" value="${project.image_url}" path="image_url"/>
</p>
<p>
<form:input type="hidden" value="${userId}" path="user"/>
</p>
<button>Update</button>
</form:form>
</div>
</body>
</html>