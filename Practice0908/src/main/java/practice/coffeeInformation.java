package practice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class coffeeInformation extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			ArrayList<Coffee> coffee = new ArrayList<>();
			
			coffee.add(new Coffee("c001", "아메리카노", 2000));
			coffee.add(new Coffee("c002", "플레인요거트스무디", 4000));
			coffee.add(new Coffee("c003", "팥쉐이크", 4000));
			
						
			req.setAttribute("coffee", coffee);
			req.getRequestDispatcher("WEB-INF/views/coffeeInformation.jsp").forward(req, resp);
		}
}
