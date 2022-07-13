<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%! 
 	private static final String DEFAULT_NAME = "world";
/* 
	doGet의 범위밖에서 사용되는코드는 어떤 방식으로 불러오는지...
	여기에 추가된 코드는 최상단에 있어서 실행되는것이아니다. 
*/
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello JSP!</title>
</head>
<body>
<%
	String name = request.getParameter("userName");
	if(name == null || name.length() == 0){
		name = DEFAULT_NAME;
	}
%>
<h3> hello, <%=name %></h3>
</body>
</html>