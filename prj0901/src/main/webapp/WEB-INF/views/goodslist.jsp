<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="java.util.*" %>
<%@ page import ="prj0901.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 상품목록</h2>


<% ArrayList<Coffee> list= ( ArrayList<Coffee>)  request.getAttribute("list"); %>


<%
for( Coffee c: list){
	out.println( c.getCode());
	out.println( c.getName());
	out.println( c.getPrice());
	 
	
}
%>

</body>
</html>