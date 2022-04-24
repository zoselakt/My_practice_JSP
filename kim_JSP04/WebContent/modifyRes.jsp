<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "connectionpool.*" %>
    <% request.setCharacterEncoding("UTF-8"); %>
    
    <jsp:useBean id="mdto" class="connectionpool.MemberDTO" scope="page"/>
    <<jsp:setProperty property="*" name="mdto"/>
    
    <%
    String id = (String) session.getAttribute("id");
    mdto.setId(id);
    MemberDAO mdao = MemberDAO.getInstance();
    int n = mdao.updateMember(mdto);
    
    if(n==1){
    %>
    <script type="text/javascript">
	    alert("회원정보 수정이 되었습니다.")
	    document.location.href="main.jsp";
    </script>
    <%
    }else{
    %>
    <script type="text/javascript">
	    alert("수정실패.")
	    history.go(-1);
    </script>
    <%
    }
    %>
