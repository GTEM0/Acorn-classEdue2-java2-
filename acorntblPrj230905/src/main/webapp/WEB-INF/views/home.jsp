<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
first page

<%
String id = (String)session.getAttribute("id");
	if(id == null){
%>
<a href="/acorntbl230905/login">로그인</a>
<%}else{ %>
<a href="/acorntbl230905/logout">로그아웃</a>
<a href="/acorntbl230905/order">주문하기</a>

<%} %>
</body>
</html>