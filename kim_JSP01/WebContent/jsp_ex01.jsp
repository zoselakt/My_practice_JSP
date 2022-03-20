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
 JSP 특징 (Java Servlet Page)
   - 동적 웹어플리케이션 컴포넌트
   - 확장자는 jsp
   - 클라이언트의 요청에 동적으로 동작을 하며, 응답은 html로 응답을 한다.
   - jsp 파일은 서블릿으로 변환되어 실행되어진다.
   - MVC 패턴에서 view로 이용됨
	
  JSP 동작과정
  1. jsp 파일 요청 
  2. jsp 컨테이너로 전송 : 웹컨테이너로 jsp파일을 넘긴다.	
  3. jsp 파일 파싱(분석) : 해당 jsp파일이 처음 요청된것이면 파일을 파싱한다.
        이전에 요청되었던 페이지일 경우에는 6번단계로 넘어간다. 
  4. 서블릿으로 변환 : 새로운 자바파일을 생성한다.
  5. 클래스 파일 생성 : 서블릿 파일(자바파일)은 실행 가능한 상태의 클래스 파일
        로 컴파일 된다.
  6. 메모리에 로딩됨 : 클래스 파일은 메모리에 로딩됨
  7. html 전송 : 클래스 파일에 대한 실행 결과는 다시 웹서버로 넘겨진다.
       웹서버는 html 형태로 사용자에게 응답을 한다.
  8. 브라우저에 html실행 되어짐
  
  Servlet이란?
   - servlet interface를 implements하여 생성한 자바 클래스
   - 서블릿은 서블릿엔젠에 의해 등장을 하며 여러사용자에 의해 호출 될 수 있다.
   - 서블릿의 인스턴스는 재활용이 가능하다.
  
  servlet 특징
   - 동적 웹어플리케이션 컴포넌트
   - 확장자는 java
   - 클라이언트의 요청에 동적으로 작동한다.
   - java thread를 이용해서 동작한다.
   - MVC 패턴에서 controller로 이용됨
   
  Servlet 작성 규칙
   - 서블릿 javax.servlet.httpServlet 클래스를 상속해야 한다.
   - doGet 또는 doPost메서드를 구현해야한다.
   - doGet 또는 doPost메서드의 두번째 인자를 이용한다.
   
  Servlet 동작순서
   웹 브라우저 -> 웹서버 -> 웹 어플리케이션 서버 -> 서블릿 컨테이너 (스레드 생성, servlet 객체생성)
   
   Servlet 기술: CGI를 대신할 수 있는 자바 기술(기존의 CGI의 차이점)
   1) 기존 CGI의 로딩과 초기화 작업을 진행하기 때문에 서버에 대한 오버헤드가 크다.
     - 서블릿 > 한번 메모리에 로딩되어 수행되면 작업이 모두 수행되어, 끝나더라도 메모리에서 해체되지 않는다.(재활용)
            계속적인 수행 요청이 들어와도 메모리 로딩이나 초기화를 처리하지 않는다.
            모든 서블릿은 한반만 메모리에 로딩되어진다.
      
   2) 특정 웹 서버에 비의존적이다.
   - 자바언어로 구현되는 프로그램이기 때문에 플랫폼(운영체제)과는 무관한 실행 파일을 만들 수 있다.
         기존의 CGI는 성능향상을 하기 위해서 추가적인 API가 필요했던 것에 비해서 
         서블릿은 Servlet API를 활용해서 개발하면된다. Servlet엔진만 활용해도 된다.
         
   3) 서블릿은 멀티 스레드로 동작한다.
   - Servlet은 CGI처럼 웹 브라우저로 부터 요청에 대해 각각의 프로세스를 생성하지 않는다. 각 요청에 대해서 스레드로 동작
   
   Servlet의 생명 주기(life 사이클)
   Servlet 객체생성 -> init() 호출 -> service(), doGet(), doPost() 호출 -> destroy() 호출    
   
   URL 맵핑
   맵핑 방법
   1.web.xml에서 서블릿하는 방법
   <servlet>
   	<servlet-name> 서블릿 이름 </servlet-name>
   	<servlet-class> src내 파일경로 (com.test.ex.Hello) </servlet-class>
   </servlet>
   
   <servlet-mapping>
      	<servlet-name> 서블릿 이름 </servlet-name>
      	<url-pattern>/he(맵핑할 이름) (항상/가 앞에붙는다)<url-pattern>
   </servlet-mapping>
   
   2. 어노테이션을 이용하는 방법 (@WebServlet(/맵핑할 이름))
   
/-----------------------------------------------------------------------------
   http Response / Request
   HttpServletRequest : 사용자의 정보를 서블릿 엔진에 전달하는 객체
    - 파라미터의 이름과 값
    - 사용자 컴퓨터 이름
    - 요청받는 서버의 이름
    - input type의 데이터
    - 메소드: getParameterValues(), getParameter(), getRomoteHost(), getServerName()
    
   HttpServletResponse: 서버에서 만든 응답을 암호화해서 사용자에게 전달하는 객체
    - 응답으로 사용되는 content의 길이
    - 응답으로 사용되는 content의 타입, 화면에 출력해야 할 모든값
    - 메소드: setContentType(String type), setContentLength(int length), getWriter()
    
    doGet메소드 호출
    1. html form태그에서 method=get일때 호출
    2. 주소창에서 servlet URL을 입력할때 호출 가능
    
    doGet메소드 출력 
    PrintWriter 메소드명 = response.getWriter(); // 웹 브라우저에 출력할 스트림을 얻어오는 과정
    out.println("<html>");
    out.println("</html>");
    
    
    doPost메소드 호출
    1. html form태그에서 method=post일때 호출
    
    
    
 -->
 
 
 

  Hello JSP!!!
</body>
</html>