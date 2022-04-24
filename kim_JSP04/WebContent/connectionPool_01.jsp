<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
커넥션 풀
- 데이터베이스와 연결된 커넥션을 미리 만들어서 풀(pool) 속에 저장해 두고 있다가, 필요할때에 커넥션을가져다 쓰고 다시 풀에 반환하는 기능을 의미.
사용 순서
1. 풀에서 커넥션을 가져온다.
2. 커넥션을 사용한다.
3. 풀에 커넥션을 반납한다.

특징
- 미리 만들어져 있기 때문에 커넥션을 생성하는시간이 소비되지 않는다.
- 커넥션을 계속해서 재사용하기 때문에 생성되는 커넥션 수가 많지 않다.

-> 커넥션을 생성하고 닫는 시간을 줄일 수 있기 때문에 그 만큼 어플리케이션의 실행속도가 빨라지는 장점이 있다.
한번에 생성할 수 있는 커넥션의 수를 정할 수 있기 때문에 동시에 접속자 수가 몰려도 웹 어플리케이션이 쉽게 다운되지 않는 특징이 있다.

동시접속자 처리방법
커넥션 풀에서 생성되어 있는 커넥션의 갯수는 한정적이다. 동시에 접속자 수가 많아지면 남아있는 커넥션이 없기 때문에
클라이언트는 대시 상태로 전환된다. 커넥션이 반환이 되면 대기하고 있는 순서대로 커넥션이 제공된다.

커넥션 풀의 속성
커넥션 풀은 여러속성을 이용하여설정할 수 있다.
maxActive: 커넥션 풀이 제공할 수 있는 커넥션의 갯수
whenExhaustedAction: 커넥션풀에서 가져올 수 있는 커넥션이 없을때 어떻게 동작할지를 설정하는 속성 
					 0: 에러발생, 
					 1: maxWait속성에서 지정한 시간만큼 커넥션을 얻을 때까지 기다림
					 2: 일시적으로 커넥션을 생성해서 사용
maxWait: whenExhaustedAction 속성 값이 1일때 사용되는 대기시간을 지정 / 1/1000초 단위, 0보다 작을경우 무한대기
maxIdle: 사용되지 않고 풀에 저장될 수 있는 최대 커넥션의 갯수, 음수일 경우 제한이 없음.
minIdle: 사용되지 않고 풀에 저장될 수 있는 최소 커넥션의 갯수
testOnBorrow: true일 경우 커넥션 풀에서 커넥션을 가져올 때 커넥션의 유효성 여부를 검사
testOnReturn: true일 경우 커넥션 풀에 커넥션을 반환할 때 커넥션이 유효한지 여부를 검사

커넥션 풀을 사용하기 위한 톰켓컨테이너 설정방법
context.xml 파일에 다음과 같이 코드를 추가한다.
<!-- 
<ConText>
<Resource
auth="Container"
driverClassName = "oracle.jdbc.driver.OracleDriver"
url = "jdbc:oracle:thin:@localhost:1521:xe"
username = "hr"
password = "hr"
name = "jdbc/Oracle11g"
type = "javax.sql.DataSource"
maxActive = "50"
maxWait = "1000"
/>
</ConText>
-->

java프로그램에서 DB접속하는 방법 (크게 2가지로 분류)
1. JDBC를 이용하는 방법 (ConnectionPool Bean 이용)
	- Connection클래스를 이용하여 DB에 접속 / 커넥션 객체를 생성하고 커넥션 객체를이용해 DB를 제어한다.
2. WAS에서제공하는 Connection Pool을 사용하는 방법
	- 사용자(개발자)가 콛에서 직접DB에 연결하는 것이 아니라, 연결을 WAS(톰캣)가 하고, 사용자는 WAS가 연결한 커넥션을 이욯하는 방법
	
	WAS가 시작하면서 동시에 데이터베이 커넥션 객체를 미리생성하고 개발자는 그 객체를 가져다 쓰는것.
	DataSource를 이용하는 방법이 커넥션 풀 방법이다. /JDBC처럼 아이디와 비밀번호 작성은 하지않는다.
	WAS가 만들어 놓은 커넥션은 각각 커넥션 마다 이름이 있다.
	
	Context 객체를 생성한다.
	lookup메소드를 이용해서 매칭되는 커넥션을 찾는다.
	DataSource.getConnection()이용해서 커넥션을 확보한다.
</body>
</html>