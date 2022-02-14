<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Art App Home</title>
</head>
<body>
<h1>Welcome, ${user.firstName} ${user.lastName}!</h1>
<hr>
<a href="/logout">Log out</a> | <a href="/profiles/${user.id}">My Profile</a> | <a href="/projects/new">Post a Project</a>
<div>
<h3>Recent Projects:</h3>
<c:forEach items="${allProjects}" var="project">
<p><a href="/projects/${project.id}"><img src="${project.image_url}" /></a></p>
</c:forEach>
</div>
</body>
</html>