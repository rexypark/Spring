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
		$.ajax("getJsonList.do", {
			type: "get",
			dataType : "json",
			success : function(data){
				alert("성공 ~~ data : " + data);
				
				var strData = JSON.stringify(data);
				console.log("strData : " + strData);
				
				var jsData = JSON.parse(strData); //자바 스크립트 데이터로 형 변환
				console.log("jsData : " + jsData);
				
				
				var dataTag = "";
				dataTag = "<ul>";
				$.each(data, function(index, obj){
					dataTag += "<li>"
					dataTag += this.seq + ", ";
					dataTag += this.title + ", ";
					dataTag += this["writer"] + ", ";
					dataTag += this["regdate"] + ", ";
					dataTag += obj["cnt"];
					dataTag += "</li>"
				});
				
				dataTag += "</ul>";

				$("#listDisp").html(dataTag);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("Ajax 처리 실패 : \n" +
					  "jqXHR.readyState : " + jqXHR.readyState + "\n" +
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