<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <%--  
데이터 베이스 연동순서
 1. JDBC 드라이버 로딩: Class.forName(""oracle.jdbc.driver.OracleDriver");
 2. 데이터 베이스 연결(Connection 객체 생성): DriverManager.getConnection();
 3. SQL문 실행(Statement 객체 생성): connection.createStatement();
	관련메소드
	- executeQuery(): 쿼리문을 사용할 때 결과 값이(ResultSet) 생긴다. (select)
	- executeUpdate(): 테이블의 내용을 수정, 삭제, 삽입할 때 사용(insert, update, delete)
 4. 데이터베이스 연결해제: ResultSet객체로부터 데이터 추출, Resultset Close
	
강사작성 데이터베이스 관리툴과의 연동방법 / 자바 빈 사용 이전
	1. 데이터베이스에 sql문 작성
	2. 첫번쨰 jsp 파일에 sql문 name을 html형식으로 작성 / 화면을 띄울 jsp파일에 태그로 연결
	3. 두번째 jsp 파일생성 후 입력한 값 받아오기
	4. 유효성 체크(if문으로 null인 경우, 공백입력시 처리 {if(name==null || pw == null || name.trim().equals("")...)} → 자바스크립트로 경고창 생성
	5. 두번째 jsp 데이터베이스 연동 
		- class.forName("orcla.jdbc.driver.OracleDriver");
		- String url = "jdbc:oracle:thin@localhost:1521:XE"; )
		- String uid ="hr", pwd = "hr"; )
	    - Connection 객체 생성(Connection dbconn = DriverManager.getConnection(url, uid, pwd);)
	    - sql쿼리문 생성 (String sql = "insert into student values(?,?,?,?)";
	   
	6.PreparedStatement 객체 생성(Statement객체도 있지만 성능이 보다 낮다)
		- PreparedStatement 객체명(ps) = dbconn.preparedStatement(5번의 쿼리문 네임(sql);
		- ps.setString(데이터베이스sql문과 일치하게 여러개 작성);
		  ps.setString(데이터베이스sql문과 일치하게 여러개 작성);
		  ...
		- int n = ps.executeUpdate(); 
	7. preparStatement메소드 리턴값 0인경우 리턴값이 없다. / 0보다 큰값은 insert, update, delete한 row수를 리턴
		- if( n > 0 ){
		  <script type="text/javascrupt"> alert("학생등록"); location.href="list(세번째jsp).jsp </script>
		  } else {
		  <script type="text/javascrupt"> alert("학생등록실패"); location.href="student1.jsp </script>
		  }
	8. resource 반납 / 닫아주기
		- ps.close(); / dbconn.close();
		
	9.list(3번째 jsp)에 5번, 6번과 동일하게 작성한다. / 6번마지막int n 대신 ResultSet rs = ps.executeQuery();로 써준다
	10. html태그로 jsp파일을 작성한다.
	11. if문 작성하여 닫아준다.(if rs != null) rs.close(); / if(ps != null) ps.close / if(dbconn != null) dbconn.close();
	
	검색하기 만들기
	1. jsp파일을 만든뒤 입력값(String name = getParameter("name"))과 유효성체크(if문3번 조건(null)+내용(response.sendRedirect("1번jsp"); )
		, 데이터베이스연결 값을 작성한다.(5번, 6번내용)
	2. ResultSet rs = ps.executeQuery(9번), rs.next(); 작성
	3. int cnt = rs.getInt(1); // 1은 필드의 순서를 의미한다. 1부터 시작 / 데이터타입이 문자열이면 getString, 숫자형 getInt메소드를 이용한다.
	4. rs.close(); / ps.close();
	5. html 태그와 jsp문 작성하여 페이지를 만든다.
		 
	삭제하기 만들기
	1. 위 와 동일하게 진행한다.
	2. String sql = "delete from student where name=?"; 작성
	3. PreparedStatement ps = dbconn.prepareStatement(sql); / ps.setString(1, name); 작성 
	4. int n = ps.executeUpdate();
	5. 삭제된 결과를 처리하는 String str = "삭제되었습니다"; 메세지 출력
	6. String backUrl = "student 1.jsp"; 로 값을 전송한다.
	7. if문으로 결과값을 처리한다. (if(n>0){str+="처리되었습니다.";backUrl="list.jsp";}{else{str += "존재하지 않습니다.";}
	8. 자바스크립트 이용하여 결과값(alert)을 출력한다./ location.href="<%=backUrl%>"
	9. 전체 close한다.  if(ps != null) ps.close(); / if(dbconn != null) dbconn.close();
	--%> -->
</body>
</html>