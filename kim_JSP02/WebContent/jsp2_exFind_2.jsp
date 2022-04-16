<%@page import="java.sql.*"%>
<%@ page import="com.test.ex.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="stu" class="com.test.ex.StudentDAO"/>
    <!-- DTO객체를 이용하여 DB연동과 jsp파일재정의 -->
    <!-- 자바빈 사용파일 -->
     
     <%
     	//이름값 얻어오기
     	String name = request.getParameter("name");
     
    	//유효성체크
    	if(name == null || name.trim().equals("")){
    		response.sendRedirect("jsp2_exStudent_1.jsp");
    		return;
    	}
    	//DTO객체 불러오기 = db연결
    	StudentDTO arr[] = stu.findSt(name.trim());
    	
    	if(arr == null || arr.length == 0){
    		out.println(name+"은 존재하지 않습니다.");
    		out.println("<br/><a href=student_2.jsp>back</a>");
    		return;
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<body>
<center>
	<a href="jsp2_exStudent_2.jsp">등록</a>
	<a href="jsp2_exfind_2.jsp">검색</a>
	<table width=500 border=1>
		<tr>
			<th width=25%>학번</th>
			<th width=25%>비밀번호</th>
			<th width=25%>이름</th>
			<th width=25%>전화번호</th>
		</tr>
		
		<%
		for(StudentDTO sdto:arr){
		%>
		<tr>
			<td><%= sdto.getHakbun() %></td>
			<td><%= sdto.getPw() %></td>
			<td><%= sdto.getName() %></td>
			<td><%= sdto.getHp() %></td>
		</tr>
		<%
		}
		%>
	</table>
</center>
</body>
</html>