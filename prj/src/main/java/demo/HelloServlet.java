package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ArticleAddServlet
 */
@WebServlet("/doadd")
public class HelloServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String nickname = request.getParameter("nickname");
        String body = request.getParameter("body");
        
        while (title.equals("") || body.equals("") || nickname.equals("")) {
			response.getWriter().append("<script> alert('공란이 없게 작성해주세요.'); </script>");
			response.getWriter().append("<script> location.replace('./Write.jsp'); </script>");		
		} 

        String sql = "INSERT INTO article SET regDate = NOW(), title = '"+title+"', body = '"+body+"', nickname = '"+nickname+"';";

        String dbDriver = "com.mysql.cj.jdbc.Driver";

        
        String dbUrl = "jdbc:mysql://localhost:3306/a1?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String dbUser = "root";
        String dbPass = "";

        Connection con = null;
        Statement stmt = null;

        try {
          Class.forName(dbDriver);

        
          con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
          stmt = con.createStatement();
          stmt.executeUpdate(sql);

        } catch (SQLException e) {
          System.out.println("SQLException : " + e.getMessage());
        } catch (ClassNotFoundException e) {
          System.out.println("ClassNotFoundException : " + e.getMessage());
        } finally {
          if (stmt != null) {
            try {
              stmt.close();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
          if (con != null) {
            try {
              con.close();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        }

        response.getWriter().append("<script> alert('게시물이 작성되었습니다.'); </script>");
        response.getWriter().append("<script> location.replace('./List.jsp'); </script>");
      }
    }