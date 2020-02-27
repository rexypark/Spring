<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--(실습) 자바코드를 없애고, 데이터출력은 EL 사용 형태로 변경 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>

<div id="container">
	<h1>글 상세</h1>
	<p><a href="logout.do">Log-out</a></p>
	<hr>
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq }">
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" 
					value="${board.title }">
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="40"
					name="content">${board.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${board.regdate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.cnt }</td>
		</tr>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="글 수정">
			</td>
		</tr>
	</table>
	</form>
	<p>
		<a href="insertBoard.jsp">글등록</a>
		<a href="deleteBoard.do?seq=${board.getSeq() }">글삭제</a>
		<a href="getBoardList.do">글목록</a>
	</p>
</div>

</body>
</html>








