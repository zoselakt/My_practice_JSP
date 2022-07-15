<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>
    <jsp:useBean id="vo" class="controller.MemberVo"/>
    <jsp:setProperty property="*" name="vo"/>
    <%
    	String id = (String) session.getAttribute("sessionID");
    	vo.setId(id);
    	MemberDao dao = MemberDao.getInstance();
    	dao.updateMember(vo);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font size="5" color="gray">회원정보가 수정되었습니다.</font>
	<input type="button" value="메인으로" onclick="javascript:window.location='MainForm.jsp'"/>
</body>
</html>