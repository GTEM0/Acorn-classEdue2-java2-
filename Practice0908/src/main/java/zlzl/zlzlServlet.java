package zlzl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/zlzl")
public class zlzlServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		zlzlService zs = new zlzlService();
		ArrayList<zlzl>list = zs.selectAll();	
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/zlzl.jsp").forward(req, resp);
		
		
		
	}
	
}
