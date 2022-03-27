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
쿠키
쿠키는 사용자가 웹사이트를 처음 방문할 때 웹사이트에서 클라이언트의 컴퓨터에 저장해 놓은 작은 파일 / 다시접속시 빠르게 접속하기 위함.
http 프로토콜은 웹브라우저에 응답후에 일정한 시간이 지나면 접속을 끊는 특징이 있다. 이러한특징으로 쿠키가 등장하게 됨.
쿠키의 생성은 서버에서 생성한다. / 쿠키관리는 웹브라우저가 한다./ 기본용량 4kb, 저장할 수 있는 쿠키 300개로 제한

쿠키 관련 메소드
setMaxAge(): 쿠키 유효기간 설정
setPath(): 쿠키 사용을 위한 디렉토리 설정(특정 경로명을 갖는 URL로 전송하도록 설정)
setValue(): 쿠키값을 설정
setVersion(): 쿠키의 버전을설정
getMaxAge(): 쿠키의 유효기간 정보를 얻어옴
getName(): 쿠키 이름을 얻어옴
getPath(): 쿠키의 유효 디렉토리 정보를 얻어옴
getVersion(): 쿠키의 버전을 얻어옴
getCookies(): 쿠키데이터를 읽어올때 사용함, 웹브라우저가 보낸 쿠키를 배열로 반환하는 메소드

저장된 쿠키를 사용하는 순서
1. 웹 브라우저의 요청에서 쿠키를 얻어온다.
2. 쿠키는 이름, 값의 쌍으로 된 배열형태로 리턴된다. 리턴된 쿠키의 배열에서 쿠키의 이름을 가져온다.
3. 쿠키의 이름을 통해서 해당 쿠키의 설정된 값을 추출 

쿠키의 생성: 쿠키 클래스 사용 -> 쿠키속성 설정(setter) -> 쿠키의 전송 (response객체에 탑재: addCookie())
<%
	String cookieName = "id"; - 쿠키는 스트링값으로 생성
	Cookie cookie = new Cookie(cookieName, "test" - 쿠키 생성
	cookie.setMaxAge(60*30); -쿠키 유효기간 설정 (30분)
	response.addCookie(cookie); - 쿠키 전송
%>  

쿠키의 확인: 쿠키 배열 객체생성 -> 쿠키 값 확인
<%
	Cookie [] cookies = request.getCookies(); / response객체와 헷갈리면 안됨!
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			String str = cookies[i].getName();
			if(str.equals("id")){
			out.println("cookies["+i+"] name: "+ cookies[i].getName());
			out.println("cookies["+i+"] value: " + cookies[i].getValue());
			}
		}
	}
%>

쿠키의 삭제(수정): 쿠키 배열객체 생성 ->
<%
	Cookie[] cookies =request.getCookies();
	for(int i=0; i<cookies.length; i++){
		String str = cookies[i].getName();
		
		if(str.equals("id")){
			out.println("name: "+cookies[i].getName());
			cookies[i].setMaxAge(0); /수정
			response.addCookie(cookies[i]); / 탑재과정
		}
	}		
%>

쿠키를 이용한 회원인증처리 (DB에 이미 가입되어있는 것을 가정한 방법) - id, pw값을 미리 받아 처리(request.getParameter)
<%
if(id.equals("test") && pw.equals("1234")){
	Cookie cookie = new Cookie("id",id);
	cookie.setMaxAge(60*2);
	response.addCookie(cookie);
	response.sendRedirect("이동하고자하는 페이지.jsp");
	}else{
		response.sendRedirect("login.html");
	}
%>
--%> -->
</body>
</html>