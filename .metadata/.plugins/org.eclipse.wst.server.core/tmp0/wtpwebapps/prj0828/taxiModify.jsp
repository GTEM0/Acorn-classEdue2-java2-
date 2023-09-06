<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@  page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "./css/taxiModify.css" rel = "stylesheet"/>
<link href = "./css/taxiMain.css" rel = "stylesheet"/>
</head>
<body>

<h2> 택시 수정 현황</h2>



	
<header>
택시예약프로그램 Ver 1.0
</header>

<nav>

<ul>
<li> <a href="taxi_reservation.html">택시예약</a></li>
<li> <a href="taxiModify.jsp">택시수정</a></li>
<li> <a href="taxiCurrent.jsp" >택시현황 </a></li>
<li> <a href="taxiMain.jsp">홈으로</a></li>


</ul>

</nav>

<h2>택시 예약 등록</h2>

<table>

<tr>
	<td>예약번호</td>
	<td>     </td>
</tr>
	
<tr>
	<td>예약시간</td>
	<td>    </td>
</tr>
	
<tr>
	<td>예약날짜</td>
	<td>    </td>
</tr>
	
<tr>
	<td>고객아이디</td>
	<td>    </td>
</tr>	

<tr>
	<td>출발지</td>
	<td>    </td>
</tr>	

<tr>
	<td>목적지</td>
	<td>    </td>
</tr>	

<tr>
	<td>택시번호</td>
	<td>    </td>
</tr>	

<tr>
	<td>배차상태</td>
	<td><select><option>선택하기</option><option>배차완료</option><option>배차준비</option><option>배차미정</option></select></td>
</tr>

<tr>
	<td colspan="2"><button>등록</button><button>다시입력</button></td>
	
</tr>	
</table>
	
	


<footer>
HRD KOREA Copyrigth 2023 All reserved Human Resources Development Service of Korea
</footer>

</body>
</html>

<%
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
		String  sql = " select substr(cust.tel, 1, 3) || '-' || substr(cust.tel, 4, 4)  || '-' || substr(cust.tel, 8, 4)  tel,"; 
		        sql += " call.regno ,substr( lpad( regtime, 4, '0') , 1 ,2 )  || ':' || substr( lpad( regtime, 4, '0') , 3 ,2 )  regtime";
		        sql += " , to_char( call.regdate ,'yyyy-mm-dd' ) ,"; 
		        sql += " cust.name,  call.startpoint,";
		        sql += " call.DESTINATION  ,  call.taxino,";
		        sql += " decode(call.state ,'P', '배차완료', 'R', '배차준비' , 'X', '배차미정')";
		        sql += " from tblcall_list  call";
		        sql += " join TBLCUST cust";
		        sql += " on  call.CUSNO  = cust.id"; //5. 최종적으로 실행
		        
		System.out.println(sql);
		rs = st.executeQuery( sql);		
		 //6. 가져온 쿼리 결과를 화면에 출력하기
		while( rs.next() ) {
		
		
%>

<!-- db연동 후 데이터 조회부분 -->


<%
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		if( rs != null) rs.close();
		if( st != null) st.close();
		if( con != null) con.close();
	}
%>


</table>

</body>
</html>  