<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*"%>
	<%
    Connection dbconn;
    Statement stmt;
    ResultSet rs;
    
    String name, id, pw, hp, hp2, hp3, gender;
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	id = (String)session.getAttribute("id");
	// pw = (String)session.getAttribute("pw");
	//String sql = "select * from member where id = '" +id+ "' and pw='"+pw+"'";
	String sql = "select * from member where id = '" +id+ "'";

	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	dbconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
	stmt = dbconn.createStatement();
	rs = stmt.executeQuery(sql);
	
//	while(rs.next()){
		rs.next();
		name = rs.getString("name");
		pw = rs.getString("pw");
		hp = rs.getString("hp");
		hp2 = rs.getString("hp2");
		hp3 = rs.getString("hp3");
		gender = rs.getString("gender");
//	}
%>

<center>
	<h2>회원가입</h2><hr>
	<form action="ModifyOk" method="post">
		이름: <input type="text" name="name" size="20" value= <%=name %> ><br/>
		아이디: <input type="text" name="id" size="20" value= <%=id %>><br/>
		비밀번호: <input type="text" name="pw" size="20"><br/>
		전화번호: <select name="hp">
					<option value="010">010</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
			<input type="text" name="hp2" size="4" value= <%=hp2 %>>-<input type="text" name="hp3" size="4" value=<%=hp3 %>><br/>
		<%
			if(gender.equals("man")){
		%>
		성별: <input type="radio" name="gender" value="남" checked>남<input type="radio" name="gender" value="woman">여<br/>
		<%}else{ %>
		성별: <input type="radio" name="gender" value="남" checked>남<input type="radio" name="gender" value="woman">여<br/>
		<%} %>
		<input type="submit" value="정보수정">%nbsp;<input type="reset" value="취소">
		
	</form>
</center>

</body>
</html>