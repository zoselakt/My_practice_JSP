<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import ="shoppingMall.ProductDAO, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
1. 파일 업로드 라이브러리 다운로드
  .http://www.servlets.com
  .com.oreilly,servlets메뉴를 선택
  .cos-26Dec2008.zip 파일을 다운로드
  
2. 위치지정
  . 압축을 푼후에 cos.jar파일
  . WebContent/WEB-INF/lib/에 복사
3. 업로드 파일을 저장하기 위한 폴더 생성
  .WebContent 폴더 내에 생성  
-->
<%
	request.setCharacterEncoding("euc-kr");
	String msg="", url="";
	
	String uploadPath = request.getRealPath("uploadFile");
	 
	int maxSize = 1024*1024*10; //10Mb
	String filename = "";
	String originFile = "";
	
	try{
		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize,"euc-kr",new DefaultFileRenamePolicy());

		ProductDAO pdao = ProductDAO.getInstance();
		int n = pdao.registerProduct(multi);
	
			if(n>0){
				msg = "상품등록 완료되었습니다.!!!!";
				url = "prodList.jsp";
			}else{
				msg = "상품등록 실패 했습니다...";
				url = "prod_input.jsp";		
			}
	}catch(Exception e){
		msg = "이미지 파일 업로드 실패!";
		url = "prod_input.jsp";
		e.printStackTrace();
	}
%>

<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>

