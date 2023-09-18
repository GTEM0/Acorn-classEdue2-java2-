package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbsDAO {

	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/bbs";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch (Exception e){
			e.printStackTrace();
		}
			
	}
	
	public String getDate() {
		String sql = "select now()"; 	
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return "";	//데이터베이스 오류
	}

	public int getNext() {
		String sql = "select bbsID from bbs order by bbsID desc"; 	
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;	//첫 번째 게시물인 경우
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -1;	//데이터베이스 오류
	}

	public int write(String bbsTitle, String userID, String bbsContent) {
		String sql = "insert into BBS values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);			
			pst.setInt(1, getNext());
			pst.setString(2, bbsTitle);
			pst.setString(3, userID);
			pst.setString(4, getDate());
			pst.setString(5, bbsContent);
			pst.setInt(6, 1);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -1;	//데이터베이스 오류
	}

	public ArrayList<Bbs> getList(int pageNumber) {

		String sql = "select * from BBS where bbsID < ? and bbsAvailable = 1 order by bbsID desc limit 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, getNext() - (pageNumber-1) * 10);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return list;
	}

	public boolean nextPage(int pageNumber) {
		String sql = "select * from BBS where bbsID < ? and bbsAvailable = 1";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, getNext() - (pageNumber-1) * 10);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return false;
	}

	
}
