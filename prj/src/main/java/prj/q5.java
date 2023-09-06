package prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggg")
public class q5 extends HttpServlet{

	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	
		
		
	String i_ = request.getParameter("나타내고 싶은 별의 개수를 입력하세요");
	for (int i = 1; i < i; i++) {
	    out.println("*");
		}
	
	}
}
