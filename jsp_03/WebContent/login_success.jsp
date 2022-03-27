<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1>
		<%=session.getAttribute("id") %> 님 환영합니다.
	</h1>
	<input type="button" onclick="goLogout()" value="로그아웃">
</body>
	<script>
		function goLogout() {
			location.href="logout.jsp";
		}
	</script>
</html>