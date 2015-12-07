<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<h1>Карзина</h1>
	</div>

	<!-- Table -->
	<table class="table">
		<tr>
			<td>Товар</td>
			<td>Размер</td>
			<td>Количество</td>
			<td>Цена в грн.</td>
			<td>Сумма в грн.</td>
		</tr>
		<c:if test="${!empty cartList}">
			<c:forEach items="${cartList}" var="cartItem">
				<tr>
					<td>${cartItem.product}</td>
					<td>${cartItem.size}</td>
					<td>${cartItem.qty}</td>
					<td>${cartItem.price}</td>
					<td>${cartItem.qty*cartItem.price}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<h3 align="left">Итого к оплате :${cartTotal} грн.</h3>

</div>










