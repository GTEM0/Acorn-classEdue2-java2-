package practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onetoten")
public class oneTotenServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setAttribute("ott", "이건 EL일까 JSTL일까?");
		req.getRequestDispatcher("WEB-INF/views/onetoten.jsp").forward(req, resp);
	}
	
}
