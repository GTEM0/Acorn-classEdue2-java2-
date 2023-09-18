<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
	<h1>게시물 작성</h1>
	<form action="./doadd">
		<div>
			<input type="text" name="nickname" placeholder="별명을 입력해주세요.">
		</div>
		<br>
		<div>
			<input type="text" name="title" placeholder="제목을 입력해주세요.">
		</div>
		<br>
		
		<div>
			<textarea name="body" placeholder="내용을 입력해주세요."></textarea>
		</div>
		<br>
		
		<div>
			<input type="submit" value="전송"> <input type="button" value="취소" onClick="location.href='http://118.217.44.241:8081/Exam1/List.jsp'">
		</div>
	</form>

</body>
</html>