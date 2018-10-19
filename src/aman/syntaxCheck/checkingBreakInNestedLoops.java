package aman.syntaxCheck;

public class checkingBreakInNestedLoops {
	
	public static void main(String[] args) {
		
		for(int i=1; i<10; i++) {
			for(int j=11; j<20; j++) {
				System.out.println("i = " + i + " j = " + j);
				if(j==15) {
					break;
				}
			}
		}
	}

}
