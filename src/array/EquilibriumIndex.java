package array;

/*
 *  #must do array question gfg
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */

public class EquilibriumIndex {
	
	public int getEquilibriumIndex(int[] arr) {
		if(arr.length == 0) {
			return -1;
		}
		
		int leftSum = 0;
		int rightSum = 0;
		
		
		for(int i=0; i<arr.length; i++) {
			rightSum = rightSum + arr[i];
		}
		System.out.println("sum = " + rightSum);
		
		for(int i=0; i<arr.length; i++) {
			if(rightSum-arr[i] == leftSum) {
				return i;
			}
			leftSum = leftSum + arr[i];
			rightSum = rightSum - arr[i];
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EquilibriumIndex obj = new EquilibriumIndex();
		
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		int arr1[] = {};
		System.out.println("empty array = " + arr);
		int res = obj.getEquilibriumIndex(arr);
		System.out.println("equilibrium Index = " + res);
		
		

	}

}
