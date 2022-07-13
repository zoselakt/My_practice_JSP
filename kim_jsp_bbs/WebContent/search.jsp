<%@page import="com.mybulletin.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>JSP게시판만들기</title>
	</head>
	<body>
		<div>
			<form>
				<fieldset>
                    <legend>글 검색 필드</legend>                    
                    <label>검색분류</label>
                        <select name = "f">
                            <option ${(param.f == "title")? "selected" : ""} value = "title">제목</option>
                            <option ${(param.f == "writer_Id")? "selected" : ""} value = "writer_Id">작성자</option>
                        </select>
                    <label>검색어</label>
                        <input type = "text" name = "q" value = "${param.q}"/>
                        <input type = "submit" value = "검색">                
                </fieldset>        
			
				
			</form>	
		</div>	
	
		<div>
			<h3 >글 목록</h3>
			<table >
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th >조회수</th>
					</tr>
				</thead>							
				<tbody>	
							
				<c:forEach var = "n" items = "${list }">
					<tr>
						<td>${n.id }</td>
						<td><a href="detail?id=${n.id }">${n.title }</a></td>
						<td>${n.writerId}</td>
						<td>
							<fmt:formatDate pattern = "yyyy:MM:dd hh:mm:ss" value="${n.regdate }"/>							
						</td>
						<td>
							<fmt:formatNumber pattern = "####,###" value="${n.hit}" />							
						</td>
					</tr>
				</c:forEach>				
					
				</tbody>
			</table>
		</div>
		
		<div>
			<c:set var = "page" value = "${(empty param.p)? 1 : param.p}"/>
			<c:set var = "startNum" value = "${page-(page-1)%5}" />
			<c:set var = "lastNum" value = "23" />
			
			<c:if test="${startNum > 1}">
				<span><a href = "?p=${startNum - 1}&f=&q=">이전</a> </span>
			</c:if>
			<c:if test="${startNum <= 1}">
				<span onclick = "alert('이전 페이지가 없습니다.');">이전</span>
			</c:if>
			
			<span>
				<c:forEach var = "i" begin = "0" end = "4">
					<a href = "?p=${startNum + i}&f=&q=">${startNum + i}</a>
				</c:forEach>		
			</span>
			
			<c:if test="${startNum < lastNum }">
				<span><a href = "?p=${startNum + 5}&f=&q=">다음</a> </span>
			</c:if>
			<c:if test="${startNum >= lastNum }">
				<span onclick = "alert('다음 페이지가 없습니다.');">다음</span>
			</c:if>		
		</div>
	</body>
</html>