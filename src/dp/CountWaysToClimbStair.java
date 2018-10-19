package dp;

import java.util.HashMap;

public class CountWaysToClimbStair {
	
	
	public int countWays(int stairHeight) {
		if(stairHeight < 0) {
			return 0;
		}
		if (stairHeight == 0) {
			return 1;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		
		if(map.get(stairHeight) == null) {
			map.put(stairHeight, countWays(stairHeight -1) + countWays(stairHeight-2)) ;
		}
		return map.get(stairHeight);
		
		//return countWays(stairHeight -1) + countWays(stairHeight-2);
		
		
	}
	
	
	public static void main(String[] args) {
		int result = new CountWaysToClimbStair().countWays(4);
		System.out.println("Not working ??");
		System.out.println("result = " + result);
	}

}
