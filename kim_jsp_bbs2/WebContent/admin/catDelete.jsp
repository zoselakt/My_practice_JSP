<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "shoppingMall.CategoryDAO"%>
<%
	String cnum = request.getParameter("cnum");

	if(cnum == null || cnum.trim().equals("")){
		response.sendRedirect("catList.jsp");
		return;
	}//if
	
	//categoryDAO�� ����Ͻ� ������ ����
	
	CategoryDAO cdao = CategoryDAO.getInstance();
	int n =cdao.categoryDelete(cnum);
	
	String msg = "", url="catList.jsp";
	if(n > 0){
		msg = "ī�װ� �����Ϸ� �Ǿ����ϴ�..!!!";
	}else{
		msg = "ī�װ� ���� ����!!!";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>


