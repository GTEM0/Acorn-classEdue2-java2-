<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="prj0831.Member" %>		<!--패키지명을 포함한다:클래스이름  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>에이콘 학생명단</h2>


<%
ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

	for(Member m : list){
		out.println(m + "<br>");
		out.println(m.getId());
		out.println(m.getPw());
	}

%>
</body>
</html>