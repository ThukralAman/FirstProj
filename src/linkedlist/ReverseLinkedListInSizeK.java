package linkedlist;

/*
 *  https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/ 
 */

public class ReverseLinkedListInSizeK {
	
	
	public Node reverseInSizeK(Node head, int k) {
		/*   
		 *  1. Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. 
		 *     Let the pointer to the next node be next and pointer to the previous node be prev. 
		 *  2. head->next = reverse(next, k) /* Recursively call for rest of the list and link the two sub-lists 
		 *  3. return prev /* prev becomes the new head of the list (see the diagrams of iterative method of this post) 
		 */
		
		if(head == null || head.next==null) {
			return head;
		}
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		int n = k;
		
		//1. Reverse the first sub-list of size k. While reversing keep track of the next node and previous node
		while(curr!=null && k > 0 ) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			n--;
		}
		
		head.next = reverseInSizeK(next, k);
		
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList ll = new LinkedList();
		ll.head = new Node(10);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(30);
		ll.head.next.next.next = new Node(40);
		ll.head.next.next.next.next = new Node(50);
		
		ReverseLinkedListInSizeK obj = new ReverseLinkedListInSizeK();
		LinkedList res = new LinkedList();
		res.head = obj.reverseInSizeK(ll.head, 2);
		res.printLinkedList();
		
		// T2: empty list
		System.out.println("\n  T2: empty list \n");
		LinkedList res2 = new LinkedList();
		res2.head = obj.reverseInSizeK(null, 2);
		res2.printLinkedList();
		
		// T3: single node list
		System.out.println("\n  T3: single node list \n");
		
		LinkedList ll3 = new LinkedList();
		ll3.head = new Node(10);
		
		LinkedList res3 = new LinkedList();
		res3.head = obj.reverseInSizeK(ll3.head, 2);
		res3.printLinkedList();
		
		// T4: single node list
		System.out.println("\n  T3: single node list \n");
		
		LinkedList ll4 = new LinkedList();
		ll4.head = new Node(10);
		ll4.head.next = new Node(20);
		ll4.head.next.next = new Node(30);
		ll4.head.next.next.next = new Node(40);
		ll4.head.next.next.next.next = new Node(50);
		
		LinkedList res4 = new LinkedList();
		res4.head = obj.reverseInSizeK(ll4.head, 3);
		res4.printLinkedList();		

	}

}
