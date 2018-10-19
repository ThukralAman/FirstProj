package linkedlist;


/*
 * 
 *   https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 */
public class IntersectionOfTwoLinkedList {
	
	public Node getIntersection(Node head1, Node head2) {
		// recursive approach
		/*
		   
		 */
		
		if(head1 == null || head2 == null) {
			return null;
		}
		
		
		Node temp = new Node();
		
		if(head1.data == head2.data) {
			temp.data = head1.data;
			temp.next = getIntersection(head1.next, head2.next);
		}else if(head1.data < head2.data) {
			temp  = getIntersection(head1.next, head2);
		}else {
			temp = getIntersection(head1, head2.next);
		}
		return temp;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		LinkedList ll = new LinkedList();
		ll.head = new Node(10);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(30);
		ll.head.next.next.next = new Node(40);
		ll.head.next.next.next.next = new Node(50);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new Node(7);
		ll2.head.next = new Node(20);
		ll2.head.next.next = new Node(25);
		ll2.head.next.next.next = new Node(40);
		ll2.head.next.next.next.next = new Node(50);
		
		IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();
		LinkedList res = new LinkedList();
		res.head = obj.getIntersection(ll.head, ll2.head);
		res.printLinkedList();
		
	}

}
