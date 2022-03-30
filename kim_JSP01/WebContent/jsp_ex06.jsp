<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <%-- 
예외 처리
예외상황이 발생하면 웹컨테이너(톰캣)에서는 예외페이지를 제공한다.

에러코드
100: continue
200: ok, 에러 없이 전송성공
307: 임시로 페이지가 리다이렉트 됨
400: 접근 허용되지 않음.
404: 요청한 페이지가 없음.
500: 서버내부의 에러(JSP에서 예외가 발생하는 경우)
503: 서버 과부하( 서버 유지보수 차원에서 일시적으로 중지시킨 경우)

예외처리방법
1. page지시자 이용하는 방법
- 예외발생 페이지에서 설정할 코드 : <%@ page errorPage="error.jsp" %>
- 예외처리 페이지에서 설정할 코드 : <%@ page isErrorPage= "true"%> / <%response.setStatus(200);%> 

2. web.xml 설정해서 예외처리 하기
- 

<error-page>
	<error-code>404</error-code>
	<location>/404error.jsp</location>
<error-page>	
<error-page>
	<error-code>500</error-code>
	<location>/500error.jsp</location>
<error-page>	
--%> -->
</body>
</html>