<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.*,shoppingMall.user.*,java.util.*,java.text.*"%>
<%@ include file="main_top.jsp" %>
 
<jsp:useBean id="mallCart" class="shoppingMall.user.CartBean" scope="session" /> 
 
  <!-- ��ٱ��� ����Ʈ  -->

	<table width="540" cellpadding="0" cellspacing="0" border="1" align="center">
	<tr class="m3">
		<td colspan="6" align="center">
			<h3>��ٱ��� ����</h3>
		</td>
	</tr>
	<tr class="m1">
		<th width="10%">��ȣ</th>
		<th width="20%">��ǰ��</th>
		<th width="10%">����</th>
		<th width="20%">�ܰ�</th>
		<th width="20%">�հ�</th>
		<th width="20%">����</th>
	</tr>
	
	<%
		DecimalFormat df = new DecimalFormat("#,###,###");
		//��ٱ��� �Ѿ�           	��������Ʈ
		int cartTotPrice = 0, cartTotPoint=0;
		
		//��ٱ��Ͽ� �ִ� ��� ��ǰ�� �������� ����� ȣ���Ѵ�.
		Vector<ProductDTO> cpds = mallCart.getAllProducts();
		if(cpds==null||cpds.size() ==0){
			out.println("<tr><td colspan=6>");
			out.println("��ٱ��ϰ� ������ϴ�!!!!");
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
				<input type="text" size="2" name="pqty" value="<%=pd.getPqty() %>"/>��
				<input type="hidden" name="pnum" value="<%=pd.getPnum()%>" />
				<input type="submit" value="����" />			
			</form>			
		</td>
		<td align="center">
			<%=df.format(pd.getPrice())%>��<br/>
			[<%=pd.getPoint() %>]point		
		</td>
		<td align="center">
			<%=df.format(pd.getTotPrice())%>��<br/>
			[<%=pd.getTotPoint() %>]point
		</td>
		<td align="center">
			<a href="cartDel.jsp?pnum=<%=pd.getPnum()%>">����</a>
		</td>		
	</tr>
	<%  
		// ��ٱ����� ��ü �Ѿ� ���ϱ�
		cartTotPrice+=pd.getTotPrice();
		
		// ��ٱ����� ��ü ���� ����Ʈ ���ϱ�
		cartTotPoint+=pd.getTotPoint();
		}//for End 	
	%>
	<!-- ��ٱ��� ��ü �Ѿ� ��� -->
	<tr>
		<td colspan="4">��ٱ��� �Ѿ� :
		<%=df.format(cartTotPrice)%>��<br/>
		�Ѵ�������Ʈ : [<%=cartTotPoint%>]point
		</td>
		<td colspan="2">
		<a href="order.jsp">[�ֹ��ϱ�]</a> &nbsp;&nbsp;<a href="javascript:history.go(-2);">[��Ӽ���]</a>
		</td>		
	</tr>			
	</table>


<%@ include file="main_bottom.jsp" %>   