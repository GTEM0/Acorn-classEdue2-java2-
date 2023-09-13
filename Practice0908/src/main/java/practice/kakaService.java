package practice;

import java.util.ArrayList;

public class kakaService {

	kakaDAO dao = new kakaDAO();
	
	public ArrayList<kaka> selectAll(){
		ArrayList<kaka> list = dao.selectAll();
		return list;
	}
}
