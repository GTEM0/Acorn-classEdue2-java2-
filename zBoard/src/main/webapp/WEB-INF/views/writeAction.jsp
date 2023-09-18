<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Board.boardDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판( •̀ ω •́ )✧</title>
</head>
<body>
	<%
	String buyerId = null;
	if(session.getAttribute("buyerId") != null){
		buyerId = (String) session.getAttribute("buyerId");
	}
	%>


	
	
	
</body>
</html>
