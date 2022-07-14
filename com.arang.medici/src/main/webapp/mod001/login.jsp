<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" name="type" id="type" value="<%=request.getParameter("type") %>">
	
	<form action="login.do" method="post">
		아이디: <input type="text" name="userId"value="<%if(session.getAttribute("id") !=null) out.println(session.getAttribute("id"));%>"><br/>
		비밀번호:" <input type="password" name="passwd"/><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>