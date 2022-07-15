<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>     
#wrap {width: 800px; margin: 0 auto 0 auto; }  
#header { text-align: center;            
	width: 800px;
	height: 150px;
	background-color: #92FFFF;
	padding: 60px 0px;
}                
#main {            
	float: left;
	width: 800px;
	height: 500px;
	background-color: #FFCA6C;
	text-align:center;
	vertical-align: middle;
}        
#footer {
	clear: left;
	width: 800px;
	height: 60px;
	background-color: #7DFE74;
}    
</style>
</head>
<body>
	<b><font size="5">메인화면입니다.</font></b><br><br>
	<%
		if(session.getAttribute("sessionID") == null){
			response.sendRedirect("LoginForm.jsp");
		}else{
	%>
	<h2><font><%= session.getAttribute("sessionID") %></font></h2><br><br>
	<input type="button" value="로그아웃" onclick="logoutPro()"/>
	
	<% } %>
	
</body>
</html>
	
<script type="text/javascript">               
function logoutPro(){            
	location.href="member/pro/LogoutPro.jsp";        
	}    
</script>
