package acorntbl;

import java.util.ArrayList;

public class TestAcornService {
	
	TestDAO2 dao = new TestDAO2();
	
	public ArrayList<Test> getAllList(){
		ArrayList<Test> list = dao.getAcornList();
		
		return list;
	}

}
