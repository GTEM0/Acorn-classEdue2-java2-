<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>카페 음료 목록이에요╰(*°▽°*)╯</h2>

<% 
ArrayList<String> lista = (ArrayList<String>) request.getAttribute("listt");
%>
<%
for(int i = 0; i < lista.size(); i++){
	
	out.println(lista.get(i) + "<br>");
}
%>
</body>
</html>