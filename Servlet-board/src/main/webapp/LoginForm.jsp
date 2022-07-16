<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">        
<form name="loginInfo" method="post" action="loginok.jsp" onsubmit="return checkValue()">                    
	<table>
		<tr>
			<td bgcolor="skyblue">아이디</td>
			<td><input type="text" name="id" maxlength="50"></td>
		</tr>
		<tr>
			<td bgcolor="skyblue">비밀번호</td>
			<td><input type="password" name="password" maxlength="50"></td>
		</tr>
	</table>            
	<br>            
	<input type="submit" value="로그인"/>
	<input type="button" value="회원가입" onclick="goJoinForm()"/>       
</form>    
<%--
<%
	String msg=request.getParameter("msg");
	if(msg!=null && msg.equals("0")){
	out.println("<br>");
	out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
	}
	else if(msg!=null && msg.equals("-1")) {
		out.println("<br>");
		out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
	}
%>  다음은 el 과 jstl로 변경한 코드
 --%>            
<c:set var="failMessage" value="${requestScope.fail }"/>
<c:if test="${failMessage != null }">
	<c:choose>
		<c:when test="${failMessage == '0' }">
			<br><font color='red' size='5'>비밀번호를 확인해 주세요</font>
		</c:when>
		<c:otherwise>
			<br><font color='red'>아이디를 확인해 주세요</font>
		</c:otherwise>
	</c:choose>
</c:if>
     
</div>    
</body>
</html>
<script type="text/javascript">
function checkValue(){            
	inputForm = eval("document.loginInfo");            
	if(!inputForm.id.value){                
		alert("아이디를 입력하세요");                    
		inputForm.id.focus();                
		return false;            
	}            
	if(!inputForm.password.value){                
		alert("비밀번호를 입력하세요");                    
		inputForm.password.focus();                
		return false;           
	}        
}           
function goJoinForm() { location.href="JoinForm.jsp";}       
 </script>
