<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   	<jsp:useBean id="dao" class="jsp_board.dao.MemberDao"/>
   	<jsp:useBean id="vo" class="jsp_board.vo.MemberVo"/>
   	
<%
	dao.removeMember(vo);
	response.sendRedirect("main.jsp");
%>
   	<c:redirect url=" ${pageContext.request.contextPath}/board/main.jsp "/>
   	
