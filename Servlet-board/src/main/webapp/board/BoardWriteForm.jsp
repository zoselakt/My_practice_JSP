<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"> 
#title{          
	height : 16;           
	font-family :'돋움';           
	font-size : 12;         
	text-align :center;     
}
</style>
</head>
<body>
	<br>
	<b><font size="6" color="gray">글쓰기</font></b>
	<br>
	<form action="BoardWriteAction.do" method="post" name="boardForm" enctype="multipart/form-data">
		<input type="hidden" name="board_id" value="${sessionScope.sessionID }">
		<table width="700" border="3" align="center">
			<tr>
				<td id="title">작성자</td>
				<td>${sessionScope.sessionID}</td>
			</tr>
			<tr>
				<td id="title">제목</td>
				<td><input name="board_subject" type="text" size="70" maxlength="100" value=""/></td>
			</tr>
			<tr>
				<td id="title">내용</td>
				<td><textarea name="board_content" cols="72" rows="20"></textarea></td>
			</tr>
			<tr>
				<td id="title">파일첨부</td>
				<td><input type="file" name="board_file"/></td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5">
					<input type="reset" value="작성취소">
					<input type="submit" value="등록하기">
					<input type="button" value="목록으로">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>