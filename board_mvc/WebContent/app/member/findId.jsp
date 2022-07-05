<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<style>
	input[type='button'], input[type='submit']{border-radius:0;}
	textarea{resize:none;}
	label{margin-top:3%;}
	div.preview{overflow:hidden;}
	div.preview img{width:90%; object-fit:cover; margin-left:10%;}
</style>
</head>
<body class="is-preload">
	<c:if test="${not empty param.code}">
		<script>
			alert("아이디 또는 비밀번호를 다시 확인해주세요.");
		</script>
	</c:if>
	<!-- Page Wrapper -->
	<div id="page-wrapper">

	<!-- Wrapper -->
	<div class="wrapper">
		<div class="inner">
			<jsp:include page="/app/fix/header.jsp"/>
		</div>
	</div>

	<!-- Wrapper -->
	<div class="wrapper">
		<div class="inner">

			<!-- Main -->
			<section class="main">
				<header class="major">
					<a href="#" class="image main"><img src="${pageContext.request.contextPath}/images/login01.png" alt="" /></a>
					<h1>아이디 찾기</h1>
				</header>
				<hr />
				<form method="post" action="${pageContext.request.contextPath}/member/MemberFindIdOk.me" name="loginForm">
					<div style="display:flex; justify-content:space-evenly;">
						<div style="width:40%">
								<div>
									<div class="col-6 col-12-xsmall" style="width:100%">
										<p style="margin:0;">이메일 </p>
										<input type="text" name="memberEmail" id="memberEmail" value=""/>
										<br>
										<p style="margin:0;">비밀번호</p>
										<input type="password" name="memberPw" id="memberPw" value=""/>
									</div>
								</div>
								<div class="col-12">
									<ul class="actions" style="display:block; text-align:center; margin-top:9%">
										<li><input type="button" value="아이디 찾기" class="primary" style="width:100%; font-size:1em;" onclick="check()"/></li>
									</ul>
								</div>
							</div>
							<div class="preview" style="width:40%">
								<img src="${pageContext.request.contextPath}/images/login02.png">
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script>
	function check(){
		let form = document.loginForm;
		if(!form.memberEmail.value){
			alert("이메일을 입력해주세요");
			return;
		}
		if(!form.memberPw.value){
			alert("비밀번호를 입력해주세요");
			return;
		}
		form.submit();
	}

</script>
</html>