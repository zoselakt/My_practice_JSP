<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.*,shoppingMall.user.*,java.util.*,java.text.*"%>
<%@ include file="main_top.jsp" %>
  <!-- ��ǰ �󼼺��� ������ -->
  <%
  	String pnum = request.getParameter("pnum");
  	String pspec = request.getParameter("pspec");
  	
  	if(pnum == null || pnum.trim().equals("") || pspec==null || pspec.trim().equals("")){
  		response.sendRedirect("main.jsp");
  		return;
  	}
  	
  	ProdListDAO lidao = ProdListDAO.getInstance();
  	Vector<ProductDTO> pdtos = lidao.selectByPnum(pnum.trim());
  	 
  	ProductDTO pdto = pdtos.get(0);
  	
  	if(pdto == null){
  		out.println(pnum+"�� �ش��ϴ� ��ǰ�� �����ϴ�!!!");
  		return;
  	}  	
  %>
  
  <br></br>
  <table width="540" border="0" class="outLine">
  	<tr class = "m1">
  		<td colspan="2">
  		<b>[<%=pdto.getPname()%>] ��ǰ ����</b>
  		</td>
  	</tr>
  	<tr>
  		<td align="center">
  			<img src="../uploadFile/<%=pdto.getPimage()%>" width="200" height="200"/>
  		</td>
  		<td class = "m2">
  			<form name="frm" method="post">
  			<input type="hidden" name="pspec" value="<%=pspec%>" />
  				��ǰ��ȣ : <%=pnum%> <br/>
  				��ǰ�̸� : <%=pdto.getPname() %><br/>
  				��ǰ���� : <%=pdto.getPrice() %>��<br/>
  				��ǰ����Ʈ:[<%=pdto.getPoint() %>] point <br/>
  				��ǰ���� :<input type="text" name="pqty" size="2" value="1">��<br/>
  				<br/>
  				<table border="0" width="90%" align="center">
  					<tr>
  				<!--  ��ٱ��� ��� ��ư-->
  						<td>
  							<a href="javascript:goCart('<%=pnum%>')">
  								<img src="../uploadFile/btn_cart(1).png" border="0">
  							</a>
  						</td>
  				<!--  �����ϱ� ��ư-->
  						<td>
  							<a href="#">
  								<img src="../uploadFile/btn_buy.png" border="0">
  							</a>
  						</td>
  					</tr>
  				</table>
  			</form>
  			
  		</td>
  	</tr>
  	<!-- ��ǰ �� ���� -->
  	<tr height ="250" valign="top">
  		<td colspan="2" >
  		  	<br/>
  			<b>��ǰ �Ұ�</b><br/>
  			<%=pdto.getPcontents() %>
  		</td>
  	</tr>
  </table>
  <script type="text/javascript">
	  function goCart(pnum){
	  	document.frm.action="/shoppingMall/userPage/cartAdd.jsp?pnum="+pnum;
	  	document.frm.submit();
	  }//goCart()	
  </script>
  
  
<%@ include file="main_bottom.jsp" %>   