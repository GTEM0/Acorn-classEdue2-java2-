package prj0901;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDAO {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon() {		 
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if(con != null) System.out.println("ok");
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;		 	
	}		
	 
	
	public String a() {
		return "dfdfd";
	}	
	
	public int b( int a){

		return a*a;
	}
		
	public ArrayList<Coffee> list2(){
		
		ArrayList<Coffee> list  = new ArrayList<>();
		list.add(new Coffee("c500","아아","4000"));
		list.add(new Coffee("c500","아아","4000"));
		list.add(new Coffee("c500","아아","4000"));
		
		return list;
	}
		
	public ArrayList<Coffee> selectAll2(){
		//연결
		Connection con = dbcon();
		//sql		
		String sql = "select * from goodstbl";
		//sql 실행
		PreparedStatement ooo=null;
		ResultSet rs=null;
		
		ArrayList<Coffee> lista = new ArrayList<>();
		try {
			ooo=con.prepareStatement(sql);
			rs=ooo.executeQuery();
			
			while(rs.next()) {
			//	System.out.print(rs.getString(1));  
			//	System.out.print(rs.getString(2));
			//	System.out.println(rs.getString(3));
				
				String id = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				
				Coffee c = new Coffee (id, name, price);
				lista.add(c);
			}						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}		 
	
	public static void main(String[] args) {
 	GoodsDAO g= new GoodsDAO();
		//g.selectAll();
		
		 ArrayList<Coffee> list = g.selectAll2();
		 System.out.println( list);	 
	}
}
