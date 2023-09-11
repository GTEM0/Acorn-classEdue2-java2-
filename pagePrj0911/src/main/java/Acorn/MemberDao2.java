package Acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao2 {

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
				System.out.println("ok");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public int getTotalCnt() {

		Connection con = dbcon();
		String sql = "select count(*) from acorntbl";

		int totalCnt = 0;

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		close();
		return totalCnt;
	}

	public ArrayList<Member> selectAll() {

		Connection con = dbcon();
		String sql = "select * from acorntbl";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				String m_id = rs.getString(1);
				String m_pw = rs.getString(2);
				String m_name = rs.getString(3);
				
				Member m = new Member(m_id, m_pw, m_name);
				list.add(m);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;
	}

	// 현재페이지에 대한 목록 가져오기
	// 입력 : int page, int pageSize (현재페이지번호 , 페이지size크기)
	// 반환 : ArrayList<Member> (고객목록)

	public ArrayList<Member> getListPage(int page, int pageSize) {
		// pageSize = 4 한 페이지에 보일 글의 수 : 4라고 했을 때
		// 1 => ( 1~ 4)
		// 2 => ( 5~ 8)
		int startPage = 0, endPage = 0;

		startPage = ((page - 1) * pageSize) + 1;
		endPage = page * pageSize;

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = " select * " + " from (select m_id, m_pw, m_name "
				+ " from acorntbl) " + " where id between ? and ?";

		System.out.println(sql);
		ArrayList<Member> list = new ArrayList<>();

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, startPage);
			pst.setInt(2, endPage);
			rs = pst.executeQuery();

			while (rs.next()) {
				String m_id = rs.getString(2);
				String m_pw = rs.getString(3);
				String m_name = rs.getString(4);
				
				Member m = new Member(m_id, m_pw, m_name);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;
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

	public static void main(String[] args) {

		MemberDao2 dao = new MemberDao2();
		if (dao.dbcon() != null)
			System.out.println("ok");

		int result = dao.getTotalCnt();
		System.out.println(result);

//		ArrayList<Member> list=dao.selectAll();
//		System.out.println(list);

		ArrayList<Member> list = dao.getListPage(2, 4);
		System.out.println(list);
	}
}
