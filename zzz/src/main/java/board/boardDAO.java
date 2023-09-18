package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import Board.board;

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

				e.printStackTrace();
			}
		}
	}

	public String getDate() {
		Connection con = dbcon();
		String sql = "select * from questionTbl2()";
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류
	}

	public int getNext() {
		Connection con = dbcon();
		String sql = "select * from questionTbl2()";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public ArrayList<board> getList(int pageNumber) {

		Connection con = dbcon();
		String sql = "select * from questionTbl2()";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<board> list = new ArrayList<board>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pst.executeQuery();
			while (rs.next()) {
				board bd = new board();
				bd.setQuestionCode(rs.getInt(1));
				bd.setBuyerId(rs.getString(2));
				bd.setTitle(rs.getString(3));
				bd.setQuestionContents(rs.getString(4));
				bd.setWriteDate(rs.getString(5));
				bd.setBbsAvailable(rs.getInt(6));
				list.add(bd);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean nextPage(int pageNumber) {
		Connection con = dbcon();
		String sql = "select * from questionTbl2()";
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
