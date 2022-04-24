<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="connectionpool.*"%>
	<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");
	MemberDAO mdao = MemberDAO.getInstance();
	MemberDTO mdto = mdao.getMember(id);
    %>
    
<!DOCTYPE html>
<html>
<script type="text/javascript" src="memconfirm.js"></script>
<body>
<center>
	<h2>회원정보 수정</h2>
	<hr>
	<form action="JoinOk" method="post" name="modify_frm">
		아이디:  <%mdto.getId(); %><br/>
		비밀번호: <input type="text" name="pw" size="20"><br/>
		비밀번호 확인: <input type="text" name="pw_confirm" size="20"><br/>
		이름: <input type="text" name="name" size="20" value="<%= mdto.getName() %>" ><br/>
		메일: <input type="text"	name="email" size="20" value="<%= mdto.getEmail() %>" ><br/>	
		주소: <input type="text"	name="adress" size="50" value="<%= mdto.getAddress() %>" ><br/>	
		<input type="button" value="회원가입" onclick="updateInfo()"> / <input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>