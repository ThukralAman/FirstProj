package array;

////https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
//This solution fails at input aaabbbcc ... Use heap for correct solution

public class ReorderStringWithNoAdjacentSameCharacter {
	
	public void rearrange(char[] arr) {
		int index=0;
		//int i=0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]==arr[i+1]) {
				for(int j=i+2; j<arr.length; j++) {
					if(arr[j] != arr[i]) {
						arr[i+1] = arr[j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabbbcc";
		char[] arr = s.toCharArray();
		
		ReorderStringWithNoAdjacentSameCharacter obj = new ReorderStringWithNoAdjacentSameCharacter();
		obj.rearrange(arr);
		String s1 = new String(arr);
		System.out.println(s1);
		
		
		

	}

}
