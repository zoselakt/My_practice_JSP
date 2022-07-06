<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="board.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   	<jsp:useBean id="dao" class="board.BoardDao"/>
   	<%
   		int num = Integer.parseInt(request.getParameter("num"));
   		BoardVo vo = dao.selectOne(num);
   		pageContext.setAttribute("vo", vo);
   	%>
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글 수정하기 </h3>
<form action="edit.jsp" method="post">
	<input type="hidden" name="num" value="${vo.num}">
	<input type="text" name="title" value="${vo.title}" required><br>
	<input type="text" name="writer" value="${vo.writer}" required disabled><br>
	<textarea rows="5" cols="30" name="content" placeholder="내용">"${vo.contents}"</textarea><br>
	<input type="submit" value="수정">
	
</form>
</body>
</html>