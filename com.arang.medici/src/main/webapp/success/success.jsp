 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
    <jsp:useBean id="dao" class="jv300.mod001.dao.MemberDao"/>
    <jsp:useBean id="vo" class="jv300.mod001.vo.MemberVo"/>
	<%
	String id = (String)request.getAttribute("id");
	String passwd = (String)request.getAttribute("passwd");
	String userId = (String)request.getAttribute("userId");
	String ssn = (String)request.getAttribute("ssn");
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보확인</h2>

	아이디 : ${vo.id }<br>
	패스워드 : ${vo.password }<br>
	이름 : ${vo.name }<br>
	주민번호 : ${vo.ssn }<br>
	이메일1 : ${vo.email1 }<br>
	이메일2 : ${vo.email2 }<br>
	주소1 : ${vo.addr1 }<br>
	주소2 : ${vo.addr2 }
	
	<h3>아이디: <%=vo.getId() %></h3>
	<h3>패스워드: <%=vo.getPassword() %></h3>
	<h3>이름: <%=vo.getName() %></h3>
	<h3>주민번호: <%vo.setSsn(ssn); %></h3>
	<h3>이메일1: <%vo.getEmail1(); %></h3>
	<h3>이메일2: <%vo.getEmail2(); %></h3>
	<h3>주소1: <%vo.getAddr1(); %></h3>
	<h3>주소2: <%vo.getAddr2(); %></h3>
	
	아이디: <jsp:getProperty property="id" name="vo"/><br>
	패스워드: <jsp:getProperty property="password" name="vo"/><br>
	이름: <jsp:getProperty property="name" name="vo"/><br>
	주민번호: <jsp:getProperty property="id" name="vo"/><br>
	이메일1: <jsp:getProperty property="id" name="vo"/><br>
	이메일2:<jsp:getProperty property="id" name="vo"/><br>
	주소1: <jsp:getProperty property="id" name="vo"/><br>
	주소2: <jsp:getProperty property="id" name="vo"/><br>
	<br>
	
	<form action="login.jsp" method="get">
		<input type="submit" value="확인">
	</form>
</body>
</html>