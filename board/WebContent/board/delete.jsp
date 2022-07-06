<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   	<%@ page import="board.*" %>
   	<jsp:useBean id="dao" class="board.BoardDao"/>

<%
	int num = Integer.parseInt(request.getParameter("num"));
	dao.delete(num);
%>
   	<c:redirect url=" ${pageContext.request.contextPath}/board/list.jsp "/>