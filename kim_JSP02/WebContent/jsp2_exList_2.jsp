<%@page import="com.test.ex.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <jsp:useBean id="stu" class="com.test.ex.StudentDAO"/>
    <!-- DTO객체를 이용하여 DB연동과 jsp파일재정의 -->
    <!-- 자바빈 사용파일 -->
   <%
   StudentDTO arr[] = stu.select();
   if(arr == null || arr.length == 0){
	   out.println("등록된 학생이 없습니다.");
	   return;
   }
   %>
   
<html>
<body>
	<div align="center">
	<hr width="500">
	<h2>학생 리스트 현황</h2>
	<hr width="500">
	<a href="jsp2_exstudent_2.jsp">등록</a> %nbsp;%nbsp;
	<a href="jsp2_exFind_2.jsp">검색</a>
	</div>
	
	<table width=500 border=1>
		<tr>
			<th width=25%>학번</th>
			<th width=25%>비밀번호</th>
			<th width=25%>이름</th>
			<th width=25%>전화번호</th>
		</tr>
		<%
		for(int i=0; i<arr.length; i++){
			String hakbun2 = arr[i].getHakbun();
			String pw2 = arr[i].getPw();
			String name2 = arr[i].getName();
			String hp2 = arr[i].getHp();
		%>
		<tr>
			<td><%=hakbun2 %></td>
			<td><%=pw2 %></td>
			<td><%=name2 %></td>
			<td><%=hp2 %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>