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
			<td>예약번호</td>
			<td>영화코드</td>
			<td>회원아이디</td>
			<td>회원이름</td>
			<td>연락처</td>
			<td>영화제목</td>
			<td>장르</td>
			<td>런타임</td>
			<td>상영시간</td>
			<td>티켓가격</td>
			<td>예매수량</td>
			<td>총금액</td>
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
			String sql = " select o.R_NUM 예약번호, m.m_code ,c.ID 회원아이디,c.NAME 회원이름,SUBSTR(c.phone,1,9)||'****' 연락처,";
			sql += " m.M_TITLE 영화제목,m.M_GENRE 장르,m.M_RUNTIME||'분' 런타임,m.M_START_END 상영시간,";
			sql += " m.M_PRICE ||'원' 티켓가격, o.O_CNT ||'매' 예매수량,	(m.M_PRICE * o.O_CNT) ||'원'총금액";
			sql += " from tbl_customer_02 c	inner join tbl_movie_order_02 o	on c.ID = o.O_ID";
			sql += " inner join tbl_movie02 m on o.O_CODE = m.M_CODE";
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
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>
			<td><%=rs.getString(8)%></td>
			<td><%=rs.getString(9)%></td>
			<td><%=rs.getString(10)%></td>
			<td><%=rs.getString(11)%></td>
			<td><%=rs.getString(12)%></td>
			<td><a href="delete_action.jsp?r_num=<%=rs.getString(1)%>">삭제</a></td>



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