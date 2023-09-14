package practice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class kakaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		kakaService ks = new kakaService();
		ArrayList<kaka> list = ks.selectAll();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/kaka.jsp").forward(req, resp);
		
		
		
	}
	
}
