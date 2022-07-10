<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="type" id="type" value="<%=request.getParameter("type") %>">
	<h2>회원가입</h2>
	<form action="join_ok.jsp" method="post">
		<p>아이디 : <input type="text" name="memberid"></p>
		<p>비밀번호 : <input type="text" name="password"></p>
		<p>이름 : <input type="text" name="name"></p>
		<p>전화번호 : <input type="text" name="phone"></p>
		<p>주소 : <input type="text" name="addr"></p>
		<p>주소 상세 : <input type="text" name="addr2"></p>
		<p>성별 : <input type="text" name="gender"></p>
		<input type="submit" value="가입">
	</form>
</body>
</html>