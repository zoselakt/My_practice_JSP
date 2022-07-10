<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dao" class="jsp_board.dao.MemberDao"/>
    <jsp:useBean id="vo" class="jsp_board.vo.MemberVo"/>
    <jsp:setProperty property="*" name="vo"/>

   <%
    	dao.modifyMember(vo);
    	response.sendRedirect("main.jsp");
    %>