<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
	margin: 0 auto;
}
</style>
</head>
<body>

	

	<h2>hello jsp 그것 세상에서 가장 한 곳이다 그것은 어떻게 했다 나에게 한참동안 신선</h2>
	<h2>더욱이 가했다 컴퓨터언어 심심한</h2>
	<h1>충격이다 어제의 저녁 세계보건기구 황홀한</h1>

	<%
	for (int i = 1; i <= 9; i++) {
	%>
	<div style="height: 30px; width: 30px; border: 1px solid pink;">
		<a><%=i%></a>
	</div>
	<%
	}
	%>

	<div style="display: flex; flex-direction: row;">

		<%
		for (int z = 1; z <= 9; z++) {
		%>
		<div
			style="width: 65px; border: 2px solid aqua; text-align: center; margin-right: 10px;">
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<div style="border-bottom: 1px solid black; padding: 5px;">
				<%=i + "x" + z + "=" + i * z%>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%>

	</div>

	<%
	int random = (int) (Math.random() * 6);
	if (random == 0) {
		out.println("힘내세요!");
	} else if (random == 1) {
		out.println("포기하지마요!");
	} else if (random == 2) {
		out.println("조금만 더 하면 됩니다!");
	} else if (random == 3) {
		out.println("잘하고 있어요!");
	} else if (random == 4) {
		out.println("긍정적인 마음으로 화이팅!");
	} else if (random == 5) {
		out.println("넌 할 수 있어!");
	}
	%>
	
	<%
	for(int i=1; i<=5; i++) {
		for(int j=1; j<=5-i; j++){
			out.println(" ");
		}
			for(int j=1; j<=i*2-1; j++) {
				out.println("*");
			}
						
		out.println();
	}
	%>

</body>
</html>
