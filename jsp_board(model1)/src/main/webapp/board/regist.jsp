<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
   	<jsp:useBean id="vo" class="jsp_board.vo.BoardVo"/>
   	<jsp:useBean id="dao" class="jsp_board.dao.BoardDao"/>
   	<jsp:setProperty name="vo" property="*"/>
   	<%
   		dao.insert(vo);
   	//밑에 내용과 동일한 내용  response.sendRedirect(request.getContextPath()/board/list.jsp");
   	%>
   	<c:redirect url=" ${pageContext.request.contextPath}/board/list.jsp "/>