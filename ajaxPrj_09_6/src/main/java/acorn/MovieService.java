package acorn;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieService {

	TestDAO dao = new TestDAO();

	public JSONObject getFoodInfo() {
		Movie movie = new Movie("엘리먼트", "11000");
		JSONObject m = new JSONObject();
		m.put("title", movie.getTitle());
		m.put("price", movie.getPrice());

		return m;
	}

	public JSONArray getMovieList() {
		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie("엘리먼트", "11000"));
		list.add(new Movie("킹스맨", "10000"));
		list.add(new Movie("데드풀", "8000"));
		JSONArray arr = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Movie f = list.get(i);
			JSONObject n = new JSONObject();
			n.put("title", f.getTitle());
			n.put("price", f.getPrice());
			arr.put(n);
		}
		return arr;
	}

	public JSONArray getmovieRealList() {

		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie("엘리먼트", "11000"));
		list.add(new Movie("킹스맨", "10000"));
		list.add(new Movie("데드풀", "8000"));

		JSONArray arr = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			Movie f = list.get(i);
			JSONObject o = new JSONObject();
			o.put("title", f.getTitle());
			o.put("price", f.getPrice());
			arr.put(o);			 
		}
		return arr;
	}

}
