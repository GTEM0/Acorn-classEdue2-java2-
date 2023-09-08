package practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sbn")
public class stringBookName extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("stringBookName", new String[]{"소설", "역사", "인문", "정치", "미술", "종교", "여행", "과학"});
		req.getRequestDispatcher("WEB-INF/views/stringBookName.jsp").forward(req, resp);
	}
}

