<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/login.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Megrim&family=Monoton&display=swap" rel="stylesheet">
<link rel="icon" href="/images/camera.png">
<title>Culture Cache - Join Today!</title>
</head>
<body class="background">
<div class="container">
	<div class="row">

		<div class="hr">
		<hr>
		<div class="d=flex flex-column">
		<h4 class="d-flex flex-wrap justify-content-center">Join a network of creatives around the globe</h4>
		<h5 class="d-flex flex-wrap justify-content-center">Register or Login below</h5>
		</div>
		<hr>
		</div>
  
	<div class="col">
    <h2>Login</h2>
	<form method="post" action="/login">
    <p class="text-danger"><c:out value="${error}"/></p>
    <div class="form-group">
		<label type="email" for="email">Email:</label>
		<input class="form-control"  type="text" id="email" name="email"/>
    </div>
    <div class="form-group">
		<label for="password">Password:</label>
		<input class="form-control"  type="password" id="password" name="password"/>
	</div>
    <input class="btn btn-info" type="submit" value="Login"/>
    </form>   
    </div> 
    </div>
    <a href="/register">Need to register? Click here!</a>
    <a href="/login-toggle">Login Toggle Page for testing</a>
    </div>
</body>
</html>