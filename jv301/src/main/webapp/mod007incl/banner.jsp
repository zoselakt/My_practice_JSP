<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.net.URLDecoder"%>
    <div>
    	<h4><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8") %></h4>
    </div>