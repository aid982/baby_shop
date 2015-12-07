<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	${loginError}
	<form action='login' method="post">
		<div>
			<label>Логин:</label> <input type="text" id="userId" name="userId"
				placeholder="user name" class="form-control" />
		</div>
		<div>
			<label>Пароль:</label> <input type="password" id="password"
				name="password" placeholder="password" class="form-control" />
		</div>
		<button id="loginButton" class="form-control">Login</button>
	</form>
	<br> ЕЩЕ НЕТ ЛИЧНОГО КАБИНЕТА? 
	<a href="<c:url value="/users?register"/>">
		<button type="button" class="btn btn-default">Создать</button>
	</a>

</div>




