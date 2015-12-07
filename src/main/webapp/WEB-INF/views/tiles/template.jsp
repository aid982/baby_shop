<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Baby shop</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/mycss.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/zoomy.css"/>" />
<body>

	<div class="container page-content">
		<div>
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>

		<div class="menu">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
		<div>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>

		<div>
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>

</body>





<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
</script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/plugins.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
<script src="<c:url value="/resources/js/my.js"/>"></script>
<script
	src="<c:url value="/resources/js/vendor/modernizr-2.8.3.min.js"/>"></script>
</head>
<script src="<c:url value="/resources/js/zoomy.js"/>"></script>


</html>
