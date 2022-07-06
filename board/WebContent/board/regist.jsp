<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   	<%@ page import="board.*" %>
   	
   	<jsp:useBean id="vo" class="board.BoardVo"/>
   	<jsp:useBean id="dao" class="board.BoardDao"/>
   	<jsp:setProperty name="vo" property="*"/>
   	<%
   		dao.insert(vo);
   	//밑에 내용과 동일한 내용  response.sendRedirect(request.getContextPath()/board/list.jsp");
   	%>
   	<c:redirect url=" ${pageContext.request.contextPath}/board/list.jsp "/>