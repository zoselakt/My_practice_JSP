<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDao dao = MemberDao.getInstance();
	int check = dao.loginCheck(id, password);
	String msg = "";
	if(check == 1){
		session.setAttribute("sessionID", id);
		msg = "./MainForm.jsp";
	}else if(check == 0){
		msg = "./LoginForm.jsp?msg=0";
	}else{
		msg = "./LoginForm.jsp?msg= -1";
	}
	response.sendRedirect(msg);
%>