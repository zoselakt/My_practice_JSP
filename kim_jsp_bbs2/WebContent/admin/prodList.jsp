<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import ="shoppingMall.*, java.util.*"%>
<%@ include file="../ad_top.jsp" %>

<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel =window.confirm("���� �Ͻðڽ��ϱ�?");
		if(isDel) location.href="prodDelete.jsp?pnum="+pnum+"&pimage="+pimage;
		// else 
			// location.reload();
	} //checkDel
</script>


<br/>
<br/>

<hr width=500 color="red" />
<h3>��ǰ ����Ʈ</h3>
<hr width=500 color="red" />


<table width=80% border=0 class=outLine>
	<tr class=m3>
		<th>��ȣ</th>
		<th>ī�װ��ڵ�</th>
		<th>��ǰ��</th>
		<th>�̹���</th>
		<th>����</th>
		<th>������</th>
		<th>����</th>
		<th>����/����</th>		
	</tr>
<%
    ProductDAO pdao = ProductDAO.getInstance();
	ArrayList<ProductDTO> pdtos = pdao.productAll();
	if(pdtos == null||pdtos.size() == 0){
		out.println("<tr><td colspan=8>");
		out.println("��ǰ �����Ͱ� �����ϴ�!!!!!");
		out.println("</td></tr></table>");
		return;
	}//if End
	
	for(ProductDTO pdto:pdtos){
%>    

	<tr>
		<td><%=pdto.getPnum()%></td>
		<td><%=pdto.getPcategory_fk() %></td>
		<td><%=pdto.getPname() %></td>
		<td>
		<%
		  String imgPath =request.getContextPath()+"/uploadFile/"+pdto.getPimage();		
		%>
		<img src="<%=imgPath%>" border= 0 width=60 height=60>		
		</td>
		<td><%=pdto.getPrice()%></td>
		<td><%=pdto.getPcompany()%></td>
		<td><%=pdto.getPqty()%></td>
		<td><a href="prodUpdate.jsp?pnum=<%=pdto.getPnum()%>">����</a> | <a href="javascript:checkDel('<%=pdto.getPnum()%>','<%=pdto.getPimage()%>');">����</a></td>
	</tr>
<%
	} //for
%>	
</table>

<%@ include file="../ad_bottom.jsp" %>