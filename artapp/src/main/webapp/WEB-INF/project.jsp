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
<title>Project Details</title>
</head>
<body>
<div class="container">
<h1><c:out value="${thisProject.title}"/></h1>
<p><img src="${thisProject.image_url}"/></p>
<p>Created By: <c:out value="${thisProject.user.firstName} ${thisProject.user.lastName}"/></p>
<p>Created At: <c:out value="${thisProject.createdAt}" /></p>
<p><c:out value="${thisProject.likers.size()}"/> likes!</p>
<c:choose>
<c:when test="${thisProject.likers.contains(user)}"><a href="/unlike/${thisProject.id}">UnLike</a></c:when>
<c:otherwise><a href="/like/${thisProject.id}">Like</a></c:otherwise>
</c:choose>
<hr>
<h3>Users who liked your project:</h3>
<table class="table">
<thead>
<tr>
<th>Name:</th>
</tr>
</thead>
<tbody>
<c:forEach items="${thisProject.likers}" var="user">
<tr>
<td><c:out value="${user.firstName} ${user.lastName}" /></td>
</tr>
</c:forEach>
</tbody>
</table>
<c:if test="${thisProject.user.id==userId}">
<form method="GET" action="/projects/${thisProject.id}/edit">
<button>Edit</button>
</form>
<form method="POST" action="/delete/${thisProject.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button>
</form>
</c:if>
<a href="/home">Home</a> | <a href="/logout">Log out</a>
</div>
</body>
</html>