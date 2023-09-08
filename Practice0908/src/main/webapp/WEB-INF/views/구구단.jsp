<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title> 
</head>
<body>
    <table>
        <c:forEach var="i" begin="1" end="9">
            <tr>
               <th><h2>${i}단</h2></th>
            </tr>
            <c:forEach var="j" begin="1" end="9">
                <tr>
                    <td>${i} x ${j} = </td> 
                    <td>${i * j}</td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</body>
</html>
