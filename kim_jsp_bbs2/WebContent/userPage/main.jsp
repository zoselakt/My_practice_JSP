<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.*,shoppingMall.user.*,java.util.*,java.text.*"%>
<%@ include file="main_top.jsp" %>
  <!-- mall ���� -->
		
			<h3 align="center"> ���θ��� ���� ���� ȯ���մϴ�!!!</h3>			
			<% //�α��ǰ ����---------------------------------------------- 
				DecimalFormat df = new DecimalFormat("#,###,###");
			
			    ProdListDAO pdao = ProdListDAO.getInstance();
				Vector<ProductDTO> pdtos = pdao.selectByPspec("hit");
				
				if(pdtos==null || pdtos.size()==0){
					out.println("Hit ��ǰ�� �����ϴ�!!!!");
				}else{
			%>
			<hr color="red"/>
			<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�α� ��ǰ</b>
			<hr color="green" width="90%"/>
			<br>
			<table width="100%"  border="1", align="center">
				<tr>
				<%	int cnt = 0;
					for(ProductDTO pdto:pdtos){
						cnt++;
						String pimage=pdto.getPimage();
						String pnum = pdto.getPnum();
						String pname = pdto.getPname();
						int price = pdto.getPrice();
						int point = pdto.getPoint();
				%>
				 	<td align="center">
				 	<a href="prodView.jsp?pnum=<%=pnum%>&pspec=hit">
				 	<img src="../uploadFile/<%=pimage%>" width = "120" height="120" border="0"/>
				 	</a>
				 	<br/>
				 	<%=pname%><br/>
				 	<%=df.format(price)%>��<br/>
				 	[<%=point%>] ����Ʈ
				 	</td>	
				<%
						if(cnt%4==0){
							out.println("</tr><tr>");
						}//if
					
					}//for End
				%>
				</tr>
			</table>
			<%
			} // if
			%>
			<% //�Ż�ǰ ����----------------------------------------------
				Vector<ProductDTO> pdtos2 = pdao.selectByPspec("new");
				if(pdtos2 == null || pdtos2.size()==0){
					out.println("�Ż�ǰ�� �������� �ʽ��ϴ�!!!");
				}else{
			%>
			    <br/> 
				<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ֽ� ��ǰ</b>
			    <hr color="green" width="90%" />
			    <br>
			    <table width="100%" border=1 align="center">
			    <tr>
			    <%	int cnt = 0;
					for(ProductDTO pdto:pdtos2){
						cnt++;
						String pimage=pdto.getPimage();
						String pnum = pdto.getPnum();
						String pname = pdto.getPname();
						int price = pdto.getPrice();
						int point = pdto.getPoint();
				%>
				<td align="center">
				    <a href="prodView.jsp?pnum=<%=pnum%>&pspec=new">
				 	<img src="../uploadFile/<%=pimage%>" width = "120" height="120" border="0"/>
				 	</a>
				 	<br/>
				 	<%=pname%><br/>
				 	<%=df.format(price)%>��<br/>
				 	[<%=point%>] ����Ʈ
				</td>
				<%	
						if(cnt%4==0){
							out.println("</tr><tr>");
						}//if
					
					}//for End %>
			    </tr>
			    </table>
			<%   }//if�� %>
			
			
		</td>
<%@ include file="main_bottom.jsp" %>   