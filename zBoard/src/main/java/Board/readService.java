package Board;

import java.util.ArrayList;

public class readService {

	boardDAO dao = new boardDAO();

	public ArrayList<board> board() {

		ArrayList<board> list = dao.getContents();
		for (board b : list) {
			System.out.println(b + "<br>");
		}
		return list;

	}
}
