package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao2 {

    // Oracle 데이터베이스 연결을 위한 드라이버, URL, 사용자 이름, 비밀번호 정보 설정
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "scott";
    String password = "tiger";

    // 데이터베이스 연결을 수행하는 메서드
    public Connection dbcon() {
        Connection con = null;
        try {
            // JDBC 드라이버 클래스 로드
            Class.forName(driver);
            // 데이터베이스에 연결
            con = DriverManager.getConnection(url, user, password);
            if (con != null)
                System.out.println("연결 성공");

        } catch (ClassNotFoundException e) {
            // JDBC 드라이버 클래스를 찾을 수 없는 경우 예외 처리
            e.printStackTrace();
        } catch (SQLException e) {
            // 데이터베이스 연결 실패 시 예외 처리
            e.printStackTrace();
        }
        return con;
    }

    // 회원 데이터 총 개수를 반환하는 메서드
    public int getTotalCnt() {
        Connection con = dbcon(); // 데이터베이스 연결

        String sql = "select count(*) from member_tbl_11"; // 회원 테이블의 레코드 수를 세는 SQL 쿼리

        int totalCnt = 0;

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                totalCnt = rs.getInt(1); // 레코드 수를 변수에 저장
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        }
        close(); // 데이터베이스 연결 종료
        return totalCnt;
    }

    // 모든 회원 정보를 가져오는 메서드
    public ArrayList<Member> selectAll() {
        Connection con = dbcon(); // 데이터베이스 연결
        String sql = "select * from member_tbl_11"; // 모든 회원 정보를 가져오는 SQL 쿼리
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Member> list = new ArrayList<>();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                // 각 회원 정보를 변수에 저장
                String m_id = rs.getString(1);
                String m_pw = rs.getString(2);
                String m_name = rs.getString(3);
                String m_tel = rs.getString(4);
                String m_birthday = rs.getString(5);
                int m_point = rs.getInt(6);
                String m_grade = rs.getString(7);
                // Member 객체 생성 및 리스트에 추가
                Member m = new Member(m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        }
        close(rs, pst, con); // 데이터베이스 연결 종료
        return list;
    }

    // 현재 페이지에 대한 회원 목록을 가져오는 메서드
    // 입력: int page, int pageSize (현재 페이지 번호, 페이지 크기)
    // 반환: ArrayList<Member> (회원 목록)
    public ArrayList<Member> getListPage(int page, int pageSize) {
        int startPage = 0, endPage = 0;

        // 페이지 시작과 끝 인덱스 계산
        startPage = ((page - 1) * pageSize) + 1;
        endPage = page * pageSize;

        Connection con = dbcon(); // 데이터베이스 연결
        PreparedStatement pst = null;
        ResultSet rs = null;

        // 페이지 범위에 해당하는 회원 정보를 가져오는 SQL 쿼리
        String sql = "select * " +
                     "from (select rownum num, m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade " +
                     "from member_tbl_11) " +
                     "where num between ? and ?";

        System.out.println(sql);
        ArrayList<Member> list = new ArrayList<>();

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, startPage);
            pst.setInt(2, endPage);
            rs = pst.executeQuery();

            while (rs.next()) {
                // 각 회원 정보를 변수에 저장
                String m_id = rs.getString(2);
                String m_pw = rs.getString(3);
                String m_name = rs.getString(4);
                String m_tel = rs.getString(5);
                String m_birthday = rs.getString(6);
                int m_point = rs.getInt(7);
                String m_grade = rs.getString(8);
                // Member 객체 생성 및 리스트에 추가
                Member m = new Member(m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        }
        close(rs, pst, con); // 데이터베이스 연결 종료
        return list;
    }

    // AutoCloseable 객체들을 닫는 메서드
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
            System.out.println("연결 성공");

        int result = dao.getTotalCnt();
        System.out.println(result);

        ArrayList<Member> list = dao.getListPage(2, 4);
        System.out.println(list);
    }
}
