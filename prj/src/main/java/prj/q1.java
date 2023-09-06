package prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hapfourth")
public class q1 extends HttpServlet{
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String su3_ = request.getParameter("su3");
			String su4_ = request.getParameter("su4");
			String su1_ = request.getParameter("su1");
			String su2_ = request.getParameter("su2");
			
					
			int su3 = Integer.parseInt(su3_);
			int su4 = Integer.parseInt(su4_);
			int su1 = Integer.parseInt(su1_);
			int su2 = Integer.parseInt(su2_);
			
			int sum = su1 + su2 + su3 + su4;
		
			PrintWriter out = response.getWriter();
			out.print(sum);
		}
}
