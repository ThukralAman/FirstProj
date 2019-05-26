package linkedlist;

public class ReverseAlternateKNodesLinkedList {
	
	
	public Node reverseAltenrateKNodes(Node head, int k) {
		
		if(head == null) {
			return head;
		}
		
		int n = k;
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr!=null && n>0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			n--;
		}
		
		
		head.next = curr;
		n=k;
		
		while(curr!=null && n>1) {
			curr = curr.next;	
			n--;
		}
		
		if(curr!= null) {
			curr.next = reverseAltenrateKNodes(curr.next, k);
		}

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
		ll.head.next.next.next.next.next = new Node(60);
		ll.head.next.next.next.next.next.next = new Node(70);
		ll.head.next.next.next.next.next.next.next = new Node(80);
		ReverseAlternateKNodesLinkedList obj = new ReverseAlternateKNodesLinkedList();
		
		LinkedList res = new LinkedList();
		res.head = obj.reverseAltenrateKNodes(ll.head, 3);
		res.printLinkedList();
		
		
		//T2: 2 nodes in linked list
		System.out.println("\n //T2: 2 nodes in linked list\n");
		LinkedList ll2 = new LinkedList();
		ll2.head = new Node(10);
		ll2.head.next = new Node(20);
		/*ll2.head.next.next = new Node(30);
		ll2.head.next.next.next = new Node(40);
		ll2.head.next.next.next.next = new Node(50);
		ll2.head.next.next.next.next.next = new Node(60);
		ll2.head.next.next.next.next.next.next = new Node(70);
		ll2.head.next.next.next.next.next.next.next = new Node(80);*/
		
		LinkedList res2 = new LinkedList();
		res2.head = obj.reverseAltenrateKNodes(ll2.head, 3);
		res2.printLinkedList();
		
		
		
		
		

	}

}
