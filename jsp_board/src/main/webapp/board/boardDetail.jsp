<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       	<%@ page import="board.*" %>
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
<h2>글 정보</h2>
<p>번호 : ${vo.num }</p>
<p>제목 : ${vo.title }</p>
<p>작성자 : ${vo.writer }</p>
<p>내용 : ${vo.contents }</p>
<p>등록일자 : ${vo.regdate }</p>
<p>조회수 : ${vo.cnt }</p>

<a href="<c:url value="/board/editForm.jsp?num=${vo.num}"/>"> <button>글 수정</button></a>
<a href="<c:url value="/board/deleteForm.jsp?num=${vo.num}"/>"> <button>글 삭제</button></a>
</body>
</html>