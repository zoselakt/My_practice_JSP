<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
	<hr width="500" color="green" size="1" />
	<h3> ���ۼ��ϱ�</h3>
	<hr width="500" color="green" size="1" /> 
	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" size="20"/></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" size="50"/></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea name="bContent" rows="10" cols="80"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="���"/>&nbsp;&nbsp;<a href="list.do">�������</a></td>
			</tr>			
		</form>
	</table>
	</center>
</body>
</html>