<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Sacramento&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Art App Home</title>
</head>
<body class="background">
<div class="container">
		<div class="topper d-flex flex-column justify-content-center align-items-center">
			<a href="/home"><img class="icon" src="/images/camera.png" /></a>
			<h2>Culture  Cache</h2>
		</div> 
	<hr>
	<div class="d-flex justify-content-center">
		<a class="links" style="color: #0DCAF0" href="/logout">Log out</a> | <a class="links" style="color: #0DCAF0" href="/profiles/${user.id}">My Profile</a> | <a class="links" style="color: #0DCAF0" href="/projects/new">Post a Project</a>
	</div>
	<hr>
	<div class="portfolio">
		
		<div class="d-flex flex-wrap justify-content-center align-items-center">
			<c:forEach items="${allProjects}" var="project">
				<p><a href="/projects/${project.id}"><img class="border border-info rounded" src="${project.image_url}" /></a></p>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>