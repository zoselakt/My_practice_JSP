<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2><%=session.getAttribute("name") %>님의 회원정보 수정이 정상적으로 완료되었습니다.</h2><br/>

<a href="logout.jsp">로그아웃</a>

</body>
</html>