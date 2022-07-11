<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import ="shoppingMall.ProductDAO, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
1. ���� ���ε� ���̺귯�� �ٿ�ε�
  .http://www.servlets.com
  .com.oreilly,servlets�޴��� ����
  .cos-26Dec2008.zip ������ �ٿ�ε�
  
2. ��ġ����
  . ������ Ǭ�Ŀ� cos.jar����
  . WebContent/WEB-INF/lib/�� ����
3. ���ε� ������ �����ϱ� ���� ���� ����
  .WebContent ���� ���� ����  
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
				msg = "��ǰ��� �Ϸ�Ǿ����ϴ�.!!!!";
				url = "prodList.jsp";
			}else{
				msg = "��ǰ��� ���� �߽��ϴ�...";
				url = "prod_input.jsp";		
			}
	}catch(Exception e){
		msg = "�̹��� ���� ���ε� ����!";
		url = "prod_input.jsp";
		e.printStackTrace();
	}
%>

<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>

