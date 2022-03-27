<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 실습</title>
</head>
<body>
	<!-- 사용자에게 이름을 입력받고 확인버튼을 눌렀을때  admin일 경우 "관리자", member일 경우
	"일반회원000(param객체 사용 작성" , 그 외에는 "비회원"을 출력한다.
	
	현재페이지에서 작성하고 결과는 input태그와 submit버튼이 안나오게 처리
	EL과 JSTL만 사용-->
	
	<c:choose>
		<c:when test="${empty param.name}">
			<form action="">
				<input type="text" name="name">
				<input type="submit" name="확인">
			</form>
		</c:when>
		
		<c:when test="${param.name == 'admin' }">
			<h1> 관리자 </h1>
		</c:when>
				
		<c:when test="${param.name == 'member' }">
			<h1> 일반회원 <c:out value="${param.name}"/></h1>
		</c:when>
				
		<c:otherwise>
			<h1> 비회원 </h1>
		</c:otherwise>
	</c:choose>
	
</body>
</html>