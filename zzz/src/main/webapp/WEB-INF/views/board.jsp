<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.io.PrintWriter"%>  
<%@ page import="board.boardDAO"%>
<%@ page import="board.board"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">핸드폰몰게시판</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li class="active"><a href="bbs.jsp">게시판</a></li>
			</ul>
			<%
			if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기</a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul></li>
			</ul>
			<%
			} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리</a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
			<%
			}
			%>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: gray; text-align: center;">번호</th>
						<th style="background-color: gray; text-align: center;">제목</th>
						<th style="background-color: gray; text-align: center;">작성자</th>
						<th style="background-color: gray; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<%
					boardDAO bdDAO = new boardDAO();
								ArrayList<board> list = bdDAO.getList(pageNumber);
								for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getQuestionCode()%></td>
						<td><a href="view.jsp?QuestionCode=<%=list.get(i).getQuestionCode()%>"><%=list.get(i).getTitle()%></a></td>
						<td><%=list.get(i).getBuyerId()%></td>
						<td><%=list.get(i).getWriteDate().substring(0, 11) + list.get(i).getWriteDate().substring(11, 13) + "시"
		+ list.get(i).getWriteDate().substring(14, 16) + "분"%></td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
			<%
			if (pageNumber != 1) {
			%>
			<a href="board.jsp?pageNumber=<%=pageNumber - 1%>"
				class="btn btn-success btn-array-left">이전</a>
			<%
			}
			if (boardDAO.nextPage(pageNumber + 1)) {
			%>
			<a href="board.jsp?pageNumber=<%=pageNumber + 1%>"
				class="btn btn-success btn-array-left">다음</a>
			<%
			}
			%>
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
</body>
</html>