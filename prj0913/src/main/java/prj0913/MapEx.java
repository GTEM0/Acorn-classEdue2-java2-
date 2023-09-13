package prj0913;

import java.util.ArrayList;
import java.util.HashMap;

public class MapEx {
	public static void main(String[] args) {
		
		//Map
		//키, 값의 형태로 데이터 저장함
		//		  키		  값
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, ArrayList<String>> map2 = new HashMap<>();
		
		map.put("key1", "apple");
		map.put("key2", "banana");
		map.put("key3", "mango");
		
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("mango");
		
		ArrayList<String> list2 = new ArrayList<>();
		list.add("아메리카노");
		list.add("라떼");
		list.add("셰이크샥");
		
		ArrayList<String> list3 = new ArrayList<>();
		list.add("휘낭시에");
		list.add("까눌레");
		list.add("몽블랑");
		
		map2.put("fruit", list);
		map2.put("beverage", list2);
		map2.put("dessert", list3);
		
//		String result1 = map.get("key1");
//		String result2 = map.get("key2");
//		String result3 = map.get("key3");
//		
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
		
		ArrayList<String> resultList1 = map2.get("fruit");
		for(String f:resultList1) {
			System.out.println(f);
		}
		
		ArrayList<String> resultList2 = map2.get("beverage");
		for(String b:resultList2) {
			System.out.println(b);
		}
	}
}
