<%@page import="controller.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">        table{            margin-left:auto;             margin-right:auto;            border:3px solid skyblue;        }                td{            border:1px solid skyblue        }                #title{            background-color:skyblue        }    </style>
</head>
<body>
	<%
		String id = session.getAttribute("sessionId").toString();
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = dao.getUserInfo(id);
	%>
	<br><br>        
	<b><font size="6" color="gray">내 정보</font></b>        
	<br><br><br>
	<table>
		<tr>
			<td id="title">아이디</td>
			<td><%= vo.getId() %></td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<td><%= vo.getPassword() %></td>
		</tr>
		<tr>
			<td id="title">이름</td>
			<td> <%= vo.getName() %> </td>
		</tr>
		<tr>
			<td id="title">성별</td>
			<td><%= vo.getGender() %></td>
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
			<td><%= vo.getEmail1() %>@ <%=vo.getEmail2() %></td>
		</tr>
		<tr>
			<td id="title">전화번호</td>
			<td><%= vo.getPhone() %></td>
		</tr>
		<tr>
			<td id="title">주소</td>
			<td><%= vo.getAddress() %></td>
		</tr>
	</table>
</body>
</html>

<script type="text/javascript">            
function changeForm(val){            
	if(val == "-1"){                
		location.href="MainForm.jsp";            
	}else if(val == "0"){                
			location.href="MainForm.jsp?contentPage=member/view/ModifyFrom.jsp";
	}else if(val == "1"){                
		location.href="MainForm.jsp?contentPage=member/view/DeleteForm.jsp";
	}        
}            
</script>
