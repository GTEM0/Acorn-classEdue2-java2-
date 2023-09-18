package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

		private Connection con;
		private PreparedStatement pst;
		private ResultSet rs;
		
		public UserDAO() {
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
		
		public int login(String userID, String userPassword) {
			String sql = "select userPassword from USER whrer userID = ?";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, userID);
				rs = pst.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).equals(userPassword))
						return 1;	//로그인 성공
					else
						return 0;	//비밀번호 불일치
				}
				return -1;	//아이디 없음
			}catch(Exception e) {
				e.printStackTrace();
			}
			return -2;	//데이터베이스 오류
		}
		
		public int join(User user) {
			String sql = "insert into user values(?,?,?,?,?)";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, user.getUserID());
				pst.setString(2, user.getUserPassword());
				pst.setString(3, user.getUserName());
				pst.setString(4, user.getUserGender());
				pst.setString(5, user.getUserEmail());
				return pst.executeUpdate();				
			}catch(Exception e){
				e.printStackTrace();
			}
			return -1;	//데이터베이스 오류
		}
}
