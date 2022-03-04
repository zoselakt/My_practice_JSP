<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get, post 방식의 요청</title>
</head>
 <%--
<body>
	<h1>GET 방식의 요청</h1>
	<button onclick="sendRequest()">GET 방식으로 요청 보내기!</button>
	<p id="text"></p>
</body>
<script>
	function sendRequest(){
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "request_ajax.jsp?city=Seoul&zipcode=45645", true);
		xhr.send();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
				document.getElementById("text").innerHTML = xhr.responseText;
			}
		}
	}
</script>
  --%>

 <body>
 	<h1>POST 방식의 요청</h1>
 	<button onclick="sendRequest()">post방식으로 요청보내기</button>
 	<p id="text"></p>
 </body>
 
 
 <script>
 	function sendRequest() {
		var xhr = new XMLHttpRequest();
		
		xhr.open("POST", "request_ajax.jsp", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("city=Seoul&zipcode=54645");
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
				document.getElementById("text").innerHTML = xhr.responseText;
			}
		}
	}
 	
 </script>

</html>