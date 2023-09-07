package acorntbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

public class MovieDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";
	
	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null)
				System.out.println("데이터베이스 연결 성공~!");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<Movies> getAllList(){
		
		Connection con = dbcon();
		String sql = "select * from movietbl";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Movies> list = new ArrayList<>();
		
		try {
			 pst = con.prepareStatement(sql);
			 rs = pst.executeQuery();
			 
			 while(rs.next()) {
				 String title = rs.getString(1);
				 String price = rs.getString(2);
				 Movies movies = new Movies(title, price);
				 
				 list.add(movies);
			 }
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;		
	}
	
	public void close(AutoCloseable...a) {
		for(AutoCloseable item:a) {
			try {
				item.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}		
	}
	
	public static void main(String[] args) {
		MovieDAO dao = new MovieDAO();
		ArrayList<Movies> list = dao.getAllList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "<br>");
		}
	}
	
}
