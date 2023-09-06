<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "./css/audition.css" rel = "stylesheet"/>
</head>
<body>
<header>
HY라우드 오디션 ver 1.0
</header>

<nav>
<ul>
<li>참가자등록</li>
<li>참가자목록 조회</li>
<li>참가자점수 조회</li>
<li>참가자등수 조회</li>
<li>홈으로</li>

</ul>

</nav>

<section>
<h2>오디션관리 프로그램</h2>
<h1>오디션 위한 프로그램이다</h1>
<ol>
<li>내용작성</li>
<li>내용작성</li>
<li>내용작성</li>
</ol>
</section>

<table>
<h1>참가자 등록</h1>

<tr>
	<td> 참가자ID</td>
	<td style="width:150px;"><input type="text" id="username" name="username" style=" margin-left:0px;"></td>
</tr>

<tr>
	<td>참가자이름</td>
	<td style="width:150px;"><input type="text" id="username" name="username" style=" margin-left:0px;"></td>
</tr>

<tr>
	<td>생년월일</td>
	<td style="width:150px;"><input type="text"style="width:45px;">년 <input type="text"style="width:45px;">월 <input type="text"style="width:45px;">일</td>
</tr>

<tr>
	<td>성별</td>
	<td></td>
</tr>

<tr>
	<td>실력무대</td>
	<td></td>
</tr>

<tr>
	<td>매력무대</td>
	<td style="width:150px;"><input type="text"></td>
</tr>

<tr>
	<td colspan="2"><button>저장</button><button>취소</button></td>
	
</tr>

<tr>
<td rowspan="3">[ V ] 보컬<BR>[ D ] 댄스<BR>[ R ] 랩</td>
</tr>



</table>

</body>
</html>