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
text-align: center;           
margin: 0 auto 0 auto;        
}                
#deleteReplyForm{            
text-align: center;        
}    
</style>
</head>
<body>
	<div id="wrap">
		<h2 font-size="5">삭제</h2>
		<hr>
		<div id="deleteReplyForm">
			<form name="delGuestbook" target="parentForm">
				<input type="hidden" name="guestbook_no" value="${requestScope.guestbook_no}"/>
				비밀번호 : 
				<input type="password" name="guestbook_password" maxlength="50"/><br><br>
				<input type="button" value="삭제" onclick="checkValue()">
				<input type="button" value="창닫기" onclick="window.close()">
			</form>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">            
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
function checkValue(){             
	var form = document.forms[0];            
	var num = form.guestbook_no.value;            
	var pw = form.guestbook_password.value;                        
	if (!form.guestbook_password.value) {                
		alert("비밀번호를 입력하지 않았습니다.");                
		return false;            
	}else{                
		var param="num="+num+"&pw="+pw;                                
		httpRequest = getXMLHttpRequest();                
		httpRequest.onreadystatechange = checkFunc;                
		httpRequest.open("POST", "GuestbookDeleteAction.ge", true);          
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');                 
		httpRequest.send(param);            
		}        
	}                
	function checkFunc(){            
		if(httpRequest.readyState == 4){               
		// 결과값을 가져온다.                
		var resultText = httpRequest.responseText;                
		if(resultText == 0){                    
			alert("비밀번호가 틀립니다.");                
		}                 
		else{ // 비밀번호 일치시 삭제후 창을 닫는다.                    
			if (opener != null) {                        
				// 방명록(부모창) 새로고침                        
				window.opener.document.location.reload();                         
				opener.delForm = null;                        
				self.close();                    
			}                
		}            
	}        
}    
</script>
