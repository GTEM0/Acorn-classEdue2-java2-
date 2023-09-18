package Board;


public class writeService {
	boardDAO dao = new boardDAO();
	
	public void registerMember(board b) {
		dao.insertContents(b);
	}
}
