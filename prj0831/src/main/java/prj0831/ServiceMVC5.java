package prj0831;

import java.util.ArrayList;

public class ServiceMVC5 {
	
	
	public ArrayList<Member> getList(){
		
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member("dy", "4482", "곽단야"));
		list.add(new Member("mg", "4482", "김민규"));
		list.add(new Member("mj", "4482", "김민지"));
		list.add(new Member("bj", "4482", "김병진"));
		list.add(new Member("jy", "4482", "김재열"));
		
		return list;
	}
		
		
		
	

}
