package acorntbl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestAcornServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TestAcornService t = new TestAcornService();
		
		ArrayList<Test> list = t.getAllList();
		System.out.println(list);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/acorn.jsp").forward(req, resp);
		
		
	}
	
}
