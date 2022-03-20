<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 
 JSP Ư¡ (Java Servlet Page)
   - ���� �����ø����̼� ������Ʈ
   - Ȯ���ڴ� jsp
   - Ŭ���̾�Ʈ�� ��û�� �������� ������ �ϸ�, ������ html�� ������ �Ѵ�.
   - jsp ������ �������� ��ȯ�Ǿ� ����Ǿ�����.
   - MVC ���Ͽ��� view�� �̿��
	
  JSP ���۰���
  1. jsp ���� ��û 
  2. jsp �����̳ʷ� ���� : �������̳ʷ� jsp������ �ѱ��.	
  3. jsp ���� �Ľ�(�м�) : �ش� jsp������ ó�� ��û�Ȱ��̸� ������ �Ľ��Ѵ�.
        ������ ��û�Ǿ��� �������� ��쿡�� 6���ܰ�� �Ѿ��. 
  4. �������� ��ȯ : ���ο� �ڹ������� �����Ѵ�.
  5. Ŭ���� ���� ���� : ���� ����(�ڹ�����)�� ���� ������ ������ Ŭ���� ����
        �� ������ �ȴ�.
  6. �޸𸮿� �ε��� : Ŭ���� ������ �޸𸮿� �ε���
  7. html ���� : Ŭ���� ���Ͽ� ���� ���� ����� �ٽ� �������� �Ѱ�����.
       �������� html ���·� ����ڿ��� ������ �Ѵ�.
  8. �������� html���� �Ǿ���
  
  Servlet�̶�?
   - servlet interface�� implements�Ͽ� ������ �ڹ� Ŭ����
   - ������ ���������� ���� ������ �ϸ� ��������ڿ� ���� ȣ�� �� �� �ִ�.
   - ������ �ν��Ͻ��� ��Ȱ���� �����ϴ�.
  
  servlet Ư¡
   - ���� �����ø����̼� ������Ʈ
   - Ȯ���ڴ� java
   - Ŭ���̾�Ʈ�� ��û�� �������� �۵��Ѵ�.
   - java thread�� �̿��ؼ� �����Ѵ�.
   - MVC ���Ͽ��� controller�� �̿��
   
  Servlet �ۼ� ��Ģ
   - ���� javax.servlet.httpServlet Ŭ������ ����ؾ� �Ѵ�.
   - doGet �Ǵ� doPost�޼��带 �����ؾ��Ѵ�.
   - doGet �Ǵ� doPost�޼����� �ι�° ���ڸ� �̿��Ѵ�.
   
  Servlet ���ۼ���
   �� ������ -> ������ -> �� ���ø����̼� ���� -> ���� �����̳� (������ ����, servlet ��ü����)
   
   Servlet ���: CGI�� ����� �� �ִ� �ڹ� ���(������ CGI�� ������)
   1) ���� CGI�� �ε��� �ʱ�ȭ �۾��� �����ϱ� ������ ������ ���� ������尡 ũ��.
     - ���� > �ѹ� �޸𸮿� �ε��Ǿ� ����Ǹ� �۾��� ��� ����Ǿ�, �������� �޸𸮿��� ��ü���� �ʴ´�.(��Ȱ��)
            ������� ���� ��û�� ���͵� �޸� �ε��̳� �ʱ�ȭ�� ó������ �ʴ´�.
            ��� ������ �ѹݸ� �޸𸮿� �ε��Ǿ�����.
      
   2) Ư�� �� ������ ���������̴�.
   - �ڹپ��� �����Ǵ� ���α׷��̱� ������ �÷���(�ü��)���� ������ ���� ������ ���� �� �ִ�.
         ������ CGI�� ��������� �ϱ� ���ؼ� �߰����� API�� �ʿ��ߴ� �Ϳ� ���ؼ� 
         ������ Servlet API�� Ȱ���ؼ� �����ϸ�ȴ�. Servlet������ Ȱ���ص� �ȴ�.
         
   3) ������ ��Ƽ ������� �����Ѵ�.
   - Servlet�� CGIó�� �� �������� ���� ��û�� ���� ������ ���μ����� �������� �ʴ´�. �� ��û�� ���ؼ� ������� ����
   
   Servlet�� ���� �ֱ�(life ����Ŭ)
   Servlet ��ü���� -> init() ȣ�� -> service(), doGet(), doPost() ȣ�� -> destroy() ȣ��    
   
   URL ����
   ���� ���
   1.web.xml���� �����ϴ� ���
   <servlet>
   	<servlet-name> ���� �̸� </servlet-name>
   	<servlet-class> src�� ���ϰ�� (com.test.ex.Hello) </servlet-class>
   </servlet>
   
   <servlet-mapping>
      	<servlet-name> ���� �̸� </servlet-name>
      	<url-pattern>/he(������ �̸�) (�׻�/�� �տ��ٴ´�)<url-pattern>
   </servlet-mapping>
   
   2. ������̼��� �̿��ϴ� ��� (@WebServlet(/������ �̸�))
   
/-----------------------------------------------------------------------------
   http Response / Request
   HttpServletRequest : ������� ������ ���� ������ �����ϴ� ��ü
    - �Ķ������ �̸��� ��
    - ����� ��ǻ�� �̸�
    - ��û�޴� ������ �̸�
    - input type�� ������
    - �޼ҵ�: getParameterValues(), getParameter(), getRomoteHost(), getServerName()
    
   HttpServletResponse: �������� ���� ������ ��ȣȭ�ؼ� ����ڿ��� �����ϴ� ��ü
    - �������� ���Ǵ� content�� ����
    - �������� ���Ǵ� content�� Ÿ��, ȭ�鿡 ����ؾ� �� ��簪
    - �޼ҵ�: setContentType(String type), setContentLength(int length), getWriter()
    
    doGet�޼ҵ� ȣ��
    1. html form�±׿��� method=get�϶� ȣ��
    2. �ּ�â���� servlet URL�� �Է��Ҷ� ȣ�� ����
    
    doGet�޼ҵ� ��� 
    PrintWriter �޼ҵ�� = response.getWriter(); // �� �������� ����� ��Ʈ���� ������ ����
    out.println("<html>");
    out.println("</html>");
    
    
    doPost�޼ҵ� ȣ��
    1. html form�±׿��� method=post�϶� ȣ��
    
    
    
 -->
 
 
 

  Hello JSP!!!
</body>
</html>