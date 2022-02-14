<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Java Exam</title>
</head>
<body>
<div class="container">
<h1>Welcome, ${user.firstName} ${user.lastName}!</h1>
<p>
<a href="/logout">Log out</a>
</p>
<hr>
<h3>Ideas</h3>
<table class="table">
<thead>
<tr>
<th>Idea</th>
<th>Created By</th>
<th>Likes</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${allIdeas}" var="idea">
<tr>
<td><a href="/ideas/${idea.id}"><c:out value="${idea.content}"/></a></td>
<td><c:out value="${idea.user.firstName}"/></td><td><c:out value="${idea.likers.size()}"/></td><td><c:choose><c:when test="${idea.likers.contains(user)}"><a href="/unlike/${idea.id}">UnLike</a></c:when><c:otherwise><a href="/like/${idea.id}">Like</a></c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<p>
<form method="GET" action="/ideas/new">
<button>Create an idea</button>
</form>
</p>
</div>
</body>
</html>