<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 강사작성 세번째 -->
    <%@page import = "java.sql.*" %>
    <%
	   // 데이터베이스 연동
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   String url = "jdbc:orcle:thin@localhost:1521:XE";
	   String uid = "scott", pwd = "hr";
	   
	   Connection dbconn = DriverManager.getConnection(url, uid, pwd); // DriverManager 임포트
	   out.println("db연결완료"+dbconn);
	   
	   String sql ="select * from student order by hakbun acs";
	   PreparedStatement ps= dbconn.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery();
	   
    %>
   
<html>
<body>
	<div align="center">
	<hr width="500">
	<h2>학생 리스트 현황</h2>
	<hr width="500">
	<a href="jsp2_exstudent_1.jsp">등록</a> %nbsp;%nbsp;
	<a href="jsp2_exFind_1.jsp">검색</a>
	</div>
	<table width=500 border=1>
		<tr>
			<th width=25%>학번</th>
			<th width=25%>비밀번호</th>
			<th width=25%>이름</th>
			<th width=25%>전화번호</th>
		</tr>
		<%
		while(rs.next()){
			String hakbun = rs.getString("no");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String hp = rs.getString("hp");
		%>
		<tr>
			<td><%=hakbun %></td>
			<td><%=pw %></td>
			<td><%=name %></td>
			<td><%=hp %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>

<%
if(rs != null) rs.close();
if(ps != null) ps.close();
if(dbconn != null) dbconn.close();
%>