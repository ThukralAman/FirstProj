package linkedlist;



public class InsertionSortLinkedList {
	
	public Node insertionSort(Node head) {
		
		/*
		 * 1, 3, 9, 11, 8, 2, 14, 5
		 * 
		 * curr is currently at Node(8)
		 * 
		 *  1. begin a for loop from index1 to end
		 *  2. for each(currNode): 
		 *  	- iterate with temp from first node till currNode
		 *  	- check if temp.next > curr.data ? If yes then break
		 *  3. Move Node(8) at position after Node(3) which is stored in temp after loop breaks
		 *  
		 *  Time complexity O(n^2)
		 * 
		 * 
		 */
		
		return null;
	}
	
	

	public static void main(String[] args) {
		InsertionSortLinkedList obj = new InsertionSortLinkedList();
		
		LinkedList ll = new LinkedList();
		ll.head = new Node(10);
		ll.head.next = new Node(14);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(16);
		ll.head.next.next.next.next = new Node(8);
		ll.head.next.next.next.next.next = new Node(11);
		ll.head.next.next.next.next.next.next = new Node(15);
		ll.head.next.next.next.next.next.next.next = new Node(70);
		
		
		LinkedList res = new LinkedList();
		res.head = obj.insertionSort(ll.head);
		res.printLinkedList();
	}

}
