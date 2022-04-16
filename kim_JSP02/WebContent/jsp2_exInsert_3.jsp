<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
    <jsp:useBean id="stuDTO" class="com.test.ex.StudentDTO"/>
    <!-- Insert 중복내용 DTO활용 작성 -->
    
    <!-- 사용자 입력값 받아오기 -->
    <<jsp:setProperty property="hakbun" name="stuDTO"/>
    <<jsp:setProperty property="pw" name="stuDTO"/>
    <<jsp:setProperty property="name" name="stuDTO"/>
    <<jsp:setProperty property="hp" name="stuDTO"/>
    
    <!-- 객체생성 = 사용자입력값+유효성검사-->
    <jsp:useBean id="stu" class="com.test.ex.StudentDAO"/>
    
    <!-- 등록처리 -->
<%
    int res = stu.insertStudent(stuDTO);

	if(res>0) out.println("등록처리되었습니다.");
	else out.println("등록오류");
%>
    