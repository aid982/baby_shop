<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="container">
	<form:form class="form-group form" name="input" method="post" modelAttribute="user"
		action="users/${user.name}">
		<form:input type="hidden" path="id" />
		<div>
			<label>Username:</label> 
			<form:input class="form-control" type="text" path="name" readonly="true" />
		</div>
		<div>
			<label>Password: </label>
			<form:input class="form-control" type="text" path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<label>Email:</label>
			<form:input class="form-control" type="text" path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<label>First Name:</label>
			<form:input class="form-control" type="text" path="firstName" />
			<form:errors path="firstName" />
		</div>
		<div>
			<label>Last Name:</label>
			<form:input class="form-control" type="text" path="lastName" />
			<form:errors path="lastName" />
		</div>
		<div>
			<input class="form-control" type="submit" value="Submit">
		</div>
	</form:form>
	</div>
