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
<link href="https://fonts.googleapis.com/css2?family=Megrim&family=Monoton&display=swap" rel="stylesheet">
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
				<button type="button" class="toggle-btn">Log In</button>
				<button type="button" class="toggle-btn">Register</button>
			</div>
			<form class="input-group">
				<input type="text" class="input-field" placeholder="Email" required>
				<input type="password" class="input-field" placeholder="Password" required>
				<input type="checkbox" class="check-box"><span>Remember Password</span>
				<button type="submit" id="submit-btn-link" href="#submit-btn">Log In</button>
			</form>
		</div>
	</div>
</body>
</html>