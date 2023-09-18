package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class writeDAO {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:testdb";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";

    public List<Map<String, Object>> getArticles() {
        List<Map<String, Object>> articles = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM questionTbl2 ORDER BY questionCode DESC");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String regDate = rs.getString("regDate");
                String title = rs.getString("title");
                String body = rs.getString("body");
                String nickname = rs.getString("nickname");

                Map<String, Object> article = new HashMap<>();
                article.put("id", id);
                article.put("regDate", regDate);
                article.put("nickname", nickname);
                article.put("title", title);
                article.put("body", body);

                articles.add(article);
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }

        return articles;
    }

    public static void main(String[] args) {
        writeDAO writeDAO = new writeDAO();
        List<Map<String, Object>> articles = writeDAO.getArticles();
        
        // 아래 부분을 수정합니다.
        System.out.println("<form action='./doDelete'>");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            Map<String, Object> article = articles.get(i);
        
            System.out.println("<div>");
            System.out.println("번호 : " + article.get("id"));
            System.out.println("</div>");
            System.out.println("<div>");
            System.out.println("별명 : " + article.get("nickname"));
            System.out.println("</div>");
            System.out.println("<div>");
            System.out.println("작성일 : " + article.get("regDate"));
            System.out.println("</div>");
            System.out.println("<div>");
            System.out.println("제목 : " + article.get("title"));
            System.out.println("</div>");
            System.out.println("<div>");
            System.out.println("내용 : " + article.get("body"));
            System.out.println("</div>");
            System.out.println("<div>");
            System.out.println("<input type='hidden' name='id' value='" + article.get("id") + "'>");
            System.out.println("</div>");
            System.out.println("<div>");
            System.out.println("<button onclick=\"location.href = 'http://localhost:8081/Exam1/doDelete?id=" + article.get("id") + "';\">삭제</button>");
            System.out.println("</div>");
        }
        System.out.println("</form>");
        System.out.println("<hr>");
    }
}
