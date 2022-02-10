<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Art App Home</title>
</head>
<body>
<h1>Welcome, ${user.firstName} ${user.lastName}!</h1>
<hr>
<a href="/logout">Log out</a> | <a href="/profiles/${user.id}">My Profile</a> | <a href="/projects/new">Post a Project</a>
<div>
<h3>Recent Projects:</h3>
<p>grid of project images that are clickable and link to their detail pages</p>
</div>
</body>
</html>