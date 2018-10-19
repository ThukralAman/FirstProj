package linkedlist;

public class splitOddEvenNodesLinkedList {
	
	public Node connectOddEvenNodes(Node head) {
		
		
		/**
		 *  1. Set odd = head
		 *  2. Set even = head.next
		 *  IMP NOTE: you cannot just process for odd list first. like go on connecting odd nodes in original list and then process for
		 *  	  even nodes. This is bcoz once you have processed for odd nodes, pointers to even nodes will be lost. So you need to connect
		 *        first odd node to its next odd node. And then connect first even node to its next even and loop for this for next nodes
		 *  
		 *  NOTE2: Next 3 lines are little dicy to understand, if not understand then skip
		 *  if list.size == EVEN say 4, then loop will terminate when even.next will be null
		 *  if list.size == ODD say 3, then loop will terminate eventually even will be null
		 *  So loop for the following steps if(even!=null && even.next!=null)  
		 *  3. Connect current odd node to its next occuring odd node which will be even.next. odd.next = even.next
		 *  4. update odd pointer to point to latestly added odd node. odd = odd.next
		 *  5. Connect current even node to its next even node which is even.next.next.
		 *  6. update even pointer to its latestly added even node
		 *  7. Go to step 3
		 */
		
		if(head==null || head.next == null) {
			return head;
		}
		
		Node odd = head;
		Node even = head.next;
		Node even_start = even;
		
		while(even!=null && even.next!=null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		
		odd.next = even_start;
		return head;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		splitOddEvenNodesLinkedList obj = new splitOddEvenNodesLinkedList();
		
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
		res.head = obj.connectOddEvenNodes(ll.head);
		res.printLinkedList();
		
		// T2: empty or single node list
		System.out.println(" \n T2, T3: empty or single node list\n");
		LinkedList ll2 = new LinkedList();
		ll2.head = null;
		LinkedList res2 = new LinkedList();
		res2.head = obj.connectOddEvenNodes(ll2.head);
		res2.printLinkedList();

		System.out.println("T3 \n");
		
		LinkedList ll3 = new LinkedList();
		ll3.head = new Node(10);
		LinkedList res3 = new LinkedList();
		res3.head = obj.connectOddEvenNodes(ll3.head);
		res3.printLinkedList();
		
		System.out.println("T4 \n");
		
		LinkedList ll4 = new LinkedList();
		ll4.head = new Node(10);
		ll4.head.next = new Node(20);
		
		LinkedList res4 = new LinkedList();
		res4.head = obj.connectOddEvenNodes(ll4.head);
		res4.printLinkedList();
		
		// odd numbered list
		System.out.println("\n T5 : odd numbered list \n");
		LinkedList ll5 = new LinkedList();
		ll5.head = new Node(10);
		ll5.head.next = new Node(20);
		ll5.head.next.next = new Node(30);
		
		
		LinkedList res5 = new LinkedList();
		res5.head = obj.connectOddEvenNodes(ll5.head);
		res5.printLinkedList();
		
		
		
		
		
		
	}

}
