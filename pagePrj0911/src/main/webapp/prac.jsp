<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
int currentPage = 1;
if(request.getParameter("p") != null){
	currentPage = Integer.parseInt(request.getParameter("p"));
}

int totRecords = 30;
int pageSize = 5;
int grpSize = 5;

int totalPage;
int currentGrp = 0;

//총 페이지 수 구하기
int reamin = totRecords % pageSize;
if(reamin == 0)
	totalPage = totRecords / pageSize;
else
	totalPage = totRecords / pageSize +1;

//현재 페이지에 따른 현재 그룹 구하기

int remain2 = currentPage % grpSize;
if(remain2 == 0)currentGrp = currentPage / grpSize;
else
	currentGrp = currentPage / grpSize +1;

int grpStartPage = (currentGrp - 1) * grpSize + 1;
int grpEndPage = currentGrp * grpSize;

if(grpEndPage > totalPage){
	grpEndPage = totalPage;
}
	int index = grpStartPage;
	if(currentGrp > 1){
%>
		<a href="paging.jsp?p=<%=index-1%>">[ 이전 ] </a>
	<% }
	
	while(index <= grpEndPage){
	%>
		<a href="/pagePrj/paging.jsp?p=<%=index%>">[ <%=index%>]</a>
	<%
		index ++;
	}
	
	if(grpEndPage < totalPage){%>
		<a href="/pagePrj/paging.jsp?p=<%=grpEndPage+1 %>">[ 다음 ]</a>
	<%}
	%>



</body>
</html>