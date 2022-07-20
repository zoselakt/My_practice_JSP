<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>방명록</h2>
<hr>
<div id="wrap">
	<div id="writeGestForm">
		<form action="inputform" method="post" value="ins">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="guestbook_name"></td>
					<td>비밀번호</td>
					<td><input type="text" name="guestbook_name"></td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
					<td colspan="4"><textarea rows="7" cols="80"></textarea></td>
				</tr>
			</table>
		</form>
		<br>
		<input type="submit" value="등록">
	</div>
</div>
<br><br>
<div id="listGuestForm">
	<form method="post" name="listform">
		<input type="hidden" name="pro">
		<div id="comment">
			<hr>
			<label>이름</label>&nbsp;&nbsp;&nbsp;
			<label>날짜</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">[답변]</a>&nbsp;
			<a href="#">[수정]</a>&nbsp;
			<a href="#">[삭제]</a><br>
			<hr>
		</div>
	</form>
</div>
</body>
</html>

<script type="text/javascript">        
function checkValue(){            
	if(!document.gestbookInfo.guestbook_id.value){                
		alert("이름을 입력하세요.");                
		return false;            
	}                        
	if(!document.gestbookInfo.guestbook_password.value){                
		alert("비밀번호를 입력하세요.");                
		return false;            
	}                        
	if(!document.gestbookInfo.guestbook_content.value){                
		alert("내용을 입력하세요.");                
		return false;            
	}        
}        
</script>
