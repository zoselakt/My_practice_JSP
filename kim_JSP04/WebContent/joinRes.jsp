    <%@ page import = "connectionpool.*" %>
	<%@ page import="java.sql.Timestamp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    
    <jsp:useBean id="mdto" class="connectionpool.MemberDTO"></jsp:useBean>
    <jsp:setProperty name="mdto" property="*"/> <!-- 모든프로퍼티에 적용하겠다. -->
    <%
    	mdto.setrDate(new Timestamp(System.currentTimeMillis()));
    	MemberDAO mdao = MemberDAO.getInstance();
    	if(mdao.checkId(mdto.getId()) == MemberDAO.MEM_EXIST){
    		
    %>
    <script type="text/javascript"> 
    	alert("아이디가 이미 존재합니다")
    	history.back();
    </script>
    <%
    	}else{
    		int n = mdao.insertMember(mdto);
    		if(n == MemberDAO.MEM_JOIN_SUCCESS){
    			session.setAttribute("id", mdto.getId());
    %>
    <script type="text/javascript">
    	alert("회원가입 처리되었습니다.")
    	document.location.href="login.jsp";
    </script>
    <%
    	}else{
    %>
    <script type="text/javascript">
    	alert("회원가입에 실패했습니다.")
    	document.location.href="login.jsp";
    </script>
    <%
    	}	
    }
    %>