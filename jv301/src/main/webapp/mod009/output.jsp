<%@page import="jv300.mod001.dao.MemberDao"%>
<%@page import="jv300.mod001.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="java.util.*" %>
       	
<%
	MemberDao dao = new MemberDao();

	List<MemberVo> ls = dao.findUser();
	pageContext.setAttribute("ls", ls);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 목록</h2>
	<form method="get">
		<c:forEach var="member" items="${ls}">
			<tr>
				<p>번호 :<td>${member.num}</td><p>
				<p>아이디 :<td>${member.Id}</td><p>
				<p>비밀번호 :<td>${member.password}</td><p>
				<p>이름 :<td>${member.name}</td><p>
			</tr>
		</c:forEach>
	</form>
</body>
</html>