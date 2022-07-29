<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<!-- 회원가입 인증처리 js파일불러오기 -->
<script type="text/javascript" src="memconfirm.js"></script>
<body>
<center>
	<h2>회원가입</h2><hr>
	<form action="joinRes.jsp" method="post" name="join_frm">
		아이디: <input type="text" name="id" size="20"><br/>
		비밀번호: <input type="password" name="pw" size="20"><br/>
		비밀번호 확인: <input type="password" name="pw_confirm" size="20"><br/>
		이름: <input type="text" name="name" size="20"><br/>
		메일: <input type="text"	name="email" size="20"><br/>	
		주소: <input type="text"	name="address" size="50"><br/>	
		<input type="button" value="회원가입" onclick="mem_check()"> / <input type="reset" value="취소">
	</form>
</center>
</body>
</html>