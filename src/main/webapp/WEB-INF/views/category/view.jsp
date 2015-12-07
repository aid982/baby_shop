<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	<c:if test="${!empty categoryList}">
	<p class="imgAll">
		<c:forEach items="${categoryList}" var="category">
		<c:out value="${category.name}"></c:out>		  
		</c:forEach>
	</p>

</c:if>  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
