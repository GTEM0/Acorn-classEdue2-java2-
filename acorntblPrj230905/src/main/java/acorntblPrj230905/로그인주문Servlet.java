package acorntblPrj230905;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order")
public class 로그인주문Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id != null) {
			req.getRequestDispatcher("WEB-INF/views/order.jsp").forward(req, resp);
			
		}else {
			resp.sendRedirect("/acorntblPrj230905/login");
		}
	}
	
}
