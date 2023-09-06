package prj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upup")
public class q8 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plane"); 
		PrintWriter out = resp.getWriter();
		
        int random = (int)(Math.random()*6);
		if(random==0) {
			out.println("힘내세요!");
		}
		else if(random==1) {
			out.println("포기하지마요!");
		}
		else if(random==2) {
			out.println("조금만 더 하면 됩니다!");
		}
		else if(random==3) {
			out.println("잘하고 있어요!");
		}
		else if(random==4) {
			out.println("긍정적인 마음으로 화이팅!");
		}
		else if(random==5) {
			out.println("넌 할 수 있어!");
		}
    }
}
