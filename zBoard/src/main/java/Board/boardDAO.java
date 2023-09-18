package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class boardDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null)
				System.out.println("ok");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	
	public void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<board> getList() {
		// 연결
		Connection con = dbcon();
		// sql
		String sql = "select * from questionTbl2";
		// sql실행
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<board> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql); // sql얻어옴
			rs = pst.executeQuery(); // 실행

			while (rs.next()) {
				board bd = new board();
				bd.setQuestionCode(rs.getInt(1));
				bd.setBuyerId(rs.getString(2));
				bd.setTitle(rs.getString(3));
				bd.setQuestionContents(rs.getString(4));
				bd.setWriteDate(rs.getString(5));
				//bd.setBbsAvailable(rs.getInt(6));
				list.add(bd);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 해제
		close(rs, pst, con);
		return list;
	}
	
	public ArrayList<board> getContents(){
		Connection con = dbcon();
		// sql
		String sql = "select * from questionTbl2";
		// sql실행
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<board> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql); // sql얻어옴
			rs = pst.executeQuery(); // 실행

			while (rs.next()) {
				board bd = new board();
				bd.setQuestionCode(rs.getInt(1));
				bd.setBuyerId(rs.getString(2));
				bd.setTitle(rs.getString(3));
				bd.setQuestionContents(rs.getString(4));
				bd.setWriteDate(rs.getString(5));
				//bd.setBbsAvailable(rs.getInt(6));
				list.add(bd);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 해제
		close(rs, pst, con);
		return list;
	}
	
	
	public board getOne(String code){
		Connection con = dbcon();
		// sql
		String sql = "select * from questionTbl2 where questionCode=?";
		// sql실행
		PreparedStatement pst = null;
		ResultSet rs = null;
		board bd = null;
		try {
			pst = con.prepareStatement(sql); // sql얻어옴
			pst.setString(1, code);
			rs = pst.executeQuery(); // 실행
			
			while (rs.next()) {
				bd = new board();
				bd.setQuestionCode(rs.getInt(1));
				bd.setBuyerId(rs.getString(2));
				bd.setTitle(rs.getString(3));
				bd.setQuestionContents(rs.getString(4));
				bd.setWriteDate(rs.getString(5));
				//bd.setBbsAvailable(rs.getInt(6));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 해제
		close(rs, pst, con);
		return bd;
	}
	
	public void insertContents(board b) {
		// db연결
		Connection con = dbcon();
		// sql작성
		String sql = "insert into questiontbl2 values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			// sql실행
			pst = con.prepareStatement(sql);
			pst.setInt(1, b.getQuestionCode()); // table의 스키마를 확인하고 해야됨
			pst.setString(2, b.getBuyerId());
			pst.setString(3, b.getTitle());
			pst.setString(4, b.getQuestionContents());
			pst.setString(5, b.getWriteDate());
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		// 연결해제
		close(pst, con);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		boardDAO dao = new boardDAO();
		ArrayList<board> list = dao.getList();
		for(board b : list) {
			System.out.println(b +"<br>");
		}
		
	}

	public void saveData(String data) {
		// TODO Auto-generated method stub
		
	}
}
	
