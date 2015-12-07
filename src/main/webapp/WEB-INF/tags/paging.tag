<%@ tag language="java" pageEncoding="UTF-8"%>
<%@page import="org.springframework.util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="pagedListHolder" required ="true" type ="org.springframework.beans.support.PagedListHolder"%>
<%@ attribute name="pagedLink" required ="true" type ="java.lang.String"%>


<c:if test="${pagedListHolder.pageCount>1}"> 
<nav>
  <ul class="pagination">
  	<c:if test="${pagedListHolder.firstPage}">
    <li>    
      <a href="<%StringUtils.replace(pagedLink,"~",String.valueOf(pagedListHolder.getPage()-1));%>" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:if test="${pagedListHolder.firstLinkedPage>0}">
    	<li><a href="<%=StringUtils.replace(pagedLink,"~","0")%>">1</a></li>
    </c:if>   
    <c:forEach begin="${pagedListHolder.firstLinkedPage}"
     end = "${pagedListHolder.lastLinkedPage}" var="i">
     <c:choose>
      <c:when test="${pagedListHolder.page == i}">
        <li><a href="#">${i+1}</a></li>      
      </c:when>
      <c:otherwise>
      	<li><a href="<%=StringUtils.replace(pagedLink,"~",String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a></li>      
      </c:otherwise>
     </c:choose>
    </c:forEach> 
  
    
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</c:if>
	


