<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.ex.dao.*" import="com.test.ex.dto.*" import="java.util.*"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
	// 페이징 처리
	String cp = request.getParameter("cp");
    Bdao dao = new Bdao();
	int currentPage = 0;
	
	if(cp!=null){
		currentPage = Integer.parseInt(cp);
	}else {
		currentPage = 1;
	}
	

	//int totalCount = dao.getPagingData();
	int recordByPage = 10;

	//int totalPage = (totalCount%recordByPage==0)?totalCount/recordByPage:totalCount/recordByPage+1;
	
	int StartNo = (currentPage-1)*recordByPage+1;
	

	int EndNo = currentPage*recordByPage;
	

	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th class="post_no">번호</th>
			<th class="user_id">유저 아이디</th>
			<th class="title">제목</th>
			<th class="writer">작성자</th>
			<th class="likes">좋아요</th>
			<th class="hits">조회수</th>
		</tr>
	
	 	<%
			ArrayList<Bdto> list = dao.getAlldata(StartNo, EndNo);			

			for(Bdto vo : list){		
		%>
		<tr>
			<td class="bhit"><%=vo.getbHit() %></td>
			<th><%=vo.getbId() %></th>
			<td class="btitle">
				<a href="view.jsp?post_no=<%=vo.getbHit() %>"><%=vo.getbTitle() %></a>
			</td> 
			<td class="bname"><%=vo.getbName() %></td>
			<th class="bstep"><%=vo.getbStep() %></th>
			<th class="bhits"><%=vo.getbHit() %></th>
		</tr>
		<%
			}// for end		
		%> 
		<tr>
			<td colspan="6" id="list">
				<%
					for(int i=currentPage-3; i<currentPage+3; i++){		
						if(i<=0){
							continue;
						}else if(i>totalPage){
							break;
						}else {
							
				%>			
					<a href="List.jsp?cp=<%=i %>"><span id="paging"><%=i %></span></a>
				<%
						}// if end
					}// for end				
				 %>		
			</td>
			
		</tr>
		
		
		
		<tr>
			<td colspan="6" class="btn">
				<a href="write_form.jsp"><input type="button" value="등록" class="등록" /></a>
				<jsp:include page="search.jsp"></jsp:include>
			</td>
		</tr>
<form action="List.jsp?cp " method="get" name="frm">
	<select name="col">
		<option >전체 내용</option>
		<option >게시판 번호</option>
		<option >제목</option>
		<option >아이디</option>
		<option >닉네임</option>
	</select>
		<input type="text" name="word" /><input type="submit" value="검색" id="searchBtn"/>
</form>
</body>
</html>