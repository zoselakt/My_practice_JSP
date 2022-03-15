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
 JSP 특징
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
  
  servlet 특징
   - 동적 웹어플리케이션 컴포넌트
   - 확장자는 java
   - 클라이언트의 요청에 동적으로 작동한다.
   - java thread를 이용해서 동작한다.
   - MVC 패턴에서 controller로 이용됨
   
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
 -->

  Hello JSP!!!
</body>
</html>