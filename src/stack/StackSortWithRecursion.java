package stack;

/**
 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 * 
 * 
 * 
 * 
 */

import java.util.Stack;

public class StackSortWithRecursion {
	
	void sortedInsert(Stack<Integer> st, int item) {
		if(st.empty()) {
			st.push(item);
		}else if(st.peek() > item) {
			int elem = st.pop();
			sortedInsert(st, item);
			st.push(elem);
		}else {
			st.push(item);
		}
	}
	
	void sort(Stack<Integer> st) {
		
		if(!st.empty()) {
			int elem = st.pop();
			sort(st);
			sortedInsert(st, elem);
		}
		
	}

	public static void main(String[] args) {
		StackSortWithRecursion obj = new StackSortWithRecursion();
		Stack<Integer> st = new Stack<Integer>();
		st.push(-3); 
		st.push(14);
		st.push(18);
		st.push(-5);
		st.push(30);
		
		System.out.println("Stack before sort: " + st);
		obj.sort(st);
		System.out.println("Stack after sort: " + st);
	}
}
