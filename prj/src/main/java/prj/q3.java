package prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbb")
public class q3 extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String i_ = request.getParameter("i");
		String j_ = request.getParameter("j");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		
		for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++)
            {
            	out.println(i+ "x" + j + "=" + i*j);
            }
            out.println("<br>");
            
        }
		out.println("</body>");
        out.println("</html>");
				
		
	}
}
