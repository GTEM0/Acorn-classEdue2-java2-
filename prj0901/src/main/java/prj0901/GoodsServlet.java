package prj0901;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/goods")
public class GoodsServlet  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
				
		
		GoodsDAO dao = new GoodsDAO();
		ArrayList<Coffee> list = dao.selectAll2();
		
		
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/goodslist.jsp").forward(req, resp);
		
		
		
		
	}
}
