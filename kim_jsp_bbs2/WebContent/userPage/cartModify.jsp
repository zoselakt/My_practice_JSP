<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.user.*"%>
<%// 로그인 모듈이 필요함 %>
<jsp:useBean id="mallCart" class="shoppingMall.user.CartBean" scope="session" />

	<%
		//수정하고자 하는 상품의 번호와 수량을 얻어온다.
		String pnum = request.getParameter("pnum");
		String pqty = request.getParameter("pqty");
		
		if(pnum==null || pqty ==null || pnum.trim().equals("")||pqty.trim().equals("")){
    %>
    <script type="text/javascript">
    	alert("잘못들어온 경로입니다!!!!!");
    	history.back();
    </script>
    <%
    		return;
		}//if End
    try{
    	mallCart.setModify(pnum, pqty);
    	response.sendRedirect("cartList.jsp");
    }catch(NumberFormatException e){
    	%>
    	<script>
    		alert("수량을 잘못 입력했습니다!!!!");
    		history.go(-1);
    	</script>
   	<%
    }
    %>
    
    
    
    
    
    
    