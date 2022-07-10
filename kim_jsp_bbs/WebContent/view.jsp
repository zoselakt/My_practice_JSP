<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body><center>
	<hr width="500" color="blue" size="1" />
	<h3> 글내용보기</h3>
	<hr width="500" color="blue" size="1" />
	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<form action="modify.do" method="post">
		<input type="hidden" name="bId" value="${view.bId}"/>
			<tr>
				<td>번호</td>
				<td>${view.bId}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${view.bHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${view.bName}"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${view.bTitle}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="80" name="bContent">${view.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정" />&nbsp;&nbsp;<a href="list.do">목록으로</a>
				&nbsp;&nbsp;<a href="delete.do?bId=${view.bId}">삭제</a>&nbsp;&nbsp;<a href="replyView.do?bId=${view.bId}">답변</a></td>
			</tr>
		</form>	
	</table>
	</center>

</body>
</html>