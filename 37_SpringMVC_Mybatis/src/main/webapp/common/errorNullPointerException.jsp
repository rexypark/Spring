<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 화면</title>
<style>
	#container {width : 700px; margin: 0 auto;}
	h2, p {text-align: center;}
	.orange { background-color : orange; }
</style>
</head>
<body>
	<div id="container">
		<h2>Null 에러 화면입니다.</h2>
		<hr>
		<p class="orange">Message : ${exception.message}</p>
		<p>시스템 담당자(8080)에게 연락 바랍니다.</p>
	</div>
</body>
</html>