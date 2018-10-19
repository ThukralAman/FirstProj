package array;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] num = {1,2,3,4,5,6,7/*,8,9,10,11,12, 13, 14, 15*/};
		int[] num = {4,5,6,7,8,9};
		int num1[] = new int[num.length];
		int[] arr = rotateArrayMethod(num, 2);
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] rotateArrayMethod(int[] num, int d) {
		int n = num.length;
		int gcd = getGcd(num.length, d);
		int buckets = n/gcd;
		//int startIndex = (buckets-1) * gcd;
		//int temp = num[startIndex];
		for(int k=0; k<(d/gcd); k++) { 
			// move left each index of bucket of size = gcd time complexity of this nested two for loops = O(n)
			for(int i=0; i<gcd; i++) {
				int temp = num[i];
				for(int j=i; j<n; j=j+gcd) {
					int copyFromIndex = (j+gcd+n)%n;
					if(copyFromIndex == i) {
						num[j] = temp;
					}
					else{
						num[j] = num[copyFromIndex];
					}
				}
			}
		}
		
		return num;
	}
	
	// assumes input is of form a>b
	static int getGcd(int a, int b) {
		if(b==0) {
			return a;
		}
		
		else {
			return getGcd(b, a%b);
		}
	}
	

}
