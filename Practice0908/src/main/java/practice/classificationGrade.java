package practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cg")
public class classificationGrade extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int kor = 60;
		req.setAttribute("score", kor);
		req.getRequestDispatcher("WEB-INF/views/classificationGrade.jsp").forward(req, resp);
	}
	
}
