<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
<div style="float: left">
<c:if test="${!empty categoryList}">       
       <c:forEach items="${categoryList}" var="category">
       	<c:out value="${category.name} "></c:out>              
       <br>
       </c:forEach>
</c:if>
		

	</div>

	
</h1>