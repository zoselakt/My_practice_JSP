<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="shoppingMall.CategoryDAO" %>    
    
<%
// ����ڷ� ���� �Է��� ���� �޾ƿ���
request.setCharacterEncoding("euc-kr");
String code = request.getParameter("code");
String cname = request.getParameter("cname");

//��ȿ�� �˻�
if(code ==null|| cname == null||code.trim().equals("")|| cname.trim().equals("")){
	response.sendRedirect("cat_input.jsp");
}

// ����Ͻ� ����(DAO) ����
CategoryDAO cdao = CategoryDAO.getInstance();
int n = cdao.insertCat(code.trim(), cname.trim());
String msg = "", url = "";

if(n>0){
	msg = "ī�װ� ��� �Ǿ����ϴ�...!!";
	url = "catList.jsp";
	
}else{
	msg = "ī�װ� ��� �����߽��ϴ�...!!!";
	url = "cat_input.jsp";
}
%>    
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>