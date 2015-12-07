<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h4>Регистрация</h4>

<form:form class="form-group form" name="input" method="post"
	action="users" modelAttribute="user">

	<form:errors path="name" />
		Логин:
		<form:input class="form-control" type="text" path="name" />
	<br />
	<form:errors path="password" />
		Пароль:
		<form:input class="form-control" type="password" path="password" />
	<br />
	<form:errors path="email" />
		Email:
		<form:input class="form-control" type="text" path="email" />
	<br />
		Телефон:
		<form:input class="form-control" type="text" path="phone" />
	<br />

	<input class="form-control" type="submit" value="ok">
</form:form>




