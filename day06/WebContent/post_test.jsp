<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post방식의 요청</title>
</head>
<body>
	<h1>post방식의 요청</h1>
	<form action="get_test.jsp" method="post">
		<input type="text" name="city" value="seoul" readonly>
		<input type="text" name="zipcode" value="14445" readonly>
		<button>post 방식으로요청보내기</button>
	</form>
	
</body>
</html>