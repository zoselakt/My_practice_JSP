<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	컨텍스트패스(context Path)
	- WAS에서 웹 어플리케이션을 구분하기 위한 path / 프로젝트를 생성하면 자동으로 server.xml에 추가된다.
	
	WAS(Web Application Server)에서 웹어플리케이션을 구분하기 위한 path
	- 이클립스에서 프로젝트를 생성할때마다 자동으로 server.xml에 입력을 한다.
	
	서블릿 초기화: ServletConfig 클래스
	- 특정 Servlet이 생성될때 초기에 필요한 데이터들(아이디, 특정경로)을 초기화하는 것을 서블릿초기화라고 한다.
	방법
	1. 초기화 파라미터(서블릿이 생성될때 필요한 데이터)는 web.xml에 기술한다.
		ServletConfig클래스를 이용해서 초기화 파라미터 사용이 가능하다.
	2. 초기화 파라미터를 web.xml 대신 Servlet 파일에 직접 기술하는 방법
	
	방법1: web.xml에 초기화 파라미터기술하기
	1. Servlet클래스 작성
	2. web.xml에초기화 파라미터를 입력
	3. ServletConfig의 getInitParameter()메소드를 이용해서 데이터를 사용(접근)한다.
	
	방식
	<servlet>
	<servlet-name>서블릿네임</servlet-name>
	<servlet-class>서블릿 경로</servlet-class>
	<init-param>
		(서블릿 초기파라미터값)
		<param-name></param-name>
		<param-value></param-value>
	<init-param>
	</servlet>
	<servlet-mapping>
	<servlet-name></servlet-name>
	<url-pattern></url-pattern>
	</servlet-mapping>
	
	방법2: Servlet파일에 초기화 파라미터를 직접기술하는 방법
	1. Servlet클래스 작성
	2. @webInitParam에 초기화 파라미터를 작성
	3. ServletConfig 메소드를 이용한다.
	
	방식	
	@webServlet()에  urlPatterns = {   }, initParams={@WebInitParam(파라미터 값 기입)} 추가
	
	---------------------------------------------------------------------------------------
	ServletContext를 이용한 데이터 공유
	
	여러개의 Servlet에서 데이터를 공유해야 할 경우에 contexxt parameter를 사용한다.
	web.xml파일에 데이터를 작성하면, Servlet에서 공유할 수있다.
	
	순서
	1. Servlet클래스 제작
	2. web.xml파일에 context parameter 기술
	3. ServletContext메소드를 이용해서 데이터를 사용한다.
	
	방식
	1.web.xml에 작성
		<context-param>
		<param-name> 파라미터 네임(id)</param-name>
		<param-value> 파라미터값(test1234) </param-value>
		</context-param>
		<context-param>
		<param-name> 파라미터 네임(password) </param-name>
		<param-value> 파라미터값(q1w2e3r4!) </param-value>
		</context-param>
	
	2. java파일 doget에 작성 
		String 파라미터 네임 = getServletContext().getInitParameter("파라미터 네임");
		web.xml에 작성한 만큼 생성후
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
------------------------------------------------------------------------------------------
	Servlet ContextListener
	- 웹어플리케이션을 감시하는 리스너 / 리스너의 해당하는 어플리케이션이 시작, 종료시에 호출된다.
	  	
	  Servlet의 LifeCycle은 Container가 담당한다
	  (init() / service 계열  method / destory() - 객체 생성, 초기화, 서비스, 소멸의 역할을  Container가 함). 
	   이 때, 초기화 단계에서 해야 하는 일들이 있다. 예를 들어, 파일을 직렬화하여 정보를 불러오거나, 초기 설정을 해주어야 한다. 
	   그리고 소멸할 때, 파일을 역직렬화해서 저장(백업) 해놓는 등의 작업이 필요하기 때문에, listener class가 유용하게 사용될 수 있다.
	  Servlet/JSP가 들어있는 Web application의 LifeCycle의 event를 관리할 수 있다 ! 
	 
	 방법
	 java파일 생성 후 생성된 class에  implement ServletContextListener 한다.
 -->
</body>
</html>