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
<title>Profile</title>
</head>
<body>
<h1>${thisUser.firstName} ${thisUser.lastName}'s Profile</h1>
<a href="/logout">Log out</a> | <a href="/home">Home</a> | <a href="/projects/new">Post a Project</a>
<hr>
<h3>Portfolio:</h3>
<c:forEach items="${project}" var="usersProject">
<p><a href="/projects/${usersProject.id}"><c:out value="${usersProject.image_url}"/></a></p>
</c:forEach>
</body>
</html>