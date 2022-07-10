<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <jsp:useBean id="dao" class="jsp_board.dao.MemberDao"/>
    <jsp:useBean id="vo" class="jsp_board.vo.MemberVo"/>
    <jsp:setProperty property="*" name="vo"/>
    
    <%
    	dao.addUser(vo);
    	response.sendRedirect("login.jsp");
    %>
