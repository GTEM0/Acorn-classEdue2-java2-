<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.sql.*" %>

	<%
	
	//1.
	request.setCharacterEncoding("UTF-8");	
	//2.
	String regno = request.getParameter("regno");
	String regtime = request.getParameter("regtime");
	String regdate = request.getParameter("regdate");	
	String cusno = request.getParameter("cusno");
	String startpoint = request.getParameter("startpoint");
	String destination = request.getParameter("destination");	
	String taxino = request.getParameter("taxino");
	String state = request.getParameter("state");
	
	out.println(regno);
	out.println(regtime);
	out.println(regdate);
	out.println(cusno);
	out.println(startpoint);
	out.println(destination);
	out.println(taxino);
	out.println(state);

	//데이터베이스 연결, sql, update 실행	
	Connection con=null;
	PreparedStatement st = null;	
	try{ 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		Class.forName(driver);	
		con = DriverManager.getConnection(url, user, password);
		String sql = " update tblcall_list set regtime = ?,"; 
			   sql += " regdate = ?, cusno = ?, startpoint = ?,";
			   sql += " destination = ?, taxino = ?, state = ?";
			   sql += " where regno = ?";
			   
			   
		System.out.println( sql);
		st = con.prepareStatement(sql);
		st.setString(1, regtime);
		st.setString(2, regdate);
		st.setString(3, cusno);
		st.setString(4, startpoint);
		st.setString(5, destination);
		st.setString(6, taxino);
		st.setString(7, state);
		st.setString(8, regno);
		//실행
		st.executeUpdate() ;			
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		
		if( st != null) st.close();
		if( con != null) con.close();
	}
	//response.sendRedirect("list.jsp");
	
	%>