package acorntbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDAO2 {
	
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
	
	public ArrayList<Test> getAcornList(){
	    Connection con = dbcon();
	    String sql = "select * from acorntbl";
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    ArrayList<Test> list = new ArrayList<>();
	    
	    try {
	        pst = con.prepareStatement(sql);
	        rs = pst.executeQuery();
	        
	        while(rs.next()) {
	            // Test 객체 생성 후 필드에 값을 설정하고 리스트에 추가
	         String id = rs.getString(1);
	         String pw = rs.getString(2);
	         String name = rs.getString(3);
	         Test test = new Test(id, pw, name);
	         
	         list.add(test);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	    
	    close(rs, pst, con);
	    return list;
	}

	
	public void close(AutoCloseable...a) {
		for(AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		TestDAO2 dao = new TestDAO2();
		ArrayList<Test> list = dao.getAcornList();
		//System.out.println(list);
		
		for(int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i) + "<br>");
		}
	}
}
	
	