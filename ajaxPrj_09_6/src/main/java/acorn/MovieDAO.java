package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {

	// 데이터베이스 연결정보
	String driver = "oracle.jdbc.driver.OracleDriver"; // Oracle JDBC 드라이버 클래스
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 접속 URL
	String user = "scott"; // 데이터베이스 사용자 이름
	String password = "tiger"; // 데이터베이스 사용자 비밀번호

	// 데이터베이스 연결을 반환하는 메서드
	public Connection dbcon() {
		Connection con = null;
		// 객체 생성하는 코드
		try {
			Class.forName(driver); // JDBC 드라이버 클래스 로드
			con = DriverManager.getConnection(url, user, password); // 데이터베이스 연결 객체 생성
			if (con != null)
				System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) { // JDBC 드라이버 클래스를 찾지 못한 경우 예외 처리
			e.printStackTrace();
		} catch (SQLException e) { // SQL 예외 처리
			e.printStackTrace();
		}
		return con; // 연결된 데이터베이스 연결 객체 반환
	}

	// 영화 목록을 가져오는 메서드
	public ArrayList<Movie> getMovieList() {
		Connection con = dbcon(); // 데이터베이스 연결 객체 생성
		String sql = "select * from movietbl"; // SQL 쿼리문
		ArrayList<Movie> list = new ArrayList<>(); // 영화 목록을 저장할 ArrayList 생성

		try {
			PreparedStatement pst = con.prepareStatement(sql); // SQL 쿼리를 실행할 PreparedStatement 생성
			ResultSet rs = pst.executeQuery(); // SQL 쿼리 실행 결과를 저장할 ResultSet 객체 생성

			while (rs.next()) { // 결과 집합의 다음 레코드로 이동
				String title = rs.getString(1); // 첫 번째 열의 데이터를 문자열로 가져옴 (영화 제목)
				String price = rs.getString(2); // 두 번째 열의 데이터를 문자열로 가져옴 (가격)

				Movie movie = new Movie(title, price); // Movie 객체 생성
				list.add(movie); // 영화 목록에 추가
			}
			rs.close(); // ResultSet 객체 닫기
			pst.close(); // PreparedStatement 객체 닫기
			con.close(); // 데이터베이스 연결 닫기

		} catch (SQLException e) { // SQL 예외 처리
			e.printStackTrace();
		}
		return list; // 영화 목록 반환
	}

	public static void main(String[] args) {
		MovieDAO m = new MovieDAO(); // movieDAO 객체 생성

		ArrayList<Movie> list = m.getMovieList(); // 영화 목록 가져오기
		System.out.println(list); // 영화 목록 출력
	}
}
