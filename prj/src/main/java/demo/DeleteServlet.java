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
 * Servlet implementation class ArticleDeleteServlet
 */
@WebServlet("/doDelete")
public class DeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        String sql = "DELETE from article WHERE id = "+id+";";
        response.getWriter().append(id);

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

        response.getWriter().append("<script> alert('파일이 삭제되었습니다.'); </script>");
        response.getWriter().append("<script> location.replace('./List.jsp'); </script>");
      }
    }