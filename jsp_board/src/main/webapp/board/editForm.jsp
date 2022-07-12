<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
   	<jsp:useBean id="dao" class="jsp_board.dao.BoardDao"/>
   	<jsp:useBean id="vo" class="jsp_board.vo.BoardVo"/>
   	   	<jsp:setProperty name="vo" property="*"/>
   	   	
   	<%
   		int num = Integer.parseInt(request.getParameter("num"));
   		vo = dao.selectOne(num);
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
	<textarea rows="5" cols="30" name="contents" placeholder="내용">"${vo.contents}"</textarea><br>
	<input type="submit" value="수정">
	
</form>
</body>
</html>