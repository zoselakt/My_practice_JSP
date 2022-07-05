<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<a href="index.html" class="logo">JSP <span>by HDS</span></a>
	<nav>
		<ul>
			<li><a href="#menu">Menu</a></li>
		</ul>	
	</nav>
</header>

<nav id="menu">
	<ul class="actions stacked">
		<li>
			<a href="${pageContext.request.contextPath}/member/MemberJoin.me">회원가입</a>
		</li>
		<c:choose>
		<c:when test="${sessionId eq null}">
			<li>
				<a href="${pageContext.request.contextPath}/member/MemberLogin.me">로그인</a>
			</li>
		</c:when>
		<c:otherwise>
			<li>
				<a href="${pageContext.request.contextPath}/member/MemberLogoutOk.me">로그아웃</a>
			</li>
		</c:otherwise>
		</c:choose>
	</ul>
</nav>