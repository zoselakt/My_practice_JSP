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
세션
쿠키와 마찬가지로 서버와의 connection 관계를 유지하기 위해서 이용자 정보를 저장하는 객체
세션은 서버에서만 접근이 가능, 따라서 쿠키보다 보안성이 뛰어나다.
쿠키에 비해 세션은 데이터에 대한 제한이 없다.

관련 메소드
setAttribute(): 세션의 속성 설정 / session.setAttribute("id","test");
getAttribute(): 세션에서 데이터를 얻을 때(세션의 속성을 사용할 때) 리턴타입은 object/ (String)session.getAttribute("id");
getAttributeNames(): 세션에 저장되어 있는 모든 데이터의 이름을 얻어올 때
removeAttribute(): 세션에서 특정 데이터를 제거한다. / session.removeAttribute("id");
invalidate(): 세션의 모든 데이터를 삭제한다. / session.invalidate();
getId(): 자동생성된 세션 아이디를 얻어올때 사용한다.
isNew(): 세션이 최초로 생성되었는지 여부를 알고자 할때
getMaxInactiveInterval(): 세션의 유효시간을 얻어 올떄

사용방법
파라미터를 얻어 온다(getParameter) -> 세션의 속성을 설정한다.(setAttribute) -> 세션의 속성을 사용한다.(getAttribute) 
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	session.setAttribute("id", id);
	session.setAttribute("password", pw);
%>

같은 페이지에서 출력할때
	id속성의 값은 <%=(String)session.getAttibute("id");%> 
	pw속성의 값은 <%=(String)session.getAttibute("pw");%>

getAttribute()메소드 사용
	Object idObj = session.getAttribute("id"); / 객체 생성시
	String id = (String)idObj;
	out.println(id);

	Object pwObj = session.getAttribute("password"); / 객체 생성시
	String pw = (String)pwObj;
	out.println(pw);
	
getAttributeNames() 메소드 사용
	String sName, sValue;
	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElement()){
		sName = enumeration.nextElement().toString();
		sValue = session.getAttribute(sName).toString();
		out.println("세션네임: " + sName);
		out.println("세션값: " + sValue);
	}
	
getId() 메소드 사용
String sID = session.getId();
out.println("세션 ID: "+ sID);
int sInterval = session.getMaxInactiveInterval();
out.println("세션 유효시간: sInterval);

removeAttribute() 메소드 사용
session.removeAttribute("id"); /세션 네임삭제
session.removeAttribute("pw"); /세션 pw삭제

invalidate() 메소드사용
session.invalidate();


	
--%> -->
</body>
</html>