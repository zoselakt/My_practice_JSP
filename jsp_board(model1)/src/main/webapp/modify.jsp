<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="jsp_board.vo.MemberVo"%>
	<%@ page import="jsp_board.dao.MemberDao"%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("memberid");
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = dao.getMember(id);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 수정</h2>
	<hr>
	<form action="modify_ok.jsp" method="post" name="modify_frm">
		<p> 아이디:  <% vo.getMemberid(); %></p><br>
		<p> 비밀번호: <input type="text" name="password" size="20" value="<% vo.getPassword(); %>"></p><br>
		<p> 이름: <input type="text" name="name" size="20" value="<% vo.getName(); %>"></p><br>
		<p> 전화번호: <input type="text" name="phone" size="15" value="<% vo.getPhone(); %>"></p><br>
		<p> 주소: <input type="text" 	name="addr" size="20" value="<% vo.getAddr();%>"></p><br>	
		<p> 상세주소: <input type="text" name="addr2" size="20" value="<% vo.getAddr2(); %>"></p><br>
		<p> 성별: <input type="text" name="gender" size="10" value="<% vo.getGender(); %>"></p><br>
		<input type="submit" value="정보수정"> / <input type="reset" value="취소" onclick="javascript:window.location='main.jsp'"> 
	</form>
</body>
</html>