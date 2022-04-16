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
자바 빈 DTO / DAO
- DAO( Data Access Object ) : DB 데이터 접근을 목적으로하는 객체

//객체생성
	connection 객체명(dbconn); PreparedStatement 객체명(ps); ResultSet 객체명(rs);
	String url = "jdbc:oracle:thin@localhost:1521:XE";
	String uid = "hr", pwd = "hr";
//생성자	
	public 생성자(){
	Class.forName("oracle.jdbc.driver.OracleDriver");
	dbconn = DriverManager.getConnection(url, uid, pwd);
	try / catch문 처리
// 학생등록
	public int insertStudent(StudentDTO객체생성 객체명) throws SQLException
	String hakbun, pw, name, hp = sdto.getHakbun(); getPw(); getName(); getHp(); String 값을 각 객체에 입력한다.
	int n = this.insertStudent( hakbun, pw, name, hp);
	return n;

	public int insertStudent(String hakbun, String ...) throws SQLException	
	try{
	String sql = "insert into student values(?,?,?,?)";
	ps = dbconn.prepareStatement(sql);
	ps.setString(1, hakbun); ...(4.hp);
	int n = ps.executeUpdate();
	return n;
	}finally{
		if(ps != null) ps.close();
		if(dbconn != null) dbconn.close();
//새로운 DAO.jsp 파일생성
1. 사용자 입력값 얻어오기 String hakbun.request.getParameter("no"); ... ("hp"); 
2. 유효성 검사 (if(hakbun == null || ...hakbun.trim().equals("")... hp(...)) {response.sendRedirect("student_2.jsp"); return;
			int result = stu.insertStudent(hakbun ...);
			String msg ="", url="";
			if(result>0){msg="학생등록완료"; url="list.jsp";}
			else{msg="등록실패"; url="student_2.jsp";}
3. 스크립트 alert메세지 띄우기 / location.href="<%=url%>";
			
----------------------------------------------------------------------------------------------			
- DTO( Data Transfer Object ) : 데이터가 포함된 객체를 다른 시스템으로 전달하는 역할을 하는 객체 / DB에 있는 레코드를 객체화한 클래스

//기본생성자 + getter, setter 생성 jsp파일 작성
	
// DAO에서 값 불러와서 처리하기
	1. <jsp:setProperty="hakbun" name="학생등록jsp파일"> / pw, name, hp프로퍼티 모두 작성
	2. <jsp:useBean id="stu class="studentDAO"/>
	3. DAO객체를 변수에 담아 if문에 담아처리 /<% int res=stu.insertStudent(stuDTO) / if(res>0) out.println("등록처리");else out.println("등록오류");%>
	
	
--%> -->
</body>
</html>