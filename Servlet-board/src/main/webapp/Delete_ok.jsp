<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDao dao = MemberDao.getInstance();
	int check = dao.deleteMember(id, password);
	
	if(check == 1){
		session.invalidate();
	%>
	<br><br>
	<b><font size="4" color="gray">회원정보가 삭제되었습니다.</font></b> 
	<br><br><br>
	<input type="button" value="확인" onclick="javascript:window.location='MainForm.jsp'">
	<%
		}else{
	%>
	<script type="text/javascript">alert("비밀번호가 맞지 않습니다."); history.go(-1);</script>
	<% } %>
</body>
</html>