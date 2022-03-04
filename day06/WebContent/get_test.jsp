<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get 방식의 요청</title>
</head>
<body>
	<%
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		
		if(city == null || zipcode ==null){
			response.sendRedirect("post_test.jsp");
		}else{
	%>
	<h1>GET 방식요청</h1>
	<form>
		<input type="text" value="seoul" name="city" readonly>
		<input type="text" value="12355" name="zipcode" readonly>
		<button>GET방식으로 보내기</button>
	</form>
	
	<p>
		<%=city %>
		<%=zipcode %>
	</p>
	<%} %>
</body>
</html>