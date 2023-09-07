<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="acorntbl.Test"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>에이콘 학생 명단 (～￣▽￣)～</h2>

	<%
ArrayList<Test> list = (ArrayList<Test>)request.getAttribute("list");
%>

	<%
	for(int i =0; i < list.size(); i++){
		out.println(list.get(i) + "<br>");
	}
%>

</body>
</html>