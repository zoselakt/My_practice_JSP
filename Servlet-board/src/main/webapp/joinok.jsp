<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>
    <jsp:useBean id="vo" class="controller.MemberVo"/>
    <jsp:setProperty property="*" name="vo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
</body>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = MemberDao.getInstance();
	dao.insertMember(vo);

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String[] gender = request.getParameterValues("gender");
	String birthyy = request.getParameter("birthyy");
	String[] birthmm = request.getParameterValues("birthmm");
	String birthdd = request.getParameter("birthdd");
	String email1 = request.getParameter("email1");
	String[] email2 = request.getParameterValues("email2");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
%>

<div id="wrap">
<br><br>        
<b><font size="6" color="gray">회원가입 정보확인</font></b>
<p color="blue"><%= name %></p> 님 가입을 축하드립니다.
<br><br>

	<table>
		<tr>
			<td id="title">아이디</td>
			<td><%= id %></td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<td><%= password %></td>
		</tr>
		<tr>
			<td id="title">이름</td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td id="title">성별</td>
			<td><% for(String g : gender){out.println(g);}%></td>
		</tr>
		<tr>
			<td id="title">생일</td>
			<td>
				<%= birthyy %> 년
				<% for (String mm : birthmm) { out.println(mm); }%> 월
				<%= birthdd %> 일
			</td>
		</tr>
		<tr>
			<td id="title">이메일</td>
			<td>
				<%=email1 %>
				<% for(String e : email2){ out.println("@"+e);} %>
			</td>
		</tr>
		<tr>
			<td id="title">휴대전화</td>
			<td> <%=phone %></td>
		</tr>
 		<tr>
 			<td id="title">주소</td>
 			<td> <%=address %></td>
		</tr>
	</table>            
	<br>            
	<a href="LoginForm.jsp"><input type="button" value="확인"></a>
</div></body></html>