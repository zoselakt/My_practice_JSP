<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.jsp" method="get">
		<ul>
			<li> 회원 아이디: <input type="text" name="id"> <input type="button" value="중복검사" name=""></li>
			<li> 비밀번호:   <input type="password" name="password"> <input type="button" value="비밀번호 확인" name=""></li>
			<li> 이름:      <input type="text" name="name"></li>
			<li> 주민번호:   <input type="text" name="ssn"></li>
			<li> 이메일1:    <input type="email" name="email1"> <input type="button" value="이메일확인" name=""></li>
			<li> 이메일2:    <input type="text" name="email2"></li>
			<li> 주소1:    <input type="text" name="addr1"></li>
			<li> 주소2:    <input type="text" name="addr2"></li>
		</ul>
		<br><br>
		<ul style="text-decoration: none;">
			<li> 관심분야 선택</li>
			<li>java<input type="checkbox" name="concerns" value="java"></li>
			<li>Servlet-JSP<input type="checkbox" name="concerns" value="Servlet-JSP"></li>
			<li>Spring<input type="checkbox" name="concerns" value="Spring"></li>
			<li>SpringBoot<input type="checkbox" name="concerns" value="SpringBoot"></li>
			<li>JDBC<input type="checkbox" name="concerns" value="JDBC"></li>
			<li>Mybatis<input type="checkbox" name="concerns" value="Mybatis"></li>
			<li>JPA<input type="checkbox" name="concerns" value="JPA"></li>
		</ul>
		
		<li> 
		지역선택: <select name="location" style="text-decoration: none;"> 
			<optgroup label="지역선택">
				<option value="deagu">deagu</option>
				<option value="seoul">seoul</option>
				<option value="pohang">pohang</option>
				<option value="gumi">gumi</option>
				<option value="pusan">pusan</option>
				<option value="ulsan">ulsan</option>
				<option value="jeju">jeju</option>
			</optgroup>	
			</select>
		</li> 
			
		<br>
		<input type="submit" name="확인">
	</form>
</body>
</html>