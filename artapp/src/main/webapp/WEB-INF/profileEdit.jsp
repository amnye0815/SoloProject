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
<div class="container">
	<div class="row">
	<h1>Edit Your Profile</h1>
	<hr>
		<div class="col">
		<form:form method="POST" action="/profiles/${thisUser.id}/edit" modelAttribute="profile">
		 <input type="hidden" name="_method" value="put">
			<div class="form-group">
		        <form:label path="bio">Bio:</form:label>
				<form:input class="form-control" path="bio"/>
		    </div>
		    <div class="form-group">
		        <form:label path="age">Age:</form:label>
		         <form:input class="form-control" path="age"/>
			</div>
		    <div class="form-group">
		        <form:label path="location">Location:</form:label>
		        <form:input class="form-control" path="location"/>
		    </div>
	      <div class="form-group">
	            <form:label path="media">Media Types:</form:label>
	            <form:input class="form-control" path="media"/>
	       </div>
	       <div>
			<input type="submit" value="Update"/>
			</div>
	    </form:form>
	    </div>   
	</div> 
</div>
</body>
</html>