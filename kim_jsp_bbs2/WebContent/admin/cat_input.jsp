<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../ad_top.jsp" %>

<script type="text/javascript">
	function inputCheck(){
		if(!cat_inputFrm.code.value){
			alert("카테고리 코드를 입력하세요!!!");
			cat_inputFrm.code.focus();
			return;
		}
		if(!cat_inputFrm.cname.value){
			alert("카테고리 이름을 입력하세요!!!");
			cat_inputFrm.cname.focus();
			return;
		}
		document.cat_inputFrm.submit();
	}
</script>

<!--  카테고리 등록 -->
	<center>
	<br/><br/>
	<hr width=400 color=maroon/>
	<h3> 카테고리 등록</h2>
	<hr width=400 color=maroon/>
	
	<form action="cat_regOK.jsp" method = "post" name="cat_inputFrm">
	<table width = 500 border = 1>
		<tr>
			<td>코드</td>
			<td><input type="text" name="code" maxlength = 10></td>
		</tr>
		<tr>
			<td>카테고리 이름</td>
			<td><input type="text" name="cname"></td>			
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="button" value="등록" onclick="inputCheck();"/>
				<input type="reset" value="취소"/>
			</td>
		</tr>
	</table>
	
	</form>
	
	</center>	
<%@ include file="../ad_bottom.jsp" %>