<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    if(session.getAttribute("chkMember")!=null){
    %>
    <jsp:forward page="main.jsp"/>
    <%
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2 align="center">로그인</h2>
	<hr/>
	<form action="LoginOk" method="post">
		<!-- 아이디 input태그 value에 세션에서 id값을 불러오기  -->
		아이디 <input type="text" name="id" value="<%if(session.getAttribute("id") != null) out.println(session.getAttribute("id"));%>"/><br/> 
		비밀번호 <input type="password" name="pw"><br/>
		<input type="submit" name="id" value="로그인"> / <input type="button" name="id" value="회원가입" onclick="javascript:window.location='join.jsp'">
	</form>
</center>
</body>
</html>