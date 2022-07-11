<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.*,shoppingMall.user.*,java.util.*,java.text.*"%>
<%@ include file="main_top.jsp" %>
 
<jsp:useBean id="mallCart" class="shoppingMall.user.CartBean" scope="session" /> 
 
  <!-- 장바구니 리스트  -->

	<table width="540" cellpadding="0" cellspacing="0" border="1" align="center">
	<tr class="m3">
		<td colspan="6" align="center">
			<h3>장바구니 보기</h3>
		</td>
	</tr>
	<tr class="m1">
		<th width="10%">번호</th>
		<th width="20%">상품명</th>
		<th width="10%">수량</th>
		<th width="20%">단가</th>
		<th width="20%">합계</th>
		<th width="20%">삭제</th>
	</tr>
	
	<%
		DecimalFormat df = new DecimalFormat("#,###,###");
		//장바구니 총액           	누적포인트
		int cartTotPrice = 0, cartTotPoint=0;
		
		//장바구니에 있는 모든 상품을 가져오는 모듈을 호출한다.
		Vector<ProductDTO> cpds = mallCart.getAllProducts();
		if(cpds==null||cpds.size() ==0){
			out.println("<tr><td colspan=6>");
			out.println("장바구니가 비었습니다!!!!");
			out.println("</td></tr></table>");
			return;
		}
		
		for(ProductDTO pd:cpds){
	%>	
	<tr>
		<td align="center"><%=pd.getPnum() %></td>
		<td align="center">
			<img src = "../uploadFile/<%=pd.getPimage()%>" width="100" height="100" /><br/>
			<%=pd.getPname()%>
		</td>
		<td align="center">
			<form action ="cartModify.jsp" name="frm" method="post">
				<input type="text" size="2" name="pqty" value="<%=pd.getPqty() %>"/>개
				<input type="hidden" name="pnum" value="<%=pd.getPnum()%>" />
				<input type="submit" value="수정" />			
			</form>			
		</td>
		<td align="center">
			<%=df.format(pd.getPrice())%>원<br/>
			[<%=pd.getPoint() %>]point		
		</td>
		<td align="center">
			<%=df.format(pd.getTotPrice())%>원<br/>
			[<%=pd.getTotPoint() %>]point
		</td>
		<td align="center">
			<a href="cartDel.jsp?pnum=<%=pd.getPnum()%>">삭제</a>
		</td>		
	</tr>
	<%  
		// 장바구니의 전체 총액 구하기
		cartTotPrice+=pd.getTotPrice();
		
		// 장바구니의 전체 누적 포인트 구하기
		cartTotPoint+=pd.getTotPoint();
		}//for End 	
	%>
	<!-- 장바구니 전체 총액 계산 -->
	<tr>
		<td colspan="4">장바구니 총액 :
		<%=df.format(cartTotPrice)%>원<br/>
		총누적포인트 : [<%=cartTotPoint%>]point
		</td>
		<td colspan="2">
		<a href="order.jsp">[주문하기]</a> &nbsp;&nbsp;<a href="javascript:history.go(-2);">[계속쇼핑]</a>
		</td>		
	</tr>			
	</table>


<%@ include file="main_bottom.jsp" %>   