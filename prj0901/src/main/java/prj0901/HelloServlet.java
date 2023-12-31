package prj0901;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 인사제공하기
// 학생리스트 제공하기 (데이터베이스에서 조회된 결과)
@WebServlet("/hi")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//모델 Service
		HelloService h = new HelloService();	//약어는 맘대로, 서비스부분 java랑 이름 동일하게해야됨
		String aptpwl = h.getMessage();	//aptpwl 이부분은 맘대로 써도됨
		
		//모델심기
		request.setAttribute("msg", aptpwl);//aptpwl 이부분은 위에 맘대로 쓴거랑 맞춰주기
		//view로 forward
		request.getRequestDispatcher("WEB-INF/views/hello.jsp").forward(request, response);
		
		
		
	}
}
