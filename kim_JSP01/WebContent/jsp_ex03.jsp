<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <%-- (%--jsp주석--%)
JSP 태그 
   지시자(Directive): <%@ %> : 페이지 속성
   지시자 종류  / 속성
   1. page 지시자
      - info(페이지설명): <%@ page info= "copyrights by ~~" %>
      - language(페이지 언어):  <%@ page language="java" %>
      - contentType(페이지출력형태-인코딩속성): <%@ contentType="text/html; charset=UTF-8" %>
      - extends(jsp가 서블릿으로 변환될때 상속받을 클래스를 지정하는 속성/기본적으로 컨테이너가 자동상속): 사용빈도 ↓ / 설명x
      - import(다른 패키지에 있는 클래스 사용): <%@ page import="java.util.*, java.sql.*" %>
      - session: (HttpSession 속성 사용여부) <%@ page session = "true" 또는 "false" %>
      - buffer: JSP페이지의 출력 크리를 KB단위로 지정하는 속성, 기본 8KB / 설명 x
      - autoFlush: 기본값 true이고, 버퍼가 다 찼을 경우 자동적으로 버퍼를 비우는 속성 / 설명x
      - isThreadSafe: 여러개의 요청을 처리할 지 여부를 결정 / 사용빈도 ↓ / 설명x
      - errorPage: 예외처리를 할 페이지의 URL 지정 / 설명 x
      - isErrorPage: 에러 페이지를 담당하는 페이지인지 여부를 지정하는 속성 / 설명 x
      - pageEncoding: 컨텐츠 타입의 charset과 같다. 사용빈도 ↓ <%@ page pageEncoding="UTF-8" %>
      
      ** JSP 페이지가 자동으로 임포트하는 패키지
      	- javax.servlet
      	- javax.servlet.jsp
      	- javax.servlet.http
      	
   2. include 지시자
   	  - 현재의 jsp페이지에 다른 jsp 페이지나 html문서를 불러와서 현재 페이지의 일부로 사용할 때 사용 / file 속성을 이용해서 지정한다.
	  - <%@ include file="aaa.java" %>
	  
   3. taglib 지시자
   	  - 액션을 사용할 때 필요한 지시자 / 액션을 사용할 때 기본적으로 사용할 수 있고, 라이브러리를 설치해야만 사용할 수 있는 액션도 있다.
   	  - <%@ taglib prefix="c" uri="http://oracle.com/jsp/jstl/core"%>
   

   스크립팅 요소(스크립틀릿, 익스프레션, 선언부)
- 스크립틀릿: <% %> : 자바코드를 넣을수 있음.
- 익스프레션: <%= %> : 결과값을 출력할 수 있음.
- 선언부: <%! %>: 변수, 메소드등을 선언할 수 있음.
  
 

    액션 태그: 페이지 내에서 어떤 동작을 하도록 지시하는 태그를 의미한다./ 웹 컨테이너에서 실행되고 결과만 웹브라우저에 전달되어 출력된다.
    종류
  <jsp:forward> </jsp:forward>: 페이지 이동  
  <jsp:action> </jsp:action>: 자바 빈 연결 
  <jsp:include> </jsp:include>: 페이지를 이동하지 않고 페이지의 내용을 포함하여 출력
  <jsp:param> </jsp:param>: forward / include 할 때 값을 넘길때 사용  
  
  - 표준액션: jsp 페이지에서 바로 사용할 수 있는 액션 / 사용 예: <jsp:include page="a.jsp"> jsp접두어는 표준액션을 의미 
  - 커스텀액션: 별도의 라이브러리를 설치해서 사용하는 액션 / 사용 예: <c: set var="i" value"0"/>
    
    표현식: 변수의 값이나 메소드의결과값을 출력할때 사용한다. / 표현식의 결과값은 String 타입이다. / 끝에;를 붙이지 않는다.

-------------------------------------------------------------------------------------------------
jsp 내부 객체
- 객체를 생성하지 않고 바로 사용할 수 있는 객체를 의미
- jsp에서 제공되는 내부객체는 jsp 컨테이너에 의해 servlet으로 변환될 때 자동으로 객체가 생성된다.

내부객체 종류
1. 입출력 객체
   ㄱ. request: doGet, doPost메서드의 첫번째 파라미터와 동일한 역할 / 사용자(클라이언트)의 요청을 관리하는 객체
  	- 관련 메소드
  		getContextPath(): 웹 어플리케이션의 컨텍스트 패스를 얻어올때 사용하는 메소드
  		getSession(): 세션 객체를 얻을 때 사용하는 메소드
  		getProtocol(): 해당 프로토콜을 얻어올때 사용하는 메소드
  		getRequestURL(): 요청한 URL을 얻어올때 사용하는 메소드
  		getRequestURI(): 요청 URI를 얻어올 때 사용하는 메소드
  		getQuerySring(): 쿼리스트링을 얻을 때 사용하는 메소드
사용 예) out.println("요청방식" + request.getMethod()) / out.println("URI" + request.getRequestURI())
    - 관련 메소드(파라미터 메소드 / 사용 ↑)
    	getParameter(String name): name에 해당하는 파라미터의 값을구할 때 사용 
    	getParameterNames(): 모든 파라미터의 이름을 얻어 올때 사용
    	getParameterValues(String name): name에 해당하는 파라미터의 값들을 얻어올 수 있다.(반환타입은 배열)
사용 예) name = request.getParameter("name"); : html파일의 name값과 동일하게 맞춰야한다.
	  hobbys = request.getParameterValues("hobby"); : 배열의 출력은 Arrays.toString(hobbys) 하여야한다.
    	
  ㄴ. response: doGet, doPost메서드의 두번째 파라미터와 동일한 역할
  	- 관련 메소드
	  	getCharacterEncoding(): 인코딩을 얻어올떄
	  	addCookie(Cookie): 쿠키를 지정할 떄
	  	sendRedirect(URL): 이동하고자 하는 URL을 지정할 떄
사용 예) <%! int age; %> (19세 미만일 경우 다른 페이지로 이동하는 예제)
 		<% String str = reqeust.getParameter("age"); age = Integer.parseInt(str); 
 		if (age >= 19){ response.senRedirect("이동할페이지파일.jsp"); }
 		else { response.sendRedirect("이동할 페이지 파일. jsp"); } %>
 		
  ㄷ. out: 웹 브라우저로 html코드를 출력하는 기능
  
2. 서블릿 객체
- page: jsp 페이지로부터 생성된 서블릿
- config: jsp 페이지의 구성정보를 가져오는 기능
3. 세션 객체
- session: 세션과 관련된 기능
4. 예외 객체
- exception: 예외처리와 관련된 기능

--%> -->
</body>
</html>