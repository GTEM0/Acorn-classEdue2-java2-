<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>

<%
String id = request.getParameter("id");
String name = "";
String phone = "";
System.out.println(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/index.css" rel="stylesheet" />
<link href="./css/list.css" rel="stylesheet" />
<link href="./css/reserve.css" rel="stylesheet" />
<script>
	function check() {
		/*
		 let taxi_form = document.taxi_form;
		 let regno = taxi_form.regno;
		 let regtime = taxi_form.regtime;
		 let regdate = taxi_form.regdate;
		 let cusno = taxi_form.cusno;
		 let startpoint = taxi_form.startpoint;
		 let destination = taxi_form.destination;
		 let taxino = taxi_form.taxino;
		 let state = taxi_form.state;

		 if (regno.value == "") {
		 alert("예약번호를 입력하세요!");
		 regno.focus();
		 return false;
		 } else if (regtime.value == "") {
		 alert("예약시간을 입력하세요!");
		 regtime.focus;
		 return false;
		 } else if (regdate.value == "") {
		 alert("예약날짜를 입력하세요!");
		 regdate.focus;
		 return false;
		 } else if (cusno.value == "") {
		 alert("아이디를 입력하세요!");
		 cusno.focus;
		 return false;
		 } else if (startpoint.value == "") {
		 alert("시작지점을 입력하세요!");
		 startpoint.focus;
		 return false;
		 } else if (destination.value == "") {
		 alert("도착지점을 입력하세요!");
		 destination.focus;
		 return false;
		 } else if (taxino.value == "") {
		 alert("택시번호를 입력하세요!");
		 taxino.focus;
		 return false;
		 } else if (state.value == "선택하기") {
		 alert("배차상태를 선택하세요!");
		 state.focus;
		 return false;
		 }
		
		 */
		return true;
	}
</script>
</head>
<body>
	<header>
		<img src="./img/cgv.jpg" />
	</header>
	<%@ include file="nav.jsp"%>


	<%
	String userpw = "";
	String username = "";

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
		String sql = "select * from tbl_customer_02 where id = '" + id + "'";
		rs = st.executeQuery(sql);
		//6. 가져온 쿼리 결과를 화면에 출력하기
		if (rs.next()) {
			name = rs.getString(2);
			phone = rs.getString(3);
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

	<form name="frm" action="update_action.jsp" method="post"
		onsubmit="return check()">
		<table>
			<caption>
				<strong>개인 정보 수정</strong>
			</caption>
			<tr>
				<td>아이디</td>
				<td><input type="text" readonly="readonly" name="id"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>핸드폰 번호</td>
				<td><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td colspan="2">
					<button>변경</button>
					<button>다시입력</button>
				</td>


			</tr>
		</table>
	</form>



	<%@ include file="section.jsp"%>

	<script type="text/javascript">
	
let frm = document.frm;

frm.id.value="<%=id%>";
frm.name.value="<%=name%>";
frm.phone.value="<%=phone%>";
	</script>
</body>
</html>