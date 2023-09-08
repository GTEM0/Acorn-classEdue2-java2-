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

<% String path = request.getContextPath(); %>
<%= path %>

	<table>
		<tr>
			<td>코드</td>
			<td>이름</td>
			<td>가격</td>
		</tr>
		<c:forEach var="coffee" items="${coffee}">
		
		<tr>
			<td>${coffee.code}</td>
			<td>${coffee.name}</td>
			<td>${coffee.price}</td>
		</tr>
		
		
		</c:forEach>
	</table>


</body>
</html>