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
<title>Edit</title>
</head>
<body>
<div class="container">
<h1>Edit ${idea.content}</h1>
<p>
<a href="/ideas">Home |</a>
<a href="/logout">Log out</a>
</p>
<hr>
<form:form action="/ideas/${idea.id}/edit" method="PUT" modelAttribute="idea">
<div class="form-group">
<form:label path="content">Content:</form:label>
<form:errors path="content"/>
<form:input path="content"/>
</div>
<div class="form-group">
<form:input type="hidden" value="${userId}" path="user"/>
<input type="hidden" name="_method" value="put">
<button>Update</button>
</div>
</form:form>
<p>
<form method="POST" action="/delete/${idea.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button>
</form>
</p>
</div>
</body>
</html>