<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%

request.setCharacterEncoding("UTF-8");

String r_num = request.getParameter("R_NUM");
String o_id = request.getParameter("ID");
String o_code = request.getParameter("M_CODE");
String o_cnt = request.getParameter("O_CNT");



System.out.println(r_num);

Connection con=null;
PreparedStatement st = null;

try{ 
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	 //1. 오라클드라이버 로딩
	Class.forName(driver); //2. 데이터베이스 연결
	con= DriverManager.getConnection(url, user, password); //3. statement 얻어오기
	
	if(con!=null){
		System.out.println("DB OK!");
	}
	
	String sql ="insert into tbl_movie_order_02 values(?,?,?,?)"; //5. 최종적으로 실행
	System.out.println(sql);

	st = con.prepareStatement(sql);
	
	
	st.setString(1, r_num);
	st.setString(2, o_id);
	st.setString(3, o_code);
	st.setString(4, o_cnt);
	

	
	
	 //4. 필요한 sql 작성
	st.executeUpdate();

}catch(Exception e){
	e.printStackTrace();
}
finally{ //자원의 반납
	
	if( st != null) st.close();
	if( con != null) con.close();
}

%>



</body>
</html>