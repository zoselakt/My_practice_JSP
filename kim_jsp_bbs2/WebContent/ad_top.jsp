<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style.css">


</head>
<body>
<center>
<hr />
	<h2>������ ������</h2>
	<hr />
	
	<table width=800>
	<tr>
	  <td>
	  	<a href="<%=request.getContextPath()%>/ad_main.jsp">������Ȩ</a>
	  </td>
	  <td>
	  	<a href="<%=request.getContextPath()%>/userPage/main.jsp">���θ�Ȩ</a>
	  </td>
	  <td>
		<a href ="<%=request.getContextPath()%>/admin/cat_input.jsp">ī�װ� ���</a>
	  </td>
	  <td>
		<a href ="<%=request.getContextPath()%>/admin/catList.jsp">ī�װ� ���</a>
	  </td>
	  <td>
		<a href ="<%=request.getContextPath()%>/admin/prod_input.jsp">��ǰ ���</a>
	  </td>
	  <td>
		<a href = "<%=request.getContextPath()%>/admin/prodList.jsp">��ǰ ����Ʈ</a>		
	  </td>
	</tr>
	
	</table>