<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.io.*, shoppingMall.*"%>
    
    <%
    	String pnum=request.getParameter("pnum");
    	if(pnum==null || pnum.trim().equals("")){
    		response.sendRedirect("prodList.jsp");
    		return;
    	}//if
    	
    	String pimage = request.getParameter("pimage");
    	String imgPath = application.getRealPath("uploadFile");
    	
    	File dfile = null;
    	
    	if(pimage != null){
    		dfile = new File(imgPath+"/"+pimage);
    		System.out.println("�������� :"+dfile);
    		if(dfile.exists()){
    			if(dfile.delete()) out.println("�̹������� ���� �Ϸ�");
    		}
    	}//if
    	
    	
    	//���� ����Ͻ� ���� ȣ��
    	ProductDAO pdao = ProductDAO.getInstance();
    	int n = pdao.delProd(pnum.trim());
    	
    	String msg="", url="prodList.jsp";
    	if(n > 0){
    		msg="��ǰ ���� ó���� �Ϸ� �Ǿ����ϴ�!!!!";
    	}else{
    		msg="��ǰ ���� ����!!!";
    	}
    %>
    <script type="text/javascript">
    	alert("<%=msg%>");
    	location.href="<%=url%>";
    </script>
    
    
    