<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 강사작성 네번째 -->
    
    
     <%@page import = "java.sql.*" %>
     
     <%
     	//이름값 얻어오기
     	String name = request.getParameter("name");
     
    	//유효성체크
    	if(name == null || name.trim().equals("")){
    		response.sendRedirect("jsp2_exStudent_1.jsp");
    		return;
    	}
	   // 데이터베이스 연동
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   String url = "jdbc:orcle:thin@localhost:1521:XE";
	   String uid = "scott", pwd = "hr";
	   
	   Connection dbconn = DriverManager.getConnection(url, uid, pwd); // DriverManager 임포트
	   out.println("db연결완료"+dbconn);
	   
	   String sql ="select count(*) from student where name=?"; //동일한 이름의 수 가져오는 sql
	   String sql2 ="select * from student where name=?"; //이름을 가져오는 sql
	   
	   PreparedStatement ps= dbconn.prepareStatement(sql);
	   ps.setString(1, name);
	   ResultSet rs = ps.executeQuery();
	   rs.next();
	   int cnt = rs.getInt(1); // 1: 필드의 순서
	   rs.close(); ps.close();
	   
	   out.println("<br/>"+cnt+"명");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<a href="jsp2_exStudent_1.jsp">등록</a>
	<a href="jsp2_exStudent_1.jsp">검색</a>
	<table width=500 border=1>
		<tr>
			<th width=25%>학번</th>
			<th width=25%>비밀번호</th>
			<th width=25%>이름</th>
			<th width=25%>전화번호</th>
		</tr>
		<%
		if(cnt>0){
			ps = dbconn.prepareStatement(sql2);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()){
				String hakbun = rs.getString(1);
				String pw = rs.getString(2);
				String name2 = rs.getString(3); // 지역변수로 가져왔기때문에 동일이름 불가하여 name2
				String hp = rs.getString(4);
		%>
			<tr>
				<td><%=hakbun %></td>
				<td><%=pw %></td>
				<td><%=name2 %></td>
				<td><%=hp %></td>
			</tr>
		<%
			}
			out.println("<tr><td colspan=4>");
			out.println(name+"님 은 동명이 전체"+cnt+"명 입니다.");
			out.println("</td></tr>");
		}else{
			out.println("<tr><td colspan=4>");
			out.println(name+"님 은 동명이 존재하지 않습니다.");
			out.println("</td></tr>");
		}
		%>
	</table>
</center>
</body>
</html>


<%
if(rs != null) rs.close();
if(ps != null) ps.close();
if(dbconn != null) dbconn.close();
%>