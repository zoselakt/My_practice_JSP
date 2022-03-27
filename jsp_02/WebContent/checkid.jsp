<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(request.getParameter("id").equals("hds1234")){
		out.println("실패");
	}else{
		out.println("성공");		
	}
%>