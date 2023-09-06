package prj0901;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class coffeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		coffeeService cs = new coffeeService();
		ArrayList<String> lista = cs.getRealList();
		System.out.println(lista);
		
		request.setAttribute("listt", lista);
		request.getRequestDispatcher("WEB-INF/views/coffee.jsp").forward(request, response);
	}
}
