<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
 <jsp:useBean id="stu" class="com.test.ex.StudentDAO"/>
    <!-- DTO객체를 이용하여 DB연동과 jsp파일재정의 -->
    <!-- 자바빈 사용파일 -->
     
     <%
     	//삭제할 사람의 이름을 불러온다.
     	String name = request.getParameter("name");
     
    	//유효성체크
    	if(name == null || name.trim().equals("")){
    		response.sendRedirect("jsp2_exStudent_2.jsp");
    		return;
    	}
    	//DAO 삭제를 위한 메소드 호출
    	int result = stu.delStudent(name.trim());
    	
    	String str = "", url="student_2.jsp";
    	if(result > 0){
    		str = "삭제처리되었습니다.";
    		url = "jsp2_exList_2.jsp";
    	}else{
    		str = "처리하고자 하는 학생이 존재하지 않습니다.";
    	}
    %>
    <script type="text/javascript">
    	alert("<%=str%>");
    	location.href = "<%=url%>";
    </script>
	