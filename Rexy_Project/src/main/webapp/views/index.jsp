<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

	function getJsonData(){
		//$.ajax("",{});
		alert("click json");
		$.ajax("/getJsonData.do",{
			type : "get",
			dataType : "json",
			success : function(data) {
				alert("성공 : " + data);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("ajax 실패 : \n" +
					"jqXHR.readyState" + jqXHR.readyState + "\n" +
					"textStatus : " + textStatus + "\n" +
					"errorThrown : " + errorThrown);
			}
		});
	}
</script>
</head>
<body>
	<div id="container">
		<h1>게시판 프로그램</h1>
		<hr>
		<p><a href="login.do">로그인(get)</a></p>
		<p><a href="getBoardList.do">로그인(get)getBoardList.do</a></p>
		<hr>
		<p><a href="dataTransform.do">데이터 전환(JSON)</a></p>
		<hr>
		<p><a href="javascript:getJsonData()">JSON 데이터 받아서 화면표시</a></p>
	</div>
	<hr>
	<div id="listDisp">
	<ul>
		<li>데이터 가져와서 출력하기</li>
	</ul>
		
			
	</div>
</body>
</html>