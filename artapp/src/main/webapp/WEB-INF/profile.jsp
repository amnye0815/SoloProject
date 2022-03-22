<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/profile.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body class="background">
<div class="container">
	<div class="d-flex flex-column justify-content-center align-items-center">
		<img class="icon" src="/images/camera.png" />
		<h2 class="header align-self-center">${thisUser.firstName}'s Profile</h2>
	</div>
	<hr>
	<div class="d-flex justify-content-center">
		<a class="links" style="color: #0DCAF0" href="/logout">Log out</a> | <a class="links" style="color: #0DCAF0" href="/home">Home</a> | <a class="links" style="color: #0DCAF0" href="/projects/new">Post a Project</a>
	</div>
	<hr>
	<div class="portfolio">
		<div class="d-flex flex-wrap justify-content-start">
			<c:forEach items="${project}" var="usersProject">
				<p class="h-25"><a href="/projects/${usersProject.id}"><img class="border border-info rounded" src="${usersProject.image_url}"/></a></p>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>