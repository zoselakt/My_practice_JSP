<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">        
#wrap {            
width: 700px;            
margin: 0 auto 0 auto;        
}                
#comment{            
text-align :left;        
}                
#listGuestForm{            
text-align :center;            
overflow:scroll;             
overflow-x:hidden;             
height:220px;        
}                
#writeGuestForm, #pageForm{            
text-align :center;        
}    
</style>
</head>
<body>
<h2>방명록</h2>
<hr>
<div id="wrap">
	<div id="writeGestForm">
		<form action="guestbookInfo" method="post" value="GuestbookWriteAction.ge" onsubmit="return checkValue()">
			<table width="700">
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
		</form>
		<br>
		<input type="submit" value="등록">
	</div>
</div>
<br><br>
<div id="listGuestForm">
	<form method="post" name="">
		<div id="comment">
			<c:forEach var="guestbook" items="${requestScope.list}">
				<hr>
				<c:if test="${guestbook.guestbook_level > 1}">
					<c:forEach begin="1" end="${guestbook.guestbook_level}">
					&nbsp;&nbsp;
					</c:forEach>
				</c:if>
				<label>${guestbook.guestbook_id}</label>&nbsp;&nbsp;
				<label>${guestbook.guestbook_date}</label>&nbsp;&nbsp;
				<a href="#" onclick="openReplyForm(${guestbook.guestbook_no})">[답변]</a>&nbsp;
				<a href="#">[수정]</a>&nbsp;
				<a href="#" onclick="openDelForm(${guestbook.guestbook_no})">[삭제]</a><br>
				${guestbook.guestbook_content }<br>
			</c:forEach>
				<hr>
		</div>
		<div id="pageForm">
			<c:if test="${startPage != 1 }">
				<a href="GuestbookListAction.ge?page=${startPage -1}">[이전]</a>
			</c:if>
			<c:forEach var="pageNum" begin="${startPage }" end="${endPage }">
				<c:if test="${pageNum == spage }">
					${pageNum }
				</c:if>
				<c:if test="${pageNum != spage }">
					<a href="GuestbookListAction.ge?page=${pageNum}">${pageNum }</a>
				</c:if>
			</c:forEach>
			<c:if test="${endPage != maxPage }">
				<a href="GuestbookListAction.ge?page=${endPage +1}">[다음]</a>
			</c:if>
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
function openReplyForm(guestbook_no){
	window.name = "replyForm";
	window.open("GuestbookReplyFormAction.ge?num="+guestbook_no+"$page=${spage}",
			"rForm", "width=570, height=350, resizable = no, scrollbars=no");
}
function openDelForm(guestbook_no) {
	window.name = "parentForm";
	window.open("GuestbookDeleteFormAction.ge?num="+guestbook_no, "delForm",
			"width=570, height=350 resizable = no, scrollbars = no"); 
}
function openUpdateForm(guestbook_no) {
	window.name = "parentForm";
	window.open("GuestbookUpdateFormAction.ge?num="+guestbook_no+"$page=${spage}",
			"updForm", "width=570, height=350, resizable = no, scrollbars=no");
}
</script>
