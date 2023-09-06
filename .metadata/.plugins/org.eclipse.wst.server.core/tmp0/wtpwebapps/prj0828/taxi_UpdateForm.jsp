<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*" %>
<%

	String regno = request.getParameter("regno");
	out.println(regno);

	String regtime="";
	String regdate="";
	String cusno="";
	String startpoint="";
	String destination="";
	String taxino="";
	String state="";
	
	
	
	Connection con=null;
	Statement st = null;
	ResultSet rs = null;
	try{ 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		 //1. 오라클드라이버 로딩
		Class.forName(driver);
		 
		 //2. 데이터베이스 연결
		con= DriverManager.getConnection(url, user, password);
		 
		 //3. statement 얻어오기
		st = con.createStatement();
		
		 //4. 필요한 sql 작성
		String sql ="select REGNO, REGTIME, to_char(REGDATE, 'yyyy-mm-dd'), CUSNO, STARTPOINT, DESTINATION, TAXINO, STATE from tblcall_list where regno= '" + regno + "'"; //5. 최종적으로 실행
		rs = st.executeQuery( sql) ;
		
		 //6. 가져온 쿼리 결과를 화면에 출력하기
		if ( rs.next() ) {
// 			 out.print(rs.getString(1)); // out은 브라우저에 출력을 의미함
// 			 out.print(rs.getString(2));
// 			 out.print(rs.getString(3) + "<br>");
			regtime = rs.getString(2);
			regdate = rs.getString(3);
			cusno = rs.getString(4);
			startpoint = rs.getString(5);
			destination = rs.getString(6);
			taxino = rs.getString(7);
			state = rs.getString(8);
		
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		if( rs!= null) rs.close();
		if( st != null) st.close();
		if( con != null) con.close();
	}
%>
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name = "frm" action = "taxi_Update_action.jsp" method = "post">
		<table>
					
			<tr>
				<td>예약번호</td>
				<td><input type="text" readonly = "readonly" name = "regno"></td>
			</tr>
			<tr>
				<td>예약시간</td>
				<td><input type="text" name = "regtime"></td>
			</tr>
			<tr>
				<td>예약날짜</td>
				<td><input type="text" name = "regdate"></td>
			</tr>
			<tr>
				<td>고객아이디</td>
				<td><input type="text" name = "cusno"></td>
			</tr>
			<tr>
				<td>출발지</td>
				<td><input type="text" name = "startpoint"></td>
			</tr>
			<tr>
				<td>목적지</td>
				<td><input type="text" name = "destination"></td>
			</tr>
			<tr>
				<td>택시번호</td>
				<td><input type="text" name = "taxino"></td>
			</tr>
			<tr>
				<td>배차상태</td>
				<td><select name="state">
				<option value = "선택하기">선택하기</option>
				<option value = "P">배차완료</option>
				<option value = "R">배차준비</option>
				<option value = "X">배차미정</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value = "변경"></td>
			</tr>

		</table>
	</form>
	
	<script>
	let frm = document.frm;
	frm.regno.value = "<%=regno%>";
	frm.regtime.value = "<%=regtime%>";
	frm.regdate.value = "<%=regdate%>";
	frm.cusno.value = "<%=cusno%>";
	frm.startpoint.value = "<%=startpoint%>";
	frm.destination.value = "<%=destination%>";
	frm.taxino.value = "<%=taxino%>";
	frm.state.value = "<%=state%>";

	</script>

</body>
</html>