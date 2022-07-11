<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	if(session.getAttribute("valid") !=null){
%>   
	<jsp:forward page = "ad_main.jsp"></jsp:forward> 
<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<hr width = 500 color="green">
<h2>관리자 로그인</h2>
<hr width = 500 color="green">

	<form action = "loginOk.jsp" method = "post">
		아이디 :<input type="text" name="id" value="<%if(session.getAttribute("id") !=null) out.println(session.getAttribute("id"));%>"><br/>
		비밀번호 : <input type="password" name="pw"><br/>
		<input type="submit" value="로그인">		  
	</form>
</center>
</body>
</html>