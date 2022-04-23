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
자바 빈(Bean)
- 정보의 덩어리, 즉 데이터 저장소(데이터 객체)
- 데이터를 저장하기 위한 필드와 데이터를 컨트롤하는 getter/setter메소드를 하나의 쌍으로 가지고 있는 클래스
- jsp는 다른 파일에서 객체를 가져와 쓸수 없어 자바빈즈를 통하여 프로퍼티를 저장하여 객체를 가져온다.

getter/setter메소드는 자바빈의 필드에 데이터를 저장하고 조회하는 작업을 한다.

자바빈 (빈(Bean)클래스) 만들기
- 패키지 선언 : com.test.Ex.클래스이름(빈 클래스명)
- 필드 선언: private String name / private String userid; /이름과 아이디를 저장할 필드선언
- getter/setter 메소드 정의 (프로퍼티 선언)
  프로퍼티: private 필드를 외부에서 접근하기 위해서 공개형 접근제어자 public으로 메소드를 정의해 놓고 이를 통해서 
  간접적으로 필드에 접근하는 방식 (필드 형태로 기술하고 간접적으로 메소드를 호출하는 것.)

자바빈 과 관련된 액션 태그
<jsp:useBean>: 자바 빈을 생성
<jsp:getProperty>: 자바 빈에서 정보를 얻어온다.
<jsp:setProperty>: 자바 빈에 정보를 저장한다.

자바 빈 기본형식 : usebean과 getproperty name을 일치해야한다.
- <jsp:useBean class="클래스 풀네임" id="자바 빈 이름" [scope="범위"(생략가능)] /> : 최상단 작성
<jsp:useBean class="com.test.ex.Person" id="person" scope="page" />

- <jsp:setProperty name="빈 이름" property="프로퍼티 이름" value="값" /> : 작성한 인자만큼 작성
<jsp:setProperty name="person" property="name" value="고길동" />
<jsp:setProperty name="person" property="age" value="30" />
<jsp:setProperty name="person" property="id" value="1515" />
<jsp:setProperty name="person" property="gender" value="남" />

<jsp:getProperty name="자바 빈 이름" property="프로퍼티 이름" /> / 회원의 이름을 얻기위해 getName()호출하는 것과 같음
이름 : <jsp:getProperty name="person" property="name" />
나이 : <jsp:getProperty name="person" property="age" />
아이디 : <jsp:getProperty name="person" property="id" />
성별 : <jsp:getProperty name="person" property="gender" />
 
자바 빈의 영역(Scope)
- page(기본값): 현재 페이지의 범위에만 한정, 페이지 처리가 끝나면 유효하지 않는다.
- request: 웹요청을 받고 처리를 완료할때 까지 유지되는 스코프 / 빈의 Scope는 request의 생명주기와 같다.
- session: 세션의 생명주기는 설정한 유효시간이다 / 웹 세션이 생성되고 종료될 때까지 유지되어 중첩되는 스코프
- application:웹의 서블릿 컨텍스트와 같은 범위로 유지(중첩)되는 (웹사이트가 실행되는 동안) 스코프 / 서버 종료해야 끝이남.  


자바 빈 스코프 사용과 빈 클래스 만들기 추가설명
- 받는 page에서는 useBean을 사용하여 주는 page와 동일한 scope 속성을 사용해야한다. 그래야 java코드를 사용할 수 있다. 
  하지만, Expression Language로 단순히 출력하기 위해서라면 useBean을 사용하지 않아도 객체에 접근 가능하다.

ex)  1번 jsp -> 2번 jsp - 3번jsp
   1번 jsp에서 보낸 값이 -> 2번 jsp에서 <jsp:forward> 3번 jsp를 호출하면 -> 1.jsp에서 보낸 값을 출력할수있다.
    scope 옵션을 두페이지 모두 "request"로 해주어야함.
    
* 계산식 보내는 페이지 작성
  1번jsp에서 페이지속성 html파일작성 -> 
  2번 jsp에서 기본 멤버변수,생성자,getter/setter 작성 (정보를 저장하는 빈 클래스 jsp파일) -> 
  3번 jsp작성 (1번jsp출력페이지 - 액션태그사용)
    
    
--%> -->

</body>
</html>