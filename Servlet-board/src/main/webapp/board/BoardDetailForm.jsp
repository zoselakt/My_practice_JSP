<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">        
#wrap {width: 800px; margin: 0 auto 0 auto;}
#detailBoard{text-align :center; }
#title{height : 16; font-family :'돋움'; font-size : 12; text-align :center;}    
</style>
</head>
<body>
	<div id="wrap">
		<br><br>
		<div id="board">
			<table id="detailBoard" width="800" border="3">
				<tr>
					<td id="title">작성일</td>
					<td>${vo.board_date }</td>
				</tr>
				<tr>
					<td id="title">작성자</td>
					<td>${vo.board_id}</td>
				</tr>
				<tr>
					<td id="title">제목</td>
					<td>${vo.board_subject}</td>
				</tr>
				<tr>
					<td id="title">내용</td>
					<td>${vo.board_content}</td>
				</tr>
				<tr>
					<td id="title">첨부파일</td>
					<td><a href="FileDownloadAction.bo?file_name=${vo.board_file}">${vo.board_file }</a></td>
				</tr>
				<tr align="center" valign="middle">
					<td colspan="5">
					<c:if test="${sessionScope.sessionID != null }">
						<c:if test="${sessionScope.sessionID == vo.board_id }">
							<input type="button" value="수정" onclick="doAction(0)">
							<input type="button" value="삭제" onclick="doAction(1)">
						</c:if>
						<input type="button" value="답글" onclick="changeView(1)">
					</c:if>
					<input type="button" value="목록" onclick="changeView(0)">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div>
		<table border="1">
			<c:if test="${requestScope.commentList != null}">
				<c:forEach var="comment" items="${requestScope.commentList}">
					<tr>
						<td>
							<div>
								${comment.comment_id}<br>
								<h2>${comment.comment_date }</h2>
							</div>
						</td>
						<td width="550">
							<div class="text_wrapper">
								${comment.comment_content}
							</div>
						</td>
						<td>
							<div>
								<a href="#">[답변]</a><br>
								<c:if test="${comment.comment_id == sessionScope.sessionID}">
									<a href="#">[수정]</a><br>
									<a href="#">[삭제]</a>
								</c:if>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.sessionID != null}">
				<tr>
					<form id="writeCommentForm">
						<input type="hidden" name="comment_board" value="${board.board_num }">
						<input type="hidden" name="comment_id" value="${sessionScope.sessionID}">
						<td>
							<div>
								${sessionScope.sessionID }
							</div>
						</td>
						<td>
							<div>
								<textarea rows="4" cols="70" name="comment_content"></textarea>
							</div>
						</td>
						<td>
							<div>
								<p><a href="#" onclick="writeCmt()">[댓글등록]</a></p>
							</div>
						</td>
					</form>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>
<script type="text/javascript">        
function changeView(value){            
	if(value == 0){
		location.href='BoardListAction.bo?page=${pageNum}';            
	}else if(value == 1){
	location.href='BoardReplyFormAction.bo?num=${board.board_num}&page=${pageNum}';        
	}                
}                
function doAction(value){            
	if(value == 0) // 수정                
	location.href="BoardUpdateFormAction.bo?num=${board.board_num}&page=${pageNum}";            
	else if(value == 1) // 삭제                
	location.href="BoardDeleteAction.bo?num=${board.board_num}";        
	}                 
	var httpRequest = null;                
	// httpRequest 객체 생성        
	function getXMLHttpRequest(){           
	var httpRequest = null;                    
	if(window.ActiveXObject){                
		try{                    
			httpRequest = new ActiveXObject("Msxml2.XMLHTTP");                    
		} catch(e) {                    
			try{                        
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");                    
			} catch (e2) { httpRequest = null; }                
		}            
	}else if(window.XMLHttpRequest){                
		httpRequest = new window.XMLHttpRequest();            
	}            
	return httpRequest;            
}                
// 댓글 등록        
function writeCmt(){            
	var form = document.getElementById("writeCommentForm"); 
	var board = form.comment_board.value            
	var id = form.comment_id.value            
	var content = form.comment_content.value;                        
	if(!content){                
		alert("내용을 입력하세요.");                
		return false;            
	}else{                    
		var param="comment_board="+board+"&comment_id="+id+"&comment_content="+content;            
		httpRequest = getXMLHttpRequest();               
		httpRequest.onreadystatechange = checkFunc;                
		httpRequest.open("POST", "CommentWriteAction.co", true);            
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR');                 
		httpRequest.send(param);            
	}       
}                
function checkFunc(){            
	if(httpRequest.readyState == 4){                
		// 결과값을 가져온다.                
		var resultText = httpRequest.responseText;                
		if(resultText == 1){                     
			document.location.reload(); // 상세보기 창 새로고침                
		}            
	}        
}        
</script>
