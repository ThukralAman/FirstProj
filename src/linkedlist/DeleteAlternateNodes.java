package linkedlist;

public class DeleteAlternateNodes {
	
	public Node deleteAlternateNodes(Node head) {
		
		Node temp = head;
		
		while(temp.next!=null) {
			Node temp1 = temp.next;
			temp.next = temp.next.next;
			temp1 = null;
			temp = temp.next;
		}
		return head;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList();
		ll.head = new Node(10);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(30);
		ll.head.next.next.next = new Node(40);
		ll.head.next.next.next.next = new Node(50);
		
		DeleteAlternateNodes obj = new DeleteAlternateNodes();
		LinkedList res = new LinkedList();
		res.head = obj.deleteAlternateNodes(ll.head);
		res.printLinkedList();
		
	}

}
