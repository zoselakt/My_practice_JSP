<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>답글작성</h2>
<form method="post" action="BoardReplyAction.bo?page=${page }"name="boardForm">
	<input type="hidden" name="board_id" value="${sessionScope.sessionID }"/>
	<input type="hidden" name="board_num" value="${vo.board_num}"/>
	<input type="hidden" name="board_re_ref" value="${vo.board_re_ref }"/>
	<input type="hidden" name="board_re_lev" value="${vo.board_re_lef }"/>
	<input type="hidden" name="board_re_seq" value="${vo.board_re_seq }"/>
	<table width="700" border="3" align="center">
		<tr>
			<td id="title">작성자</td>
			<td>${sessionScope.sessionID }</td>
		</tr>
		<tr>
			<td id="title">작성자</td>
			<td><input name="board_subject" type="text" size="70" maxlength="100" value=""/></td>
		</tr>
		<tr>
			<td id="title">내용</td>
			<td><textarea name="board_content" rows="20" cols="72"></textarea></td>
		</tr>
		<tr align="center" valign="middle">
			<td colspan="5">
				<input type="reset" value="작성취소">
				<input type="submit" value="등록">
				<input type="button" value="목록" onclick="javascript:history.go(-1)">
			</td>
		</tr>
	</table>
</form>
</body>
</html>