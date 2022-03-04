<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수정, 삭제</title>
</head>
<body>
	<%
		String cookie_check = request.getHeader("Cookie");
		if(cookie_check != null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("id")){
					%>
					<p>아이디: <%=cookie.getValue() %></p>
					<%
				}
			}
			for(Cookie cookie: cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	%>
	<a href="delete_check.jsp">쿠키 삭제 확인</a>
</body>
</html>