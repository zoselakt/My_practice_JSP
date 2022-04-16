<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
    <!-- 강사작성 다섯번째 -->
    
    
     <%@page import = "java.sql.*" %>
     
     <%
     	//삭제할 사람의 이름을 불러온다.
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
	   
	   String sql ="delete from student where name=?"; //동일한 이름의 수 가져오는 sql
	   
	   PreparedStatement ps= dbconn.prepareStatement(sql);
	   ps.setString(1, name);
	      
	   int n = ps.executeUpdate();

		//삭제된결과처리
		String str = "삭제되었습니다.";
		String backUrl = "jsp2_exStudent_1.jsp";
		
		if(n>0){
			str += "처리되었습니다.";
			backUrl = "list.jsp";
		}else{
			str += "처리하고자 하는 학생이 존재하지 않습니다.";
		}
    %>
    <script type="text/javascript">
    	alert("<%=str%>");
    	location.href = "<%=backUrl%>";
    </script>
<%
if(ps != null) ps.close();
if(dbconn != null) dbconn.close();
%>