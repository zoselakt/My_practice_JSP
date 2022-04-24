    <%@ page import = "connectionpool.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <% 
    request.setCharacterEncoding("UTF-8"); 
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    MemberDAO mdao = MemberDAO.getInstance();
    // DAO파일에 usercheck를 int형으로 하였기 때문에 int로 불러온다.
    int chkNum = mdao.memberCheck(id, pw);
    if(chkNum == -1){
    %>
    <script type="text/javascript">
    	alert("아이디가 존재하지 않습니다.");
    	history.go(-1);
    </script>
    <%
    }else if(chkNum == 0){
    %>
    <script type="text/javascript">
    	alert("비밀번호가 틀립니다.");
    	history.go(-1);
	</script>
    <%
    }else if(chkNum == 1){
    	MemberDTO mdto = mdao.getMember(id);
    	
    	if(mdto == null){
    %>
    <script type="text/javascript">
    	alert("가입된 회원이 아닙니다.");
    	history.go(-1);
    </script>
    <%
    	}else{
    		String name = mdto.getName();
    		session.setAttribute("id",id);
    		session.setAttribute("name", name);
    		session.setAttribute("chkMember", "yes"); //세션으로 멤버체크여부를 확인하여 yes인경우 성공
    		response.sendRedirect("main.jsp");
    	}
    }
    %>
    
 <!-- <%--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> <%=name %>님 환영합니다. </h2>
<a href="modify.jsp">회원정보 수정</a>
</body>
</html>

 --%> -->