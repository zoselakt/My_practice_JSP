<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../ad_top.jsp" %>

<script type="text/javascript">
	function inputCheck(){
		if(!cat_inputFrm.code.value){
			alert("ī�װ� �ڵ带 �Է��ϼ���!!!");
			cat_inputFrm.code.focus();
			return;
		}
		if(!cat_inputFrm.cname.value){
			alert("ī�װ� �̸��� �Է��ϼ���!!!");
			cat_inputFrm.cname.focus();
			return;
		}
		document.cat_inputFrm.submit();
	}
</script>

<!--  ī�װ� ��� -->
	<center>
	<br/><br/>
	<hr width=400 color=maroon/>
	<h3> ī�װ� ���</h2>
	<hr width=400 color=maroon/>
	
	<form action="cat_regOK.jsp" method = "post" name="cat_inputFrm">
	<table width = 500 border = 1>
		<tr>
			<td>�ڵ�</td>
			<td><input type="text" name="code" maxlength = 10></td>
		</tr>
		<tr>
			<td>ī�װ� �̸�</td>
			<td><input type="text" name="cname"></td>			
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="button" value="���" onclick="inputCheck();"/>
				<input type="reset" value="���"/>
			</td>
		</tr>
	</table>
	
	</form>
	
	</center>	
<%@ include file="../ad_bottom.jsp" %>