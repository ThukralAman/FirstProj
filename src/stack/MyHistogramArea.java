package stack;

import java.util.Stack;

public class MyHistogramArea {
	
/*
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * This one is tough like other merge sort type algorithms
 * 
 * lets say value we have is {2, 4, 6, 3, 1 }
 * 
 * 1.  Iterate over the given array i = 0-(n-1)
 * 2.  initially stack is sempty so add the first value stack: index{0} val{2}
 * 3.  Now for subsequent arr[] values 
 * ->IF (arr[i] > top value at stock) OR (stack empty), then add to stack and increment i++. This is because 
 * there previous entry in stack can form rectangle with this entry 
 * Stack index{0, 1, 2} val{2, 4, 6}
 * 
 * 
 * ELSE if arr[i] > top value at stack (6>3). then no more rectangle series can be formed.
 * so calculate areas for all rectangles accumulated in stack
 * 
 * >>pop the first entry in stack and its rectangle forming width is 1 (area of rectangle with width one = 6*1)
 * stack -> ind{0, 1} val{2, 4}
 * 
 * go to step 3 again and again check (4>3) so
 * >> pop the second entry from stack and its rectangle forming width will be 2 (area of rectangle with width two = 4*2)
 * stack -> ind{0}  val{2}
 * 
 * go to step 3 and again check (2<3) -> So this time add 3 to stack
 * stack -> ind{0, 3}  val{2,3} increment i and it points to 1
 * 
 * go to step 3 and again check (1<3) so
 * >>pop the first entry in stack and its rectangle forming width is three and not one . This is because after
 * removing 3 elemnt on stack is 2 and its index is 0. All the other rectangles which were bigger than 3 (4 & 6) 
 * have been processed and popped. 2 being smaller than 3 is present in stack and represents that width of rectangle
 *  formed with value 3 will be starting after 2.
 * 
 * go to step 3 and again check (1<2) so
 * >> pop 2 out of the stack and its rectangle forming width is 4. There is no element in stack after removing two
 * , so this indicates there is no value less than 2 till now(while 1 is being processed) so its width = i (4 at this moment)
 * 
 * go to step 3 >> stack empty so add 1 in stack
 * 
 * loop end here
 * 
 * check if stack is not empty then execute else part of step3 on all elements in stack
 */
	int maxArea(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();
		int area=0, maxArea=0;
		int i=0;
		
		while(i<arr.length) {
			
			if(st.empty() || arr[st.peek()] <= arr[i]) {
				st.push(i);
				i++;
			}else{
				int peeked = st.peek();
				int val = st.pop(); // 
				area = arr[val] * (st.empty() ? i : (i -st.peek()-1) );
				
				if(maxArea < area ) {
					maxArea = area;
				}
			}
		}
		while(!st.empty()) {
			int peeked = st.peek();
			int val = st.pop(); // 
			area = arr[val] * (st.empty() ? i : (i -st.peek()-1) );
			
			if(maxArea < area ) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyHistogramArea obj = new MyHistogramArea();
		int[] arr = {6, 2, 4, 6, 3, 1, 5};
		int res = obj.maxArea(arr);
		System.out.println(res);
	}

}
