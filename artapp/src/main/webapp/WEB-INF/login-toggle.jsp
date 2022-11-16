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
<link rel="stylesheet" type="text/css" href="css/login-toggle.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
<link rel="icon" href="/images/camera.png">
<title>Culture Cache</title>
</head>
<body>
	<div class="background">
		<div class="form-box">
			<div class="topper">
				<img class="icon" src="images/camera.png" />
				<h2 id="title">Culture Cache</h2>
			</div>
			<div class="button-box">
				<div id="btn"></div>
				<button type="button" class="toggle-btn" onclick="login()">Log In</button>
				<button type="button" class="toggle-btn" onclick="register()">Register</button>
			</div>
			<form id="login" class="input-group" method="post" action="/login">
			<p class="text-danger"><c:out value="${error}"/></p>
				<input type="text" class="input-field" id="email" name="email"  placeholder="Email" required>
				<input type="password" class="input-field" id="password" name="password" placeholder="Password" required>
				<button type="submit" id="submit-btn-link" href="#submit-btn">Log In</button>
			</form>
			
			<form id="register" class="input-group" method="post" action="/registration" modelAttribute="user">
				<input type="text" class="input-field" id="firstName" name="firstName" placeholder="First Name" required>
				<input type="text" class="input-field" id="lastName" name="lastName" placeholder="Last Name" required>
				<input type="text" class="input-field" id="email" name="email" placeholder="Email" required>
				<input type="password" class="input-field" id="password" name="password" placeholder="Password" required>
				<input type="password" class="input-field" id="passwordConfirm" name="passwordConfirm" placeholder="Confirm Password" required>
				<button type="submit" id="submit-btn-link" href="#submit-btn">Register</button>
			</form>
		</div>
	</div>
	
<script>
var x = document.getElementById("login");
var y = document.getElementById("register");
var z = document.getElementById("btn");

function register(){
	x.style.left = "-400px";
	y.style.left = "50px";
	z.style.left = "110px";
}

function login(){
	x.style.left = "50px";
	y.style.left = "450px";
	z.style.left = "0";
}

</script>

</body>
</html>