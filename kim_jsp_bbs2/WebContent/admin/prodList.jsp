<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import ="shoppingMall.*, java.util.*"%>
<%@ include file="../ad_top.jsp" %>

<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel =window.confirm("삭제 하시겠습니까?");
		if(isDel) location.href="prodDelete.jsp?pnum="+pnum+"&pimage="+pimage;
		// else 
			// location.reload();
	} //checkDel
</script>


<br/>
<br/>

<hr width=500 color="red" />
<h3>상품 리스트</h3>
<hr width=500 color="red" />


<table width=80% border=0 class=outLine>
	<tr class=m3>
		<th>번호</th>
		<th>카테고리코드</th>
		<th>상품명</th>
		<th>이미지</th>
		<th>가격</th>
		<th>제조사</th>
		<th>수량</th>
		<th>수정/삭제</th>		
	</tr>
<%
    ProductDAO pdao = ProductDAO.getInstance();
	ArrayList<ProductDTO> pdtos = pdao.productAll();
	if(pdtos == null||pdtos.size() == 0){
		out.println("<tr><td colspan=8>");
		out.println("상품 데이터가 없습니다!!!!!");
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
		<td><a href="prodUpdate.jsp?pnum=<%=pdto.getPnum()%>">수정</a> | <a href="javascript:checkDel('<%=pdto.getPnum()%>','<%=pdto.getPimage()%>');">삭제</a></td>
	</tr>
<%
	} //for
%>	
</table>

<%@ include file="../ad_bottom.jsp" %>