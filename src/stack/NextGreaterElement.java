package stack;

import java.util.Stack;

public class NextGreaterElement {
	
	void NGE(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();

		st.push(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
			int next = arr[i];
			
			
			
			while(!st.empty() && st.peek() < next) {
				System.out.println("NGE pair- " + st.peek() + " : " + next);
				st.pop();
			}
			
			st.push(next);
		}
		
		while(!st.empty()) {
			System.out.println("NGE pair - " + st.pop() + " : " + -1);
		}
		
		
	}
	
	public static void main(String[] args) {
		NextGreaterElement obj = new NextGreaterElement();
		int[] arr  = {9, 7, 6, 4, 5, 8};
		obj.NGE(arr);
	}
}
