<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

	<script type="text/javascript">
		function searchBbs(){
			var choice = document.getElementById("choice").value;
			var word = document.getElementById("searchword").value;
			
			location.href = "list.jsp?searchWord=" + searchword + "&choice=" + choice;
		}
	</script>
	
<body>
	<select id="choice">
		<option value="sel">선택</option>
		<option value="title">제목</option>
		<option value="writer">작성자</option>
		<option value="content">내용</option>
	</select>
	<br>
	<input type="text" id="search" value="${searchword}">
	<button onclick="searchBbs()">검색</button>
	

<center>
	<hr width="500" color="blue" size="1" />
	<h3> 리스트</h3>
	<hr width="500" color="blue" size="1" />
	
  <table width="800" cellpadding="0" cellspacing="0" border=1>
  	<!-- 제목 -->
  	<tr>
  		<td align="center" width=100>번호</td>
  		<td align="center">이름</td>
  		<td align="center" width=350>제목</td>
  		<td align="center">날짜</td>
  		<td align="center">조회</td>  		
  	</tr>
  	<c:forEach items="${list}"  var="dto"> 
  	<tr>
  		<td>${dto.bId}</td>
  		<td>${dto.bName}</td>
  		<td>
  		    <c:forEach begin ="1" end="${dto.bIndent}">ㄴ</c:forEach>
  			<a href ="view.do?bId=${dto.bId}">${dto.bTitle}</a>
  		</td>
  		<td>${dto.bDate}</td>
  		<td>${dto.bHit}</td>
  	</tr> 
  	</c:forEach> 	
  	<tr>
  		<td colspan="5" align="right"><a href="write_view.do">글쓰기</a></td>
  	</tr>
  </table>
</center>

</body>
</html>