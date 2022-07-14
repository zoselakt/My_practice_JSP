<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dao" class="jsp_board.dao.MemberDao"/>
    <jsp:useBean id="vo" class="jsp_board.vo.MemberVo"/>

<%
	String id = request.getParameter("MemberId");
	String pw = request.getParameter("password");
	
	if(dao.login(id, pw)){
		session.setAttribute("memberid", id);
		session.setAttribute("password", pw);
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("login.jsp?type=false");
	}
%>