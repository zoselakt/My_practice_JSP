<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body><center>
	<hr width="500" color="blue" size="1" />
	<h3> 리스트</h3>
	<hr width="500" color="blue" size="1" />
	<label>
	<h3> 검색 </h3>
	
	<form method="post" name="search" action="search.jsp">
		<table class="pull-right">
			<tr>
				<td>
					<select class="form-control" name="searchField">
					<option value="0">선택</option>
					<option value="bbsTitle">제목</option>
					<option value="userID">작성자</option>
					</select>
				</td>
				<td>
					<input type="text" class="form-control"	placeholder="검색어 입력" name="searchText" maxlength="100"></td>
					<td><button type="submit" class="btn btn-success">검색</button></td>
			</tr>
		</table>
	</form>
	
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
