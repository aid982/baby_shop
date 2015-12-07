<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="filter_menu">
	<c:if test="${!empty categoryList}">
		<ul>
			<c:forEach items="${categoryList}" var="category">
				<li><a href="<c:url value="/categories/${category.id}"/>">
						<c:out value="${category.name}" />
				</a></li>
			</c:forEach>
		</ul>
	</c:if>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" id="Modal_cont"></div>
	</div>
</div>

<c:if test="${!empty productList}">
	<div class="row" id="productList">
		<c:forEach items="${productList}" var="product">
			<div class="col-md-3">
				<div class="imagebox"
					onclick="LoadModal('<c:url value="/products/${product.id}"/>')"">
					<!--<c:url value="/products/${product.id}"/> -->
					<img
						src="<c:url value="/resources/images/_${product.id}_small.jpg" />"
						alt="...">
					<div class="caption" id="captionIMG">
						<p align="center" id="nameIMG">${product.name}</p>
						<p align="center">Цена : ${product.price} грн.</p>
					</div>

				</div>
			</div>

		</c:forEach>
	</div>
</c:if>
<c:if test="${pagedListHolder.getPageCount()>1}">
	<nav>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> </a></li>
			<li><a href="<c:url value="?page=0"/>">1</a></li>
			<li><a href="<c:url value="?page=1"/>">2</a></li>
			<li><a href="<c:url value="?page=2"/>">3</a></li>
			<li><a href="#" aria-label="Next"> </a></li>
		</ul>
	</nav>
</c:if>














