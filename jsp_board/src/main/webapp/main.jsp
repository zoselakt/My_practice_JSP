<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<%=session.getAttribute("memberid") %> 님 환영합니다.
	</h1>
	<form action="logout.jsp">
		<input type="submit" value="로그아웃">
	</form>
	<br>
	<form action="modify.jsp">
		<input type="submit" value="정보수정">
	</form>
	<form action="board/list.jsp">
		<input type="submit" value="게시판 접속">
	</form>
</body>
</html>