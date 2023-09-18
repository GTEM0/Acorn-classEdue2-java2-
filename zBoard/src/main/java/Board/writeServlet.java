package Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class writeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String questionCode = req.getParameter("questionCode");
		String buyerId = req.getParameter("buyerId");
		String title = req.getParameter("title");
		String questionContents = req.getParameter("questionContents");
		String writeDate = req.getParameter("writeDate");
//		int bbsAvailable = req.getParameter("bbsAvailable");
		
		writeService ws = new writeService();
		ws.registerMember(new board());
		req.getRequestDispatcher("WEB-INF/views/write.jsp").forward(req, resp);
	}
}
