package practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sayhello")
public class sayHelloAtFiveTime extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setAttribute("shf", "안녕하세요");
		req.getRequestDispatcher("WEB-INF/views/sayHelloAtFiveTime.jsp").forward(req, resp);
	}
}
