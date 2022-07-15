<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>
<!DOCTYPE html>
<html>
<head>
<%
	String id = session.getAttribute("sessionID").toString();
	MemberDao dao = MemberDao.getInstance();
	MemberVo vo = dao.getUserInfo(id);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">        table{            margin-left:auto;             margin-right:auto;            border:3px solid skyblue;        }                td{            border:1px solid skyblue        }                #title{            background-color:skyblue        }    </style>
</head>
<body>
	<br><br>        
	<b><font size="6" color="gray">회원정보수정</font></b>        
	<br><br><br>
	<form action="join_ok" method="post">            
	<table>
		<tr>
			<td id="title">아이디</td>
			<td>
				<input type="text" name="id" maxlength="20">  
				<td id="title"><%= vo.getId() %></td>
			</td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<input type="password" name="password" maxlength="50" value="<%=vo.getPassword()%>">
		</tr>

		<tr>
			<td id="title">이름</td>
			<td><%=vo.getName() %></td>
		</tr>
		<tr>
			<td id="title">성별</td>
			<td><%=vo.getGender() %></td>
		</tr>
		<tr>
			<td id="title">생일</td>
			<td>
				<%= vo.getBirthyy() %>년                         
				<%= vo.getBirthmm() %>월                         
				<%= vo.getBirthdd() %>일
			</td>
		</tr>
		<tr>
			<td id="title">이메일</td>
			<td><input type="text" name="email_1" maxlength="30" value="<%=vo.getEmail1()%>">
			<select name="email_2">
				<option>naver.com</option>
				<option>daum.net</option>
				<option>gmail.com</option>
				<option>nate.com</option>
			</select>                    
			</td>
		</tr>
 		<tr>
 			<td id="title">휴대전화</td>
			<td><input type="text" name="phone" value="<%=vo.getPhone()%>">
		</tr>
		<tr>
			<td id="title">주소</td>
			<td><input type="text" size="50" name="address"  value="<%= vo.getAddress()%>"/>
		</tr>
	</table>            
	<br>            
	<input type="submit" value="수정"/>  <input type="button" value="취소">        
</form>    
</div></body></html>
</body>
</html>
 <script type="text/javascript">            
function init(){            
	setComboValue("<%=vo.getEmail2()%>");        
}         
function setComboValue(val){            
	var selectMail = document.getElementById('mail2');            
	for (i = 0, j = selectMail.length; i < j; i++){                
		if (selectMail.options[i].value == val){                    
			selectMail.options[i].selected = true;                
			 break;                
			}            
		}        
	}
function checkValue() {            
	if(!document.userInfo.password.value){                
		alert("비밀번호를 입력하세요.");                
		return false;            
		}        
	}            
</script>
