<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" method="post">
		<ul>
			<li> 회원 아이디: <input type="text" name="id"></li>
			<li> 비밀번호:   <input type="password" name="password"></li>
			<li> 이름:      <input type="text" name="name"></li>
			<li> 주민번호:   <input type="text" name="ssn"></li>
			<li> 이메일1:    <input type="email" name="email1"></li>
			<li> 이메일2:    <input type="text" name="email2"></li>
			<li> 주소1:    <input type="text" name="addr1"></li>
			<li> 주소2:    <input type="text" name="addr2"></li>
		</ul>
		<br>
		<input type="submit" name="확인">
	</form>
</body>
</html>