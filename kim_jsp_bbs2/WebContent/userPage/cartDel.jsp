<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.user.*"%>
<%// �α��� ����� �ʿ��� %>
<jsp:useBean id="mallCart" class="shoppingMall.user.CartBean" scope="session" />

	<%
		//�����ϰ��� �ϴ� ��ǰ�� ��ȣ�� ���´�.
		String pnum = request.getParameter("pnum");
		
		if(pnum==null || pnum.trim().equals("")){
    %>
    <script type="text/javascript">
    	alert("�߸����� ����Դϴ�!!!!!");
    	history.back();
    </script>
    <%
    		return;
		}//if End
       	mallCart.delProd(pnum.trim());
    	response.sendRedirect("cartList.jsp");    
    %>
    
    
    
    
    
    
    