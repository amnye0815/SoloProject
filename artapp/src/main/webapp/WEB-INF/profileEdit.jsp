<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex justify-content-center">
	<form:form method="POST" action="/profiles/${profile.id}/edit" modelAttribute="profile">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<form:label path="age">Age:</form:label>
				<form:errors path="age"/>
				<form:input class="form-group" path="age"/>
			</div>
			<div class="form-group">
				<form:label path="location">Location:</form:label>
				<form:errors path="location"/>
				<form:textarea class="form-group" path="location"/>
			</div>
			<div class="form-group">
				<form:label path="bio">Bio:</form:label>
				<form:errors path="bio"/>
				<form:textarea class="form-group" path="bio"/>
			</div>
			<div class="form-group">
				<form:label path="media">Media of choice:</form:label>
				<form:errors path="media"/>
				<form:textarea class="form-group" path="media"/>
			</div>
			<p>
				<form:input type="hidden" value="${userId}" path="user"/>
			</p>
				<button class="btn-lg btn-info">Update Profile!</button>
		</form:form>
	</div>
</body>
</html>