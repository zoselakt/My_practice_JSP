<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.ex.dao.*"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select id="choice">
		<option value="sel">선택</option>
		<option value="title">제목</option>
		<option value="writer">작성자</option>
		<option value="content">내용</option>
	</select>
	<br>
	<input type="text" id="search" value="${dao.searchword }">
	<button onclick="searchBbs()">검색</button>
	
	<script type="text/javascript">
		function searchBbs(){
			var choice = document.getElementById("choice").value;
			var word = document.getElementById("search").value;
			
			location.href = "list.jsp?searchWord=" + word + "&choice=" + choice;
		}
	</script>
</body>
</html>