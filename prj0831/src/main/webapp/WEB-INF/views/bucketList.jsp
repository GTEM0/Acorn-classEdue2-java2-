<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>버킷리스트</h2>

<%
ArrayList<String> list = (ArrayList<String>)request.getAttribute("bucketList");
%>

<%
for(int i = 0; i < list.size(); i++){
	String item = list.get(i);
	out.println(item + "<br>");
}
%>


</body>
</html>