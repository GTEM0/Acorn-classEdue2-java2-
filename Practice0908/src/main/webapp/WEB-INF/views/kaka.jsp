<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="practice.kaka" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>명단</h2>

<%
ArrayList<kaka> list = (ArrayList<kaka>)request.getAttribute("kaka");
%>

<%
	for(kaka l : list){
		out.println(l + "<br>");
	}
%>

</body>
</html>