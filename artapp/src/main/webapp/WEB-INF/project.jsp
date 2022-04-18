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
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<title>Project Details</title>
</head>
<body class="background">
<div class="container">
	<div class="header d-flex flex-column justify-content-center align-items-center">
		<a href="/home"><img class="icon" src="/images/camera.png" /></a>
		<h2><c:out value="${thisProject.title}"/></h2> 
		<p>Created By: <a style="color: #0DCAF0" href="/profiles/${thisProject.user.id}"><c:out value="${thisProject.user.firstName} ${thisProject.user.lastName}"/></a></p>
	</div>
	<hr>
	<div class="d-flex justify-content-center">
		<a class="links" style="color: #0DCAF0" href="/logout">Log out</a> | <a class="links" style="color: #0DCAF0" href="/home">Home</a> | <a class="links" style="color: #0DCAF0" href="/profiles/${user.id}">My Profile</a>
	</div>
	<hr>
	<img class="border border-info rounded" src="${thisProject.image_url}"/>
	<div class="img-deets">
		<p>Description: <c:out value="${thisProject.description}" /></p>
		<p><c:out value="${thisProject.likers.size()}"/> <a href="/projects/${thisProject.id}/likers">likes!</a></p>
			<c:choose>
				<c:when test="${thisProject.likers.contains(user)}"><a style="color: #0DCAF0" href="/unlike/${thisProject.id}">UnLike</a></c:when>
				<c:otherwise><a style="color: #0DCAF0" href="/like/${thisProject.id}">Like</a></c:otherwise>
			</c:choose>
	</div>
	<hr>
		<div class="d-flex justify-content-start">
			<c:if test="${thisProject.user.id==userId}">
				<form method="GET" action="/projects/${thisProject.id}/edit">
					<button class="btn btn-info">Edit</button>
				</form>
				<form method="POST" action="/delete/${thisProject.id}">
					<input type="hidden" name="_method" value="delete">
					<button class="btn btn-info">Delete</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>