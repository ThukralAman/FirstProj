package learncollections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 *   1. Retrieving values from HashMap is not the same order as insertion. HashMap does not store order of insertion.
 *   2. Adding a new value for existing key say key1, will update the old value associated with key1 to new value.
 *   3. Two keys say key1 and key2 can have same values. ALLOWED:{key1:val1, key2:val1} NOT_ALLOWEDP{key1:10, key1:20}
 *    
 */
public class LearnHashMap {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("Aman", 65);
		hm.put("Thukral", 66);
		hm.put("Test", 67);
		
		System.out.println(hm.get("Aman"));
		
		
		// Looping over keys - Method: keySet()
		System.out.println("Looping over all entries");
		for(String p:hm.keySet()) {
			System.out.print(p + " -> ");
			System.out.println(hm.get(p));
		}
		
		// Size of HashMap - Method: size()
		System.out.println("Hash map size = " + hm.size());
		
		
		// looping over values only - Method: values()
		Collection<Integer> values = hm.values();
		for(Integer val: values) {
			System.out.println(val);
		}
		
		// Looping over key:Val pair Method: Map.Entry<key,val> & entrySet()
		for(Map.Entry<String, Integer> e: hm.entrySet() ) {
			System.out.print(e.getKey() + " -> ");
			System.out.println(e.getValue());
		}
	}
}
