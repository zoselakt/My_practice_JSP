<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import ="shoppingMall.*,java.io.*"%>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    
<%
	request.setCharacterEncoding("euc-kr");
	MultipartRequest multi = null;
	
	String uploadPath = request.getRealPath("uploadFile");
	ProductDAO pdao = ProductDAO.getInstance();
	
	String msg="", url = "";
	try{
		multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "euc-kr", new DefaultFileRenamePolicy());
		
		int n = pdao.updateProd(multi);
		
		if(n > 0){
			msg ="상품 정보가 수정 완료 되었습니다..!!!";
			url ="prodList.jsp";
		}else{
			msg="상품정보 수정 처리가 되지 않았습니다!!!";
			url ="prodList.jsp";
		}
		
	}catch(IOException e){
		msg = "파일 업로드 실패!!!";
		url = "pordList.jsp";
	}catch(NumberFormatException e){
		msg = "상품 수량, 가격은 숫자로 입력하세요!!!!";
		url ="prodList.jsp";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
