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
	<h2>ȸ������</h2>
	<form action="join_ok.jsp" method="post">
		<p>���̵� : <input type="text" name="memberid"></p>
		<p>��й�ȣ : <input type="text" name="password"></p>
		<p>�̸� : <input type="text" name="name"></p>
		<p>��ȭ��ȣ : <input type="text" name="phone"></p>
		<p>�ּ� : <input type="text" name="addr"></p>
		<p>�ּ� �� : <input type="text" name="addr2"></p>
		<p>���� : <input type="text" name="gender"></p>
		<input type="submit" value="����">
	</form>
</body>
</html>