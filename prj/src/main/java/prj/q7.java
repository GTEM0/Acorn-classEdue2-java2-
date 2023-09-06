package prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cheerup")
public class q7 extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");					//html, css
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2> Go for it!!!(/≧▽≦)/</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
