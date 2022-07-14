<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인페이지</h2>
	<form action="login_ok.jsp" name="loginForm" method="post">
		<p>아이디 : <input type="text" name="MemberId"></p>
		<p>비밀번호 : <input type="text" name="password"></p>
		<input type="submit" value="로그인" onclick="login()">
	</form>
</body>

	<script>
		function login() {
			var form = document.loginForm;
			
			if(!form.MemberId.value){
				alert("아이디를 입력해주세요");
				return;
			}
			if(!form.password.value){
				alert("비밀번호를 입력해주세요");
				return;
			}
		if(document.getElementById("type").value == "false"){
			alert("로그인실패");
			return;
		}
	
		}
	</script>
	
</html>