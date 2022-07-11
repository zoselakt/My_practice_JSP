<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="ad_top.jsp" %>
	
	<ul>
		<li><a href = "<%=request.getContextPath()%>/admin/cat_input.jsp">쇼핑 카테고리 등록</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/catList.jsp">쇼핑 카테고리 리스트</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/prod_input.jsp">상품 등록</a></li>		
	</ul>	
<%@ include file="ad_bottom.jsp" %>