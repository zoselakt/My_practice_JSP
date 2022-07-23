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
#pwCheckForm{            
display:block;          
}            
#writeUpdateForm{            
text-align :center;            
display:none;        
}
</style>
</head>
<body>
	<div id="pwCheckForm">
		<form name="delGuestbook" target="parentForm">
			<input type="hidden" name="guestbook_no" value="${guestbook.guestbook_no}"/>
			비밀번호: 
			<input type="password" name="guestbook_password" maxlength="50">
			<input type="button" value="확인" onclick="checkValue()">
			<input type="button" value="창닫기" onclick="window.close()">
		</form>
	</div>
	<div id="writeUpdateForm">
			<form name="updGuestbook" target="parentForm">
				<input type="hidden" name="guestbook_no" value="${guestbook.guestbook_no}"/>
				<table width="550">
				<tr>
					<td>이름 </td>
					<c:if test=${sessionScope.sessionID != null}">
						<td>${sessionScope.sessionID }<input type="hidden" name="guestbook_id" value=${sessionScope.sessionID}></td>
					</c:if>
					
					<c:if test=${sessionScope.sessionID != null}">
						<td><input type="text" name="guestbook_id" value="${guestbook.guestbook_content}"></td>
					</c:if>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
					<td colspan="4"><textarea rows="7" cols="70" name="guestbook_content">${guestbook_guestbook_content }</textarea></td>
				</tr>			
				</table>
				<br>
				<input type="button" value="수정"  onclick="update()()">
				<input type="button" value="창닫기" onclick="window.close()">
			</form>
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
	// 비밀번호 미입력시 경고창        
function checkValue(){             
		var form = document.forms[0];            
		var num = form.guestbook_no.value;            
		var pw = form.guestbook_password.value;                        
		if (!pw) {                
			alert("비밀번호를 입력하지 않았습니다.");                
			return false;            
		}else{                
			var param="num="+num+"&pw="+pw;                                
			httpRequest = getXMLHttpRequest();                
			httpRequest.onreadystatechange = checkFunc;                
			httpRequest.open("POST", "GuestbookPwCheckAction.ge", true);  
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
			}else if(resultText == 1){                     
				// 비밀번호 일치시 수정 화면을 보이게 한다.                    
			var chkForm = document.getElementById("pwCheckForm");      
			var uForm = document.getElementById("writeUpdateForm");     
			chkForm.style.display = 'none'; 
			// 비밀번호 입력화면 - 안보이게                    
			uForm.style.display = 'block';    
			// 수정화면 - 보이게                
			}            
		}        
	}                
	// 방명록 수정        
function update(){            
		var form = document.forms[1];            
		var id = form.guestbook_id.value;            
		var content = form.guestbook_content.value;                        
		if(!id){                
			alert("이름을 입력하세요.");                
			return false;            
		}else if(!content){                
			alert("내용을 입력하세요.");                
			return false;            
		}else{                
			form.target = opener.name;                
			form.method="post";                
			form.action="GuestbookUpdateAction.ge?page=${pageNum}";                
			form.submit();                 
			if (opener != null) {                    
				opener.updForm = null;                    
				self.close();                
			}                
		}        
	}    
</script>
