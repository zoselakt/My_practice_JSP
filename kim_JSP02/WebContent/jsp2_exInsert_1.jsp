<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 작성 두번째 -->
    <%@page import = "java.sql.*" %>
    
    <%
    	//입력한 값을 받아오기
    	String hakbun = request.getParameter("no");
	   String pw = request.getParameter("pw");
 	   String name = request.getParameter("name");
 	   String hp = request.getParameter("hp");
    
 	   out.println("학번: "+hakbun+"비밀번호"+pw+"이름"+name+"전화번호"+hp);
 	   
 	   //유효성체크
 	   if(hakbun == null || pw == null || name == null || hp == null ||
 	   hakbun.trim().equals("") || pw.trim().equals("") || name.trim().equals("") || hp.trim().equals("")){
 		%>
 		<script type="text/javascript">
 			alert("값을 넣어야 합니다.");
 			history.back(); 
 		</script>
 		<% 
 	   }   
 	   
 	   // 데이터베이스 연동
 	   Class.forName("oracle.jdbc.driver.OracleDriver");
 	   String url = "jdbc:orcle:thin@localhost:1521:XE";
 	   String uid = "scott", pwd = "hr";
 	   
 	   Connection dbconn = DriverManager.getConnection(url, uid, pwd); // DriverManager 임포트
 	   out.println("db연결완료"+dbconn);
 	   
 	   String sql = "insert into student values(?,?,?,?)";
 	   PreparedStatement ps = dbconn.prepareStatement(sql);
 	   ps.setString(1, hakbun);
 	   ps.setString(2, pw);
 	   ps.setString(3, name);
 	   ps.setString(4, hp);
 	   
 	   int n = ps.executeUpdate();
 	   if(n>0){
 		   %>
 		   <script type="text/javascript">
 		   alert("학생등록완료");
 		   location.href = "jsp2_exList_1.jsp";
 		  </script>
 		   <%
 	   }else{
 		   %>
 		   <script type="text/javascript">
 		   alert("학생등록실패");
 		   location.href = "jsp2_exStudent_1.jsp";
 		  </script>
 		   <%
 	   }
 	   //resource 반납
 	   ps.close(); dbconn.close();
    %>
    