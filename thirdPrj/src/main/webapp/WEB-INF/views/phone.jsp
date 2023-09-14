<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<li>게시판</li>
				<li>전체</li>
			</div>
			<div class="right">
				<li><a href="">로그인</a></li>
				<li><a href="">회원가입</a></li>
			</div>
		</ul>
	</div>



	<div class="body">
		<h2>글쓰기</h2>
		<form id="postForm">
			<label for="postContent">내용:</label>
			<textarea id="postContent" name="content" rows="4" cols="50"></textarea>
			<br>
			<button type="button" onclick="createPost()">저장</button>
		</form>

		<h2>글 목록</h2>
		<ul id="postList">

		</ul>
	</div>

	<script>

    let posts = [];

   
    function createPost() {
        const content = document.getElementById("postContent").value;
        if (content.trim() !== "") {
            const post = { content, id: Date.now() };
            posts.push(post);
            displayPosts();
        }
    }


    function displayPosts() {
        const postList = document.getElementById("postList");
        postList.innerHTML = "";
        posts.forEach((post) => {
            const listItem = document.createElement("li");
            listItem.innerHTML = `
                ${post.content}
                <button onclick="editPost(${post.id})">수정</button>
                <button onclick="deletePost(${post.id})">삭제</button>
            `;
            postList.appendChild(listItem);
        });
    }

  
    function editPost(id) {
        const content = prompt("수정할 내용을 입력하세요.");
        if (content !== null && content.trim() !== "") {
            const post = posts.find((p) => p.id === id);
            if (post) {
                post.content = content;
                displayPosts();
            }
        }
    }


    function deletePost(id) {
        const confirmDelete = confirm("정말로 삭제하시겠습니까?");
        if (confirmDelete) {
            posts = posts.filter((post) => post.id !== id);
            displayPosts();
        }
    }


    displayPosts();
	</script>
	</div>





	<div class="footer">
		<p>핸드폰판매 고객센터 이용약관 쇼핑몰 이용약관 개인정보 처리방침 회사정보 회사명에이콘통신 대표조은경</p>
		<p>사업자번호181-22-01015 주소 서울특별시 마포구 양화로 122 4층 개인정보관리책임자 조은경 이메일</p>
		<p>ekzzang@naver.com 판매제휴업체 SKT - 밀수 / KT - 밀수 / LGU+ - 밀수 대표
			김병진,김민규</p>
		<p>사업자번호845-82-01440 통신판매업신고번호 : 제2023-서울마포-0015호</p>


	</div>
</body>
</html>

