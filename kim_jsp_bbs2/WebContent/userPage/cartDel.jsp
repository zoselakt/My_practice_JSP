<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.user.*"%>
<%// 로그인 모듈이 필요함 %>
<jsp:useBean id="mallCart" class="shoppingMall.user.CartBean" scope="session" />

	<%
		//삭제하고자 하는 상품의 번호를 얻어온다.
		String pnum = request.getParameter("pnum");
		
		if(pnum==null || pnum.trim().equals("")){
    %>
    <script type="text/javascript">
    	alert("잘못들어온 경로입니다!!!!!");
    	history.back();
    </script>
    <%
    		return;
		}//if End
       	mallCart.delProd(pnum.trim());
    	response.sendRedirect("cartList.jsp");    
    %>
    
    
    
    
    
    
    