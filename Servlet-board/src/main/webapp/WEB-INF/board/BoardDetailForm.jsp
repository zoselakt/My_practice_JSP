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
							<input type="button" value="수정">
							<input type="button" value="삭제">
						</c:if>
						<input type="button" value="답글" onclick="changeView(1)">
					</c:if>
					<input type="button" value="목록" onclick="goboard()">
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
function goboard{location.href="BoardListAction.bo?page=${pageNum}";}
function changeView(value){if(value==0) location.href="BoardListAction.bo?page=${pageNum}"; else if(value ==1) location.href="BoardReplyFormAction.bo?num=${vo.board_num}&page=${pageNum}"}
</script>