<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>my data</h2><br>
	<jsp:useBean id="user" class="jv300.mod001.vo.MemberVo" scope="request"/>
		<p>아이디 :  <jsp:getProperty property="id" name="user"/><br></p>
		<p>비밀번호 :  <jsp:getProperty property="password" name="user"/><br></p>
		<p>아이디 :  <jsp:getProperty property="name" name="user"/><br></p>
		<p>아이디 :  <jsp:getProperty property="ssn" name="user"/><br></p>
		<p>아이디 :  <jsp:getProperty property="email1" name="user"/><br></p>
		<p>아이디 :  <jsp:getProperty property="email2" name="user"/><br></p>
		<p>아이디 :  <jsp:getProperty property="addr1" name="user"/><br></p>
		<p>아이디 :  <jsp:getProperty property="addr1" name="user"/><br></p>

	<h2>my Page</h>
	<a href="<c:url value="logout.jsp"/>"><button>로그아웃</button></a>
	<a href="<c:url value="findUser"/>"><button>회원정보</button></a>
	<a href="<c:url value="editUser"/>"><button>회원정보수정</button></a>
	<a href="<c:url value="removeUser"/>"><button>회원삭제</button></a>
	<label>Last Access Time : </label> ${lastAccessTime }
</body>
</html>