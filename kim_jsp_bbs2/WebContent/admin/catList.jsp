<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import ="shoppingMall.*, java.util.*"%>
<%@ include file="../ad_top.jsp" %>



<h3>ī�װ� ����Ʈ</h3>
<table width=600 class="outLine">
	<tr class ="m1">
		<th>��ȣ</th>
		<th>�ڵ�</th>
		<th>ī�װ���</th>
		<th>����</th>
	</tr>
<% CategoryDAO cdao = CategoryDAO.getInstance();
   ArrayList<CategoryDTO> cdtos = cdao.categoryAll();
   if(cdtos == null || cdtos.size() == 0){
	   out.println("<tr><td colspan=4>��ϵ� ī�װ��� �����ϴ�!!</td></tr></table>");
   }
   
   for(int i=0; i<cdtos.size(); i++){
	   CategoryDTO cdto = cdtos.get(i);  
%>
	<!-- �����ͺ��̽��� ���� ������ ����Ʈ ���� -->
	<tr class="m2">
		<td><%=cdto.getCnum() %></td>
		<td><%=cdto.getCode() %></td>
		<td><%=cdto.getCname() %></td>
		<td><a href="catDelete.jsp?cnum=<%=cdto.getCnum()%>">����</a></td>	
	</tr>	
<%
   } //for End
%>	
	
</table>
<%@ include file="../ad_bottom.jsp" %>