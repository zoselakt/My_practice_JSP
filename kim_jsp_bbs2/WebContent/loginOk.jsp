<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="shoppingMall.AdminDAO, shoppingMall.AdminDTO" %>    
<%
	request.setCharacterEncoding("EUC-KR");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");	
	
	AdminDAO adao = AdminDAO.getInstance();
	int chkNum = adao.adminCheck(id, pw);
	
	if(chkNum == -1){	
%>
<script language="javascript">
	alert("�����ڸ� ������ �� �ֽ��ϴ�..!!!");
	history.go(-1);
</script>"
<% 
	}else if(chkNum == 0){		
%>
<script language="javascript">
	alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�...!!!");
	history.go(-1);
</script>"
<%
	}else if(chkNum == 1){
		AdminDTO adto = adao.getAdmin(id);
		
		String name = adto.getName();
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("valid", "yes");
		response.sendRedirect("ad_main.jsp");
	}
%>




