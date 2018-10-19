package stack;

/*
 * https://www.tutorialspoint.com/java/java_stack_class.htm
 * 
 * Stack is a subclass of Vector that implements a standard last-in, first-out stack.

Stack only defines the default constructor, which creates an empty stack. Stack includes all the methods defined by Vector, and adds several of its own.
 * Sr.No.	Method & Description
1	
boolean empty()

Tests if this stack is empty. Returns true if the stack is empty, and returns false if the stack contains elements.

2	
Object peek( )

Returns the element on the top of the stack, but does not remove it.

3	
Object pop( )

Returns the element on the top of the stack, removing it in the process.

4	
Object push(Object element)

Pushes the element onto the stack. Element is also returned.

5	
int search(Object element)

Searches for element in the stack. If found, its offset from the top of the stack is returned. Otherwise, .1 is returned.
 */

import java.util.Stack;

public class LearnStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> st = new Stack<Integer>();
		System.out.println("Is stack empty at beginning: " + st.empty());
		
		System.out.println("Adding val = 3");
		st.push(3);
		System.out.println("peeked val = " + st.peek());
		
		
		System.out.println("Adding val = 4");
		st.push(4);
		System.out.println("peeked val = " + st.peek());
		
		System.out.println("Adding val = 5");
		st.push(5);
		System.out.println("peeked val = " + st.peek());
		
		System.out.println("popping out from stack");
		int val = st.pop();
		System.out.println("popped val = " + val);
		
		System.out.println("Searching for val 3..");
		int offset = st.search(3);
		System.out.println("offset = " + offset);
		
		
		
		
		

	}

}
