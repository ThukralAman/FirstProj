package Recursion;

public class PowerSet {
	
	public void printPowerSet(int[] set) {
		int numOfSets = (int) Math.pow(2, set.length);
		
		for(int i=0; i<numOfSets; i++) {
			System.out.print("{");
			for(int j=0; j<set.length; j++) {
				if( (i & (1<<j)) !=0) {
					System.out.print(set[j] + ", ");
				}
			}
			System.out.println("}");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] set = {1,2,3};
		new PowerSet().printPowerSet(set);
	}

}
