<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!String name, id, pw; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	name = (String)session.getAttribute("name");
	id = (String)session.getAttribute("id");
	pw = (String)session.getAttribute("pw");
%>

<h2> <%=name %>님 환영합니다. </h2>
<a href="modify.jsp">회원정보 수정</a>
</body>
</html>