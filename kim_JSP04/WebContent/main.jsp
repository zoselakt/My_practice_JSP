<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% if(session.getAttribute("chkMember") ==null){ %>
    <jsp:forward page="login.jsp"></jsp:forward>
    <%
    }
    
    String name = (String)session.getAttribute("name");
    String id = (String)session.getAttribute("id");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><%=name %>님 환영합니다. </h2>

<form action="logout.jsp" method="post">
	<input type="submit" value="로그아웃"> / <input type="button" value="정보수정" 
	onclick="javascript:window.location='modify.jsp'">
</form>
</body>
</html>