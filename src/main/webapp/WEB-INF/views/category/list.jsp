<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="btn-group btn-group-vertical" data-toggle="buttons-radio">>
	<c:if test="${!empty categoryList}">
		<div class="list-group">
			<c:forEach items="${categoryList}" var="category">
				<a href="<c:url value="/categories/${category.name}"/>">
					<button type="button" class="btn">
						<c:out value="${category.name}" />
					</button>

				</a>

			</c:forEach>
		</div>
	</c:if>

</div>




