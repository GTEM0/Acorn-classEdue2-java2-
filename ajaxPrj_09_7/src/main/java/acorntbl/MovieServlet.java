package acorntbl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/movies")
public class MovieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieService m = new MovieService();
		
		ArrayList<Movies> list = m.getMoviesList();
		System.out.println(list);
		
		req.setAttribute("movie", list);
		req.getRequestDispatcher("WEB-INF/views/movie.jsp").forward(req, resp);
		
	}
}
