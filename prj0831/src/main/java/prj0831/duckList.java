package prj0831;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/duckList")
public class duckList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//Model 얻어오기
				//ServiceMVC5 s = new ServiceMVC5();
				//ArrayList<Member> list = s.getList();
				ServiceDuckList d = new ServiceDuckList();
				ArrayList<Duck> list = d.getList();
				
				//Model심기
				//request.setAttribute("list", list);
				//request.getRequestDispatcher("WEB-INF/views/acornlist.jsp").forward(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("WEB-INF/views/DuckList.jsp").forward(request, response);
		
	}
	
	
}
