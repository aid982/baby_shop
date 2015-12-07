<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title" id="myModalLabel">${product.name}</h4>
</div>
<div class="modal-body">

	<div class="thumbnail">
		<a href="<c:url value="/resources/images/_${product.id}_large.jpg"/>"
			class="zoom"> <img
			src="<c:url value="/resources/images/_${product.id}.jpg" />"
			alt="...">
		</a>
		<div class="caption"></div>
	</div>
	Цена : ${product.price} грн. Размеры:
	<c:if test="${!empty productSizes}">
		<div class="btn-group" role="group" aria-label="...">
			<c:forEach items="${productSizes}" var="itemSize">
				<button type="button" class="btn btn-default" onclick="ClickOnMySizeButton('${itemSize.size}')">${itemSize.size}</button>
			</c:forEach>
		</div>
		
	</c:if>
	<button type="button" class="btn btn-default" onclick="ClickOnMyAddToCartButton('<c:url value="/cart/add/${product.id}"/>',${product.price})">В карзину</button>	
	
	<!-- <script type="text/javascript">
		$(function() {
			$('.zoom').zoomy();
		}(jQuery))
	</script>
	 -->



</div>
<div class="modal-footer"></div>



