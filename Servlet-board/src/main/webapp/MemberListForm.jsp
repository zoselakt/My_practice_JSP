<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>
    <%@page import="java.util.*" %>
    <%
    	ArrayList<MemberVo> memberList = (ArrayList<MemberVo>)request.getAttribute("memberList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">        
table{            
margin-left:auto;
margin-right:auto;
border:3px solid skyblue;
}
td{
border:1px solid skyblue
}
#title{
background-color:skyblue
}
</style>
</head>
<body>
<h2>전체회원정보</h2>
<table>
	<tr align="center">
		<td id=title>아이디</td>
		<td id=title>비밀번호</td>
		<td id=title>이름</td>
		<td id=title>성별</td>
		<td id=title>생년월일</td>
		<td id=title>이메일</td>
		<td id=title>전화</td>
		<td id=title>주소</td>
		<td id=title>가입일</td>
	</tr>
	<%
		for(MemberVo vo : memberList){
	%>
	<tr>
		<td><%= vo.getId() %></td>
		<td><%= vo.getPassword() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getGender() %></td>
		<td><%= vo.getBirthyy() %></td>
		<td><%= vo.getEmail1() %></td>
		<td><%= vo.getPhone() %></td>
		<td><%= vo.getAddress() %></td>
		<td><%= vo.getReg() %></td>
	</tr>
	<%} %>
</table>
</body>
</html>