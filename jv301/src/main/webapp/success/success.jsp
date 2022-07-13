<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.varxyz.jv300.mod011.AddUserServlet" scope="request"/>
	아이디 : <jsp:getProperty name="user" property="id"/>
	패스워드 : <jsp:getProperty name="password" property="password"/>
	이름 : <jsp:getProperty name="name" property="name"/>
	주민번호 : <jsp:getProperty name="ssn" property="ssn"/>
	이메일1 : <jsp:getProperty name="email1" property="email1"/>
	이메일2 : <jsp:getProperty name="email2" property="email2"/>
	주소1 : <jsp:getProperty name="addr1" property="addr1"/>
	주소2 : <jsp:getProperty name="addr2" property="addr2"/>
</body>
</html>