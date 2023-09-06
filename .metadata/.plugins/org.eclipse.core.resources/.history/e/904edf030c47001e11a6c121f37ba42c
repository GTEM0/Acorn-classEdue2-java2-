<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/index.css" rel="stylesheet" />
<link href="./css/list.css" rel="stylesheet" />
<link href="./css/reserve.css" rel="stylesheet" />
</head>
<body>
	<header>
		<img src="./img/cgv.jpg" />
	</header>
	<%@ include file="nav.jsp"%>


	<table>
	<caption><strong>예매 현황</strong></caption>
		<tr>
			
			<td>회원아이디</td>
			<td>회원이름</td>
			<td>연락처</td>
			<td>관리</td>
			
			


		</tr>
		<%
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:testdb";
			String user = "scott";
			String password = "tiger";

			//1. 오라클드라이버 로딩
			Class.forName(driver);

			//2. 데이터베이스 연결
			con = DriverManager.getConnection(url, user, password);

			//3. statement 얻어오기
			st = con.createStatement();

			//4. 필요한 sql 작성
			String sql = "select * from tbl_customer_02";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			//6. 가져온 쿼리 결과를 화면에 출력하기
			while (rs.next()) {
		%>
		<!-- db연동 후 데이터 조회부분 -->

		<tr>

			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><a href="update.jsp?id=<%=rs.getString(1)%>">수정</a></td>



		</tr>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally { //자원의 반납
		if (rs != null)
		rs.close();
		if (st != null)
		st.close();
		if (con != null)
		con.close();
		}
		%>

	</table>

	<%@ include file="section.jsp"%>
</body>
</html>