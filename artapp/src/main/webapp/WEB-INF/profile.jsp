<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<h1>${thisUser.firstName} ${thisUser.lastName}'s Profile</h1>
<a href="/profiles/${thisUser.id}/edit">Edit</a> | <a href="/delete/user/${thisUser.id}">Delete</a>
<hr>
<p>Bio: <c:out value="${thisUser.bio}" /></p>
<p>Age: <c:out value="${thisUser.age}" /></p>
<p>Location: <c:out value="${thisUser.location}" /></p>
<p>Media Types: <c:out value="${thisUser.media}" /></p>
</body>
</html>