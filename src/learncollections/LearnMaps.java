package learncollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearnMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Map<Integer, String> map = new HashMap<Integer, String>();	 // Uses core hashing logic 
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();  // Uses core hashing logic + Doubly linked list
		//Map<Integer, String> map = new TreeMap<Integer, String>();     // Uses core hashing logic + red black tree
		
		map.put(42, "FourtyTwo");
		map.put(32, "ThirtyTwo");
		map.put(25, "TwentyFive");
		map.put(12, "Twelve");

		System.out.println(map);
		
		for(Integer key: map.keySet()) {
			System.out.println("key:val = " + key + ":" + map.get(key));
		}
		

	}

}
