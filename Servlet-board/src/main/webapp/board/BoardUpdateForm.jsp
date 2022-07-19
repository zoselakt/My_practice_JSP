<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">        
function changeView()        
{           
	location.href='BoardListAction.bo?page=${pageNum}';        
	}    
</script>
</head>
<body>
<b><font size="6" color="gray">글 수정</font></b>
<form action="BoardUpdateAction.bo?page=${pageNum }" method="post" name="boardForm" enctyp="multipart/form=data">
	<input type="hidden" name="board_num" value="${vo.board_num }"/>
	<input type="hidden" name="existing" value="${vo.board_file }"/>
	
	<table width="700" align="center">
		<tr>
			<td id="title">작성자</td>
			<td>${vo.board_id }</td>
		</tr>
		<tr>
			<td id="title">제목</td>
			<td><input name="board_subject" type="text" size="70" maxlength="100" value="${vo.board_subject }"/></td>
		</tr>		
		<tr>
			<td id="title">내용</td>
			<td><textarea rows="20" cols="72" name="board_content">${vo.board_content}</textarea></td>
		</tr>	
		<c:if test="${vo.board_parent == 0 }">
			<tr>
				<td id="title">기존파일</td>
				<td>&nbsp;&nbsp; ${vo.board_file }</td>
			</tr>
			<tr>
				<td id="title">첨부파일</td>
				<td><input type="submit" name="board_file"/></td>
			</tr>
		</c:if>
		<tr align="center" valign="middle">
			<td colspan="5">
				<input type="reset" name="취소"/>
				<input type="submit" name="수정"/>
				<input type="button" name="목록" onclick="changeView()"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>