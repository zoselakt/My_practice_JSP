<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
<html>
<body>

	<!-- 강사작성 첫번째 파일 -->
	<!-- 자바 빈 사용 안한 파일 -->
	
<center>
<!-- 학생등록 -->
		<hr width="500">
		<h2>학생등록하기</h2>
		<hr width="500">
		
		<form action="insert.jsp">
		학번: <input type="text" name="no"/><br/>
		비밀번호: <input type="text" name="no"/><br/>
		이름: <input type="text" name="no"/><br/>
		전화번호: <input type="text" name="no"/><br/>
		
		<input type="submit" value="등록">&nbsp;<input type="reset" value="취소">
		</form>
<!-------------------------------------------------------------------------- -->
<!-- 학생검색 -->
		<hr width="500">
		<h2>학생검색하기</h2>
		<hr width="500">
		
		<form action="find.jsp">
		이름:<input type="text" name="name"/>
		<input type="submit" value="검색">
		</form>
<!-------------------------------------------------------------------------- -->
<!-- 학생삭제 -->
		<hr width="500">
		<h2>학생삭제하기</h2>
		<hr width="500">
		
		<form action="delete.jsp">
		이름:<input type="text" name="name"/>
		<input type="submit" value="삭제">
	
		</form>
<!-------------------------------------------------------------------------- -->
<!-- 학생목록 -->
		<hr width="500">
		<h2>학생삭제하기</h2>
		<hr width="500">
		
		<a href="list.jsp">리스트</a>	
</center>

</body>
</html>