<%@ page import="com.varxyz.jv300.mod010.InitializeDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<String> nameList = new ArrayList<>();  %>
	<form method="get">
		<c:forEach var="contentList" items="${contentList}">
			<c:forEach var="contentLists" items="${contentList}">
				<p><c:out value="${contentLists}"/> <p>
			</c:forEach>
		</c:forEach>
	</form>
</body>
</html>