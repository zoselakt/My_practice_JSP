<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">        
#wrap {            
	width: 550px;            
	text-align :center;           
	margin: 0 auto 0 auto;        
}            
#writeReplyForm{            
	text-align :center;        
}    
</style>
</head>
<body>
	<div id="wrap">
		<h2 font-size="5">답글</h2>
		<hr>
		<div id="writeReplyForm">
			<form name="replyInfo" target="replyForm">
				<input type="hidden" name="guestbook_no" value="${guestbook.guestbook_no}"/>
				<input type="hidden" name="guestbook_group" value="${guestbook.guestbook_group}"/>
				<table width="550">
				<tr>
					<td>이름 </td>
					<c:if test=${sessionScope.sessionID != null}">
						<td>${sessionScope.sessionID }<input type="hidden" name="guestbook_id" value=${sessionScope.sessionID}></td>
					</c:if>
					
					<c:if test=${sessionScope.sessionID != null}">
						<td><input type="text" name="guestbook_id"></td>
					</c:if>
					<td>비밀번호</td>
					<td><input type="password" name="guestbook_password"></td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
					<td colspan="4"><textarea rows="7" cols="80"></textarea></td>
				</tr>			
				</table>
				<br>
				<input type="button" value="등록" id="replyInsert" onclick="checkValue()">
				<input type="button" value="창닫기" onclick="window.close()">
			</form>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">        
function checkValue(){            
	var form = document.forms[0];             
	if(!form.guestbook_id.value){                
		alert("이름을 입력하세요.");                
		return false;            
	}            
	else if(!form.guestbook_password.value){                
		alert("비밀번호를 입력하세요.");                
		return false;            
	}            
	else if(!form.guestbook_content.value){                
		alert("내용을 입력하세요.");                
		return false;            
	}            
	else{                
		form.target = opener.name;                
		form.method="post";                
		form.action="GuestbookReplyAction.ge?page=${pageNum}";                
		form.submit();                 
		if (opener != null) {                    
			opener.rForm = null;                    
			self.close();                
		}            
	}        
}    
</script>
