<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shoppingMall.*,java.util.*"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width=700 align="center" border=1>
  <!--���� �׺������-->
	<tr>
		<td colspan="2"><a href="<%=request.getContextPath()%>/userPage/main.jsp">���θ� HOME</a> | 
			<a href="#">�α���</a> |
			<a href="<%=request.getContextPath()%>/adminLogin.jsp">������</a>		
		</td>
	</tr>
	<tr>
		<td width="350" align="center" valign="top">
			<!-- ī�װ���� -->
			<table width="100%" border="1">
			<%
				CategoryDAO cdao= CategoryDAO.getInstance();
				ArrayList<CategoryDTO> cdtos = cdao.categoryAll();
				
				if(cdtos !=null && cdtos.size()!=0){
					for(CategoryDTO cdto:cdtos){
						String cname=cdto.getCname();
						String code = cdto.getCode();			
			%>
					<tr>
					   <td>
					      <a href="catList.jsp?category_fk=<%=code%>&cname=<%=cname%>"><%=cname%></a>
			           </td>
			        </tr>    
			<%			
					}//for
				}else{
					 out.println("<tr><td>ī�װ������� ����!!!</td></tr>");
				}//if
			%>
			</table>
		</td> 
		<td>