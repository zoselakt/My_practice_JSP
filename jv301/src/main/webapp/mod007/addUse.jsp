<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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
			<ul>
			<%
				@SuppressWarnings("unchecked")
				List<String> errorMsgs = (List<String>) request.getAttribute("errorMsgs");
				for(String errorMsg : errorMsgs){
			%>
					<li><%=errorMsg %></li>
			<%
				}
			%>
			</ul>
		</div>
		<div id="footer">
			<%@ include file="/mod007incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>