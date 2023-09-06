<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>

<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String name = request.getParameter("name");
String phone = request.getParameter("phone");




Connection con=null;
PreparedStatement st = null;

try{ 
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	 
	Class.forName(driver); 
	con= DriverManager.getConnection(url, user, password); 
	String sql = "update tbl_customer_02 set name=?, phone=? where id=?";
			
	
			System.out.println(sql);
	st = con.prepareStatement(sql); 
	
	
	st.setString(1, name);
	st.setString(2, phone);
	st.setString(3, id);
	st.executeUpdate();
	
	 
	
}catch(Exception e){
	e.printStackTrace();
}
finally{ //자원의 반납
	
	if( st != null) st.close();
	if( con != null) con.close();
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update_action</title>
</head>
<body>

</body>
</html>