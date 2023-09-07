<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="acorntbl.Movies" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>에이콘 영화 목록 (～￣▽￣)～</h2>

<%
ArrayList<Movies> list = (ArrayList<Movies>)request.getAttribute("movie");
%>
<%
for(int i = 0; i<list.size(); i++){
	out.println(list.get(i)+"<br>");
}
%>

</body>
</html>