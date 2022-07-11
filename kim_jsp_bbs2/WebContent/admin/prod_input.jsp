<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "java.util.*, shoppingMall.CategoryDAO, shoppingMall.CategoryDTO"%>    
<%@ include file="../ad_top.jsp" %>
<%
 CategoryDAO cdao = CategoryDAO.getInstance();

%>
	
<h3> ��ǰ��� ������</h3>
<form name="prodFrm" action="prod_regOK.jsp" method="post" enctype="multipart/form-data">
<table border=0 class="outLine" width=600>
	<tr>
		<th class="m3">ī�װ�</th>
		<td>
		<select name="pcategory_fk">
		<%
			ArrayList<CategoryDTO> cdtos = cdao.categoryAll();
			if(cdtos == null || cdtos.size() == 0){
		%>
		<option value="">ī�װ� ����</option>
		<%
			}else{
				for(CategoryDTO cdto:cdtos){
					String cname= cdto.getCname();
					String code = cdto.getCode();
				%>
				<option value="<%=code%>">
				<%=cname%>[<%=code %>]</option>
				<%	
				}//for End				
			}
		 %>		
		</select>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ��</th>
		<td align="left">
			<input type="text" name="pname"/>
		</td>
	</tr>
	<tr>
		<th class="m3">����ȸ��</th>
		<td>
			<input type="text" name="pcompany"/>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ�̹���</th>
		<td>
			<!-- �̹��� ������ �����Ͽ� ���ε��Ѵ�.  -->
			<input type="file" name="pimage"/>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ����</th>
		<td>
			<input type="text" name="pqty" maxlength="8"/>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ����</th>
		<td>
			<input type="text" name="price" maxlength="8"/>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ���</th>
		<td>
			<select name="pspec">
				<option value="none" selected> �Ϲ�</option>
				<option value="hit"> �α� </option>
				<option value="new">�ֽ� </option>
				<option value="recommand">��õ</option>
			</select>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ�Ұ�</th>
		<td>
			<textarea name="pcontents" row="5" cols="50"></textarea>
		</td>
	</tr>
	<tr>
		<th class="m3">��ǰ����Ʈ</th>
		<td>
			<input type="text" name="point" />
		</td>
	</tr>
	<tr>
		<td colspan="2" class="m1" align="center">
			<input type="submit" value="��ǰ���" />
			<input type="reset" value="�� ��" />
		</td>
	</tr>
</table>
</form>
<%@ include file="../ad_bottom.jsp" %>