<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   	<% request.setCharacterEncoding("utf-8"); %>
   	<%@ page import="board.*" %>
   	<jsp:useBean id="vo" class="board.BoardVo"/>
   	<jsp:useBean id="dao" class="board.BoardDao"/>
   	<jsp:setProperty name="vo" property="*"/>
   	<%
   		dao.update(vo);
   		pageContext.setAttribute("vo", vo);
   	%>
   	<c:redirect url=" ${pageContext.request.contextPath}/board/boardDetail.jsp?num${vo.num } "/>