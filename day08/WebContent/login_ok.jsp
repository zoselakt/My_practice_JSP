<%@page import="java.util.Base64"%>
<%@page import="java.util.Base64.Decoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean class="dao.UserDAO" id="dao"/>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	Decoder decoder = Base64.getDecoder();
	pw = new String(decoder.decode(pw));
	
//	HttpSession session = request.getSession();
	if(dao.login(id, pw)){
		session.setAttribute("id", id);		
		response.sendRedirect("login_success.jsp");
	} else {
		response.sendRedirect("login.jsp?type=false");
	}
%>