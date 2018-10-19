package linkedlist;

import java.util.Stack;

/*
 * 
 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */

//GOTCH: fastPtr.next will be null if list size is odd 
		// And fastPtr.next.next = null if list size is even

public class PalindromeCheckLinkedList {
	
	public boolean checkPalindrome(Node head) {
		/*
		 *  1. traverse each of element till middle of linked list
		 *  2. While traversing till middle add each of the element in stack
		 *  3. Now traverse the second half of the linked list
		 *  4. While traversing the second half, then for each element match the popped content of stack with current element
		 *  5. If equal move forward else return false
		 */
		if(head == null) {
			return true;
		}
		if(head.next==null) {
			return false;
		}
		
		Node slowPtr = head;
		Node fastPtr = head;
		Stack<Integer> st = new Stack<Integer>();
		st.push(slowPtr.data);
		
		while(fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			st.push(slowPtr.data);
		}
		
		// NOTE: fastPtr.next will be null if list size is odd 
		// And fastPtr.next.next = null if list size is even
		//if(fastPtr.next == null) {
			
		//}
		
		slowPtr = slowPtr.next;
		
		
		
		
		while(slowPtr!=null) {
			
			if(st.pop() != slowPtr.data) {
				return false;
			}
			slowPtr = slowPtr.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList ll = new LinkedList();
		ll.head = new Node(10);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(30);
		ll.head.next.next.next = new Node(40);
		ll.head.next.next.next.next = new Node(50);
		ll.printLinkedList();
		
		
		PalindromeCheckLinkedList obj = new PalindromeCheckLinkedList();
		
		
		/*// T1: Happy Path
		System.out.println("\n T1 : ");
		System.out.println(obj.checkPalindrome(ll.head));
		
		// T2: Happy Path2 --- odd number
		ll.head = new Node(10);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(30);
		ll.head.next.next.next = new Node(20);
		ll.head.next.next.next.next = new Node(10);
		System.out.println("\n T2 : odd number");
		System.out.println(obj.checkPalindrome(ll.head));*/
		
		
		//T3: --- even number
		ll.head = new Node(10);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(20);
		ll.head.next.next.next = new Node(10);
		
		System.out.println("\n\n");
		ll.printLinkedList();
		
		System.out.println("\n T3 :even number ");
		System.out.println(obj.checkPalindrome(ll.head));
		
		
		
		//T4: empty list
		System.out.println("\n T4 :empty list ");
		System.out.println(obj.checkPalindrome(null));
		
		
		//T5: one element in list
		ll.head = new Node(10);
		ll.head.next = null;
		
		System.out.println("\n T5 :one element in list ");
		System.out.println(obj.checkPalindrome(ll.head));

	}

}
