<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		String[] result = (String[]) request.getAttribute("books");
	%>

	<table>
	<tr>
	<td>책제목</td>	
	</tr>
	<% for(String book : result){ %>
	<tr>
	<td> <%=book %></td>	
	</tr>
	<%} %>
	</table>

	<h2> EL과 jstl</h2>
	
	<c:forEach var="book" items="${books}">
		${item}
	</c:forEach>



</body>
</html>