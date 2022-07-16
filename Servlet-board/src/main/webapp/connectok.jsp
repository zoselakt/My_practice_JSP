<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@page import="java.sql.*" %>
    <% 
    try{
    String driverName = "oracle.jdbc.driver.OracleDriver";
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    
    Class.forName(driverName);
    Connection con = DriverManager.getConnection(dbURL, "hr", "hr");
    out.print("접속왆료");
    con.close();
    	
    }catch(Exception e){
    	out.println("문제발생");
    	out.println(e.getMessage());
    	e.printStackTrace();
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>