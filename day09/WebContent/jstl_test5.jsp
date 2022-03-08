<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 테스트(제어문 실습)</title>
</head>
<body>
	<form action="">
		국어<input type="text" name="kor" value=""><br>
		영어<input type="text" name="eng" value=""><br>
		수학<input type="text" name="math" value=""><br>
		<button>제출</button>
	</form>
	<c:if test="${not empty param.kor}">
		<c:set var="total" value="${param.kor + param.eng + param.math}"/>
		<c:set var="avg" value="${total / 3}"/>
		총점: <c:out value="${total / 3}"/>
		<c:choose>
			<c:when test="${avg >= 60}">
			<strong> 참잘했어요!</strong>
			</c:when>
			
			<c:otherwise>
				<strong>분발해주세요.</strong>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>