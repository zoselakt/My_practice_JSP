<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">          
#wrap{
	text-align: center;
	width: 800px;
	height: 150px;
}
</style>
</head>
<body>
<h2>admin계정으로 접속하면 회원보기 정보출력 (주석처리)</h2>
	<div id="wrap">
		<p>
		<button class="btn btn-success" onclick="changeView(0)">HOME</button>

		<c:if test="${sessionScope.sessionID == null }">
			<button id="loginBtn" class="btn btn-primary" onclick="changeView(1)">로그인</button>
			<button id="joinBtn" class="btn btn-primary" onclick="changeView(2)">회원가입</button>
		</c:if>

		<c:if test="${sessionScope.sessionID != null}">
			<button id="logoutBtn" class="btn btn-primary" onclick="changeView(3)">로그아웃</button>
			<button id="updateBtn" class="btn btn-primary" >내정보</button>
		</c:if>
		
		<!--<c:if test="${sessionScope.sessionID != null && sessionScope.sessionID == 'admin' }"> </c:if>-->
		<c:if test="${sessionScope.sessionID != null}">
			<button id="memberViewBtn" class="btn btn-warning">회원보기</button>
		</c:if>
		</p>
	</div>
</body>
</html>

<script type="text/javascript">
function changeView(value){
	if(value == "0"){                
		location.href="MainForm.jsp";
	}else if(value == "1"){                
		location.href="loginform.do";
	}else if(value == "2"){                
		location.href="joinForm.do"
	}else if(value == "3"){                
		location.href="MemberLogoutAction.do";
	}else if(value == "4"){
		location.href="MemberInfoAction.do";
	}else if(value == "5"){
		location.href="MemberListAction.do";
	}else if(value == "6"){
		location.href="boardListForm.do";
	}
}    
</script>
