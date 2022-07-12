<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP 테스트</title>
</head>
<body>
<%
	// context 인터페이스는 서버에 있는 컨텍스트 패스를 얻는 것이다. 
	// 서버가 구동되면 이미 DBCP는 만들어졌기때문에 가져다가 쓰면된다.
	// Context의 lookup() 메소드를 사용하기 위해서 InitialContext() 클래스로 대입을 해준다. 
	Context context = new InitialContext();
	DataSource dataSource = (DataSource) context.lookup("java:comp/env/" + "jdbc/myOracle"); //기존경로 + context.xml의 name값
	Connection conn = dataSource.getConnection(); // datasource 내에는 getConnection객체가있다.	
	System.out.println("연동완료");
%>
</body>
</html>