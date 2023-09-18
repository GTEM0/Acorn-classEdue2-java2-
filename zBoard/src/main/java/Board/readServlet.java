package Board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class readServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardService bs = new BoardService();

		ArrayList<board> list = bs.board();
		System.out.println(list);
		req.setAttribute("list", list);

		req.getRequestDispatcher("WEB-INF/views/read.jsp").forward(req, resp);
	}
}
