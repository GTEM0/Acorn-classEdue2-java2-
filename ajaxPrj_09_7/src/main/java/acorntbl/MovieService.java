package acorntbl;

import java.util.ArrayList;

public class MovieService {

	MovieDAO dao = new MovieDAO();
	
	public ArrayList<Movies> getMoviesList(){
		ArrayList<Movies> list = dao.getAllList();
		return list;
	}
}
