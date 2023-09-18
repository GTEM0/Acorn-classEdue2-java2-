package Board;

import java.util.ArrayList;

public class BoardService {

	boardDAO dao = new boardDAO();

	public ArrayList<board> board() {

		ArrayList<board> list = dao.getList();
		for(board b : list) {
			System.out.println(b +"<br>");
		}
		return list;

	}
}
