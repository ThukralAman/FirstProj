package Recursion;

public class Demo {

	public static void main(String[] args) {
		
		
		String str = "1234";
		
		int l = 1;
		int r = (int)Math.pow(2, str.length());
		
		printAll(str,l,r,str.length());
	}
	
	private static void printAll(String str, int l,int r, int n) {
		
		if(l > r) {
			
			return ;
		}
		
		int temp = l;
		
		for(int i = 0 ; i < n; i++) {
			
			if((temp&1) == 1) {
				
				System.out.print(str.charAt(i));
			}
			temp = temp >> 1;
		}
		System.out.println();
		
		printAll(str,l+1,r,n);
	}
}
 