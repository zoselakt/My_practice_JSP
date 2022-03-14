<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
<title>회원가입</title>
</head>
<body class="is-preload">
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
						<a href="javascript:void(0)" class="image main"><img src="${pageContext.request.contextPath}/images/join01.png"></a>
						<h1>회원가입</h1>
						<p>
							환영합니다 고객님<br>
							회원가입 후 정상적인 서비스를 이용하실 수 있습니다.
						</p>
					</header>
					<hr>
					<form method="post" action="${pageContext.request.contextPath}/member/MemberJoinOk.me" name="joinForm">
						<div style="display:flex; justify-content:space-around;">
							<div style="width:40%;">
								<p style="background:#fd3a3a2e">
									<span style="color:red; font-size:2rem; font-weight:bold">*</span>
									아래 항목은 모두 작성해주세요.
								</p>
								<div>
									<div class="col-6 col-12-xsmall" style="width:100%">
										<p style="margin:0">
											아이디 <span id="idCheck_text" style="font-size:0.7em"></span>
										</p>
										<input type="text" name="memberId" id="memberId" value="" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합"/>
										<br>
										<p style="margin:0">비밀번호</p>
										<input type="password" name="memberPw" id="memberPw" value="" placeholder="영문 4자 이상, 최대 20자"/>
										<br>
										<div style="display:flex; justify-content:space-between;">
											<div style="width:48%">
												<p style="margin:0">이름</p>
												<input type="text" name="memberName" id="memberName" value="">
											</div>
											<div style="width:48%">
												<p style="margin:0">나이</p>
												<input type="text" name="memberAge" id="memberAge" value="">
											</div>
										</div>
										<hr>
										<div style="margin-top:6%; margin-bottom:6%">
											<input type="checkbox" id="term" name="term">
											<label for="term" style="font-size:1.1em; font-weight:bold;">전체 동의합니다.</label>
										</div>
										<div class="col-12" style="display:flex; justify-content:space-between">
											<div>
												<input type="checkbox" id="term1" name="term1" class="terms">
												<label for="term1">서비스 이용약관</label>
											</div>
											<div class="term-detail">
												<a href="term1-content">펼쳐보기</a>
											</div>
										</div>
										<textarea name="term1-content" id="term1-content" rows="3" style="display:none"></textarea>
										<br>
										<div class="col-12" style="display:flex; justify-content:space-between">
											<div>
												<input type="checkbox" id="term2" name="term2" class="terms">
												<label for="term2">개인정보 수집 및 이용</label>
											</div>
											<div class="term-detail">
												<a href="term2-content">펼쳐보기</a>
											</div>
										</div>
										<textarea name="term2-content" id="term2-content" rows="3" style="display:none"></textarea>
										<br>
									</div>
								</div>
								<hr>
								<p style="background:#3a6afd2e">
									아래 항목은 선택 사항입니다.
								</p>
								<p style="margin:0">성별</p>
								<div class="col-4 col-12-small">
									<input type="radio" id="male" name="memberGender" value="남자">
									<label for="male">남자</label>
									<input type="radio" id="female" name="memberGender" value="여자">
									<label for="female">여자</label>
									<input type="radio" id="none" name="memberGender" value="선택안함" checked>
									<label for="none">선택안함</label>
								</div>
								<p style="margin:0;">이메일</p>
								<input type="text" name="memberEmail" id="memberEmail" value="">
								<br>
								<p style="margin:0">우편번호</p>
								<div style="display:flex; justify-content:space-between;">
									<input type="text" name="memberZipcode" class="postcodify_postcode5" value="">
									<ul class="actions">
										<li>
											<input type="button" id="postcodify_search_button" class="button primary" style="border-radius:0;" value="검색">
										</li>
									</ul>
								</div>
								<p style="margin:0">주소</p>
								<input type="text" name="memberAddress" id="memberAddress" class="postcodify_address" value="">
								<br>
								<p style="margin:0">상세주소</p>
								<input type="text" name="memberAddressDetail" id="memberAddressDetail" class="postcodify_details" value="">
								<br>
								<p style="margin:0">참고항목</p>
								<input type="text" name="memberAddressEtc" id="memberAddressEtc" class="postcodify_extra_info" value="">
								<br>
								<div class="col-12" style="margin-top:8%">
									<ul class="actions" style="display:felx; justify-content:center;">
										<li>
											<input type="button" value="완료" class="primary" onclick="formSubmit()">
										</li>
										<li>
											<input type="button" value="취소" class="primary" onclick="history.back()">
										</li>
									</ul>
								</div>
							</div>
							<div class="preview" style="width:40%">
								<div>
									<h4>광고1</h4>
									<img src="${pageContext.request.contextPath}/images/ex01.png">
								</div>
								<hr>
								<div>
									<h4>광고2</h4>
									<img src="${pageContext.request.contextPath}/images/ex02.png">
								</div>
								<hr>
								<div>
									<h4>광고3</h4>
									<img src="${pageContext.request.contextPath}/images/ex03.png">
								</div>
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
<script>var contextPath = "${pageContext.request.contextPath}"</script>
<script src="${pageContext.request.contextPath}/app/member/join.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</html>
