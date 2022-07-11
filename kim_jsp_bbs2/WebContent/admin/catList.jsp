<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import ="shoppingMall.*, java.util.*"%>
<%@ include file="../ad_top.jsp" %>



<h3>카테고리 리스트</h3>
<table width=600 class="outLine">
	<tr class ="m1">
		<th>번호</th>
		<th>코드</th>
		<th>카테고리명</th>
		<th>삭제</th>
	</tr>
<% CategoryDAO cdao = CategoryDAO.getInstance();
   ArrayList<CategoryDTO> cdtos = cdao.categoryAll();
   if(cdtos == null || cdtos.size() == 0){
	   out.println("<tr><td colspan=4>등록된 카테고리가 없습니다!!</td></tr></table>");
   }
   
   for(int i=0; i<cdtos.size(); i++){
	   CategoryDTO cdto = cdtos.get(i);  
%>
	<!-- 데이터베이스로 부터 가져온 리스트 내용 -->
	<tr class="m2">
		<td><%=cdto.getCnum() %></td>
		<td><%=cdto.getCode() %></td>
		<td><%=cdto.getCname() %></td>
		<td><a href="catDelete.jsp?cnum=<%=cdto.getCnum()%>">삭제</a></td>	
	</tr>	
<%
   } //for End
%>	
	
</table>
<%@ include file="../ad_bottom.jsp" %>