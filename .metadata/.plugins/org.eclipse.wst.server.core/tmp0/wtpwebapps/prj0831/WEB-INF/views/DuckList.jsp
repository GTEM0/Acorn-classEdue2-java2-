<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="prj0831.Duck" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/duck.css" rel="stylesheet" />
</head>
<body>

<h2>SuperPower Ducks</h2>

<tr>
<td>
<%
ArrayList<Duck> list = (ArrayList<Duck>)request.getAttribute("list");

	for(Duck d : list){
		out.println(d + "<br>");
// 		out.println(d.getName());
// 		out.println(d.getCharacter());
// 		out.println(d.getPower());
		
	}
%>
</td>
</tr>

</body>
</html>