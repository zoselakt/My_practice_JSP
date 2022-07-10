<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="jsp_board.vo.*" %>
   	<%@ page import="java.util.*" %>
   	
    <jsp:useBean id="vo" class="jsp_board.vo.BoardVo"/>
   	<jsp:useBean id="dao" class="jsp_board.dao.BoardDao"/>
   	<jsp:setProperty name="vo" property="*"/>
    
    <%
    	List<BoardVo> ls = dao.boardAll();
    	pageContext.setAttribute("ls", ls);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<table>
		<tr><th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>조회수</th></tr>
		<c:forEach var="board" items="${ls}">
			<tr>
				<td>${board.num}</td>
				<td><a href="${pageContext.request.contextPath}/board/boardDetail.jsp?num${board.num}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="createForm.jsp"/>"><button>글등록</button></a>
</body>
</html>