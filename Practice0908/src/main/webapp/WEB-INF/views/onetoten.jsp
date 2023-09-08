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
String result = (String) request.getAttribute("ott");
%>
<%-- <%= result %> --%>

${ott}

<c:forEach var= "i" begin="1" end="10" >
             ${i}
</c:forEach>


</body>
</html>