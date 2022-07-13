<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/mod007incl/banner.jsp">
				<jsp:param value= "<%=URLEncoder.encode(\"mod007: 자바빈즈\",\"UTF-8\")%>" name="subtitle"/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<c:if test="${not empty errorMsgs}">
				<h3>다음과 같은 에러가 발생했습니다.</h3>
				<ul>
					<c:forEach var="msg" items= "${errorMsgs}">
						<li>${msg}</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<div id="footer">
			<%@ include file="/mod007incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>