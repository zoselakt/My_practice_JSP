<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="header">
	<a href="index.html" class="logo">JSP</a><span>by KGD</span>
	<nav>
		<ul>
			<li><a href="#menu">Menu </a></li>
		</ul>
	</nav>
</header>

<nav id="menu">
	<ul class="actions stacked">
		<li>
			<a href="javascript:void(0)">회원가입</a>
		</li>
		<c:choose>
			<c:when test="${session_id eq null}">
				<li>
					<a href="javascript:void(0)">로그인</a>
				</li>
			</c:when>
			<c:otherwise>
				<li>
					<a href="javascript:void(0)">로그아웃</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>