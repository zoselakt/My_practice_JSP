<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import ="shoppingMall.*, java.util.*"%>
<%@ include file="../ad_top.jsp" %>
<%
	String pnum =request.getParameter("pnum");
	if(pnum == null|| pnum.trim().equals("")){
		response.sendRedirect("prodList.jsp");
		return;
	}//if
	
    ProductDAO pdao = ProductDAO.getInstance();	
	ProductDTO pdto =pdao.selectProduct(pnum.trim());
	
	if(pdto == null){
%>
	<script type="text/javascript">
		alert("<%=pnum%>번 상품이 존재하지 않습니다.!!!!");
		history.back(); //location.href="productUpdate.jsp", history.go(-1);
	</script>
<%
	} //if
%>


<h3>상품 수정 페이지</h3>
<form action="prodUpdate_Ok.jsp" method="post" enctype="multipart/form-data">
<table class="outLine" width="600">
	<tr>
		<th class="m3">카테고리</th>
		<td>
			<select name="pcategory_fk">
				<%
					CategoryDAO cdao = CategoryDAO.getInstance();
					ArrayList<CategoryDTO> cdtos = cdao.categoryAll();
					if(cdtos ==null|| cdtos.size() == 0){
						out.println("<option value=0>");
						out.println("카테고리 없음");
						out.println("</option>");
					}else{
						for(CategoryDTO cdto:cdtos){
							String code = cdto.getCode();
							String cname = cdto.getCname();
							if(cdto.getCode().equals(pdto.getPcategory_fk())){
				%>
								<option value="<%=code%>" selected>
									<%=cname%>
								</option>
				
				<%			}else{ %>
								<option value="<%=code%>">
									<%=cname%>
								</option>					
				<%          }//else
						}//for문
					}//else
				%>
			</select>
		</td>
	</tr>
	
	<!--  상품번호 -->
	<tr>
		<th class = "m3">상품번호</th>
		<td><%=pdto.getPnum()%></td>
		<input type="hidden" name="pnum" value="<%=pdto.getPnum()%>"/>
	</tr>
	<tr>
		<th class = "m3">상품명</th>
		<td>
		   <input type="text" name="pname" value="<%=pdto.getPname()%>"/>		
		</td>
	</tr>
	<tr>
		<th class = "m3">제조회사</th>
		<td><input type="text" name="pcompany" value="<%=pdto.getPcompany()%>"></td>
	</tr>
	<tr>
		<th class = "m3">상품이미지</th>
		<td>
			<img src="../uploadFile/<%=pdto.getPimage()%>" width="100" height="100">
			<input type="file" name="pimageNew"/>
			<!-- 이미지를 수정하지 않고 그대로 사용할 경우 -->
			<input type="hidden" name="pimageOld" value="<%=pdto.getPimage()%>">
		</td>
	</tr>
	<tr>
		<th>상품수량</th>
		<td><input type = "text" name="pqty" value="<%=pdto.getPqty()%>"></td>
	</tr>
	<tr>
		<th>상품가격</th>
		<td>
			<input type="text" name="price" value="<%=pdto.getPrice()%>" maxlength="8"/>
		</td>
	</tr>
	<tr>
		<th>상품사양</th>
		<td><input type="text" name="pspec" value="<%=pdto.getPspec()%>"/></td>
	</tr>
	<tr>
		<th>상품소개</th>
		<td><textarea rows=5 cols=50><%=pdto.getPcontents()%></textarea></td>
	</tr>
	<tr>
		<th>상품포인트</th>
		<td><input type="text" name="point" value="<%=pdto.getPoint()%>"></td>
	</tr>
	<tr>
		<td colspan=2 class ="m2" align="center">
			<input type="submit" value="상품수정"/> 
			<input type="reset" value="취 소"/>
		</td>
	</tr>
</table>
</form>

<%@ include file="../ad_bottom.jsp" %>