package prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hap")
public class Ex02 extends HttpServlet{
@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
					//키 이름으로 value 값을 얻어올 수 있다
	String su1_ = request.getParameter("su1");
	String su2_ = request.getParameter("su2");
	
			
	int su1 = Integer.parseInt(su1_);
	int su2 = Integer.parseInt(su2_);
	
	int sum = su1 + su2;
	
	PrintWriter out = response.getWriter();
	out.print(sum);
}

}