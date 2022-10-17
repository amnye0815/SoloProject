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
<title>Register</title>
</head>
<body class="background">
<div class="container">
		<div class="col">
		<h2>Register</h2>
		<form:form method="POST" action="/registration" modelAttribute="user">
			<div class="form-group">
		        <form:label path="firstName">First Name:</form:label>
		        <form:errors class="text-danger" path="firstName"/>
				<form:input class="form-control" path="firstName"/>
		    </div>
		    <div class="form-group">
		        <form:label path="lastName">Last Name:</form:label>
		        <form:errors class="text-danger" path="lastName"/>
		         <form:input class="form-control" path="lastName"/>
			</div>
		    <div class="form-group">
		        <form:label path="email">Email:</form:label>
		        <form:errors class="text-danger" path="email"/>
		        <form:input class="form-control" path="email"/>
		    </div>
	      <div class="form-group">
	            <form:label path="password">Password:</form:label>
	            <form:errors class="text-danger" path="password"/>
	            <form:password class="form-control" path="password"/>
	       </div>
	       <div class="form-group">
	            <form:label path="passwordConfirm">Confirm Password:</form:label>
	            <form:errors class="text-danger" path="passwordConfirm"/>
	            <form:password class="form-control" path="passwordConfirm"/>
			</div>
			<input class="btn btn-info" type="submit" value="Register"/>
	    </form:form>
	    </div> 
	    <a href="/">Already have an account? Login!</a>
</div>
</body>
</html>