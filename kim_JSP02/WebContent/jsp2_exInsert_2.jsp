<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- DTO,DAO 파일작성후 첫번째 작성 -->
    <!-- 자바빈 적용 파일 -->
    <jsp:useBean id="stu" class="com.test.ex.StudentDAO"/>
    <%
    	//사용자 입력값 얻어오기
    	String hakbun = request.getParameter("no");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	String hp = request.getParameter("hp");
    	
  	   //유효성체크
  	   if(hakbun == null || pw == null || name == null || hp == null ||
  	   hakbun.trim().equals("") || pw.trim().equals("") || name.trim().equals("") || hp.trim().equals("")){
  		   response.sendRedirect("jsp2_exStudent_1.jsp");
  		   return;
  	   }
  	   int result = stu.insertStudent(hakbun, pw, name, hp);
  	   String msg="", url="";
  	   if(result>0){
  		   msg = "학생등록완료";
  		   url = "jsp2_exList_2.jsp";
  	   }else{
  		   msg = "학생등록완료";
  		   url = "jsp2_exList_2.jsp";
  	   }
    %>
    <!-- 자바빈을 이용하여 만들었으나 사용자입력값, 유효성체크부분은 중복되어 작성되어있기떄문에 DTO객체를 만들어 내용을 줄일수있다.
    Insert_3에서 DTO객체를 만드는 작업진행-->
    
<script type="text/javascript">
	alert("<%=msg%>;")
	location.href = "<%=url%>";
</script>