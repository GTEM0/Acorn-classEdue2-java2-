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

    <table>
        <h3>구구단 3단</h3>        
       
       	<c:forEach var="i" begin="1" end="9">
       	
       		<tr>       			
       			<td>${3} x ${i} = ${3*i}</td>
       		</tr>
       	</c:forEach>
    </table>
       	
       

</body>
</html>