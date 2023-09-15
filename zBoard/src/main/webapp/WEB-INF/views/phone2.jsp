<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게 시 판</title>
<style>
body {
	margin: 0;
	padding: 0;
}

.header {
	height: 150px;
	background-color: pink;
	color: white;
	text-align: center;
	line-height: 50px;
	padding: 10px;
}

.navbar {
	height: 70px;
	background-color: gray;
	color: white;
	line-height: 20px;
}

.navbar ul {
	list-style-type: none;
	padding: 0;
	display: flex;
	justify-content: space-between;
}

.navbar .left {
	
}

.navbar .right {
	
}

.navbar li {
	display: inline;
	margin-right: 10px;
}

.body {
	height: 500px;
	background-color: bluesky;
	text-align: center;
	padding-top: 50px;
}

.footer {
	height: 200px;
	background-color: yellowgreen;
	color: black;
	text-align: center;
}

#phboardWarp {
	/* 	width: 800px; */
	margin: 30px auto;
	text-align: left;
	border: 1px solid black;
}

#phboardTitle {
	/* 	width: 750px;  */
	padding-left: 20px;
	height: 40px;
	border: 3px solid darkblue;
	text-align: left;
	font-weight: bold;
	line-height: 40px;
	font-size: 10pt;
	margin-bottom: 30px;
}

#phboardHeader {
	height: 27px;
}

#phboardHeader #leftHeader {
	float: left;
	width: 345px;
	text-align: left;
}

#phboardHeader #rightHeader {
	float: right;
	width: 345px;
	text-align: right;
}

#phboardHeader .selectFiled {
	border: 1px solid;
	border-color: skyblue;
	background-color: wheat;
	font-family: 굴림;
	font-size: 9pt;
}

#phboardHeader .textFiled {
	border: 1px solid;
	height: 13px;
	padding: 2px 2px 2px 2px;
	border-color: skyblue;
	background-color: wheat;
	font-family: "굴림";
	font-size: 9pt;
}

#phboardList {
	clear: both;
}

#phboardList dd {
	float: left;
	height: 30px;
	line-height: 27px;
	text-align: center;
}

#phboardList #title {
	height: 30px;
	border-top: 1px solid skyblue;
	border-bottom: 1px solid skyblue;
	background-color: rgb(146, 180, 146);
	border: 1px solid black;
}

#phboardList #title dl {
	height: 50px;
	border-left: 0px solid #5db062;
	border-right: 0px solid #5db062;
}

#phboardList #title dt {
	float: left;
	line-height: 1px;
	text-align: center;
}

#phboardList .num {
	width: 50px;
}

#phboardList .subject {
	width: 50px;
}

#phboardList .name {
	width: 70px;
}

#phboardList .created {
	width: 65px;
}

#phboardList .clickCount {
	width: 60px;
	margin-right: 5px;
}

#list {
	
}

#phboardList #lists {
	clear: both;
	border: 1px solid black;
}

#phboardList #lists dl {
	float: left;
	border-bottom: 1px solid pink;
}

#phboardList dd.subject {
	width: 410px;
	margin-left: 10px;
	text-align: left;
}

#phboardList a {
	line-height: 27px;
}

#phboardList #page {
	clear: both;
	height: 32px;
	line-height: 32px;
	margin-top: 5px;
	text-align: center;
}
</style>
<title>웹 페이지</title>
</head>

<body>
	<div class="header">
		<h1>핸드폰창고</h1>
	</div>
	<div class="navbar">
		<ul>
			<div class="left">
				<li>삼성</li>
				<li>애플</li>
				<li><a href="">게시판</a></li>
				<li>전체</li>
			</div>
			<div class="right">
				<li><a href="">로그인</a></li>
				<li><a href="">회원가입</a></li>
			</div>
		</ul>
	</div>
	<div class="container">
		<div class="row">
			<table class="table tableStriped"
				style="text-align: center; border: 1px solid orange">
				<thead>
					<tr>
						<th style="background-color: yellow; text-align: center;">번호</th>
						<th style="background-color: yellow; text-align: center;">제목</th>
						<th style="background-color: yellow; text-align: center;">작성자</th>
						<th style="background-color: yellow; text-align: center;">작성일</th>
						<th style="background-color: yellow; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>hi</td>
						<td>롸롸</td>
						<td>0915</td>
						<td>12</td>
					</tr>
				</tbody>
			</table>
			<a href="write.jsp" class="btn btnPrimary pullRight">글쓰기</a>
		</div>

	</div>

	<!-- 	<div id="phboardWarp"> -->

	<!-- 		<div id="phboardTitle">게 시 판</div> -->
	<!-- 		<div id="phboardHeader"> -->
	<!-- 			<div id="leftHeader"> -->
	<!-- 				<form action="" method="post" name="searchForm"> -->
	<!-- 					<select name="searchKey" class="selectField"> -->
	<!-- 						<option value="subject">제목</option> -->
	<!-- 						<option value="name">작성자</option> -->
	<!-- 						<option value="content">내용</option> -->
	<!-- 					</select> <input type="text" name="searchValue" class="textField" /> <input -->
	<!-- 						type="button" value=" 검 색 " class="btn2" onclick="" /> -->
	<!-- 				</form> -->
	<!-- 			</div> -->
	<!-- 			<div id="rightHeader"> -->
	<!-- 				<input type="button" value=" 글쓰기 " class="btn2" onclick="" /> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 		<div id="phboardList"> -->
	<!-- 			<div id="title"> -->
	<!-- 				<dl> -->
	<!-- 					<dt class="num">번호</dt> -->
	<!-- 					<dt class="subject">제목</dt> -->
	<!-- 					<dt class="name">작성자</dt> -->
	<!-- 					<dt class="created">작성일</dt> -->
	<!-- 					<dt class="clickCount">조회수</dt> -->
	<!-- 				</dl> -->
	<!-- 			</div> -->
	<!-- 			<div id="lists"> -->
	<!-- 				<dl> -->
	<!-- 					<dd class="num">1</dd> -->
	<!-- 					<dd class="subject">겁나 안바뀌네 캌</dd> -->
	<!-- 					<dd class="name">롸롸롸</dd> -->
	<!-- 					<dd class="created">2023-09-14</dd> -->
	<!-- 					<dd class="clickCount">10</dd> -->
	<!-- 				</dl> -->
	<!-- 			</div> -->
	<!-- 			<div id="page">1 2 3</div> -->

	<!-- 		</div> -->

	<!-- 	</div> -->




	<div class="footer">
		<p>핸드폰판매 고객센터 이용약관 쇼핑몰 이용약관 개인정보 처리방침 회사정보 회사명에이콘통신 대표 조은경</p>
		<p>사업자번호 181-22-01015 주소 서울특별시 마포구 양화로 122 4층 개인정보관리책임자 박태민 이메일</p>
		<p>ekzzang@naver.com 판매제휴업체 SKT - 밀수 / KT - 밀수 / LGU+ - 밀수 대표
			김병진,김민규</p>
		<p>사업자번호 845-82-01440 통신판매업신고번호 : 제2023-서울마포-0015호</p>


	</div>
</body>

</html>