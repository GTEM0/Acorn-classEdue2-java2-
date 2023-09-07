package acorntblPrj230905;

import java.util.ArrayList;

public class AcornService {

	AcornDAO2 dao = new AcornDAO2();
	
	public ArrayList<String> getMemberList(){
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("곽단야");
		list.add("김민규");
		list.add("김민지");
		
		return list;
	}
	
	public ArrayList<String> getMemberRealList(){
		ArrayList<String> list = dao.selectAll();
		return list;
			
	}
	
	public void registerMember(Customer c) {
		dao.insertMember3(c);		
	}
	
	public Customer getMember(String id) {
		Customer c = dao.selectOne(id);
		return c;
	}
	
	public void deleteMember(String id) {
		dao.deleteOne(id);
	}
	
	public void modifyMember(Customer c) {
		dao.updateMember(c);
	}
}
