package prj0831;

import java.util.ArrayList;

public class ServiceDuckList {

	
	public ArrayList<Duck> getList(){
		
		ArrayList<Duck> list = new ArrayList<>();
		list.add(new Duck("PsychoDuck", "used Psychokinesis", "8"));
		list.add(new Duck("FireDuck", "used Fire like the Sun", "8"));
		list.add(new Duck("StoDuck", "used Storm", "7"));
		list.add(new Duck("ZomDuck", "resurrection", "2"));
		
		return list;
	}
}
