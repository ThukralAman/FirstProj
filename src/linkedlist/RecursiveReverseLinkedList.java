package linkedlist;

public class RecursiveReverseLinkedList {

	public Node recursiveReverse(Node node) {
		
		/*
		 *  a -> b -> c -> d -> e -> null
		 *  
		 *  e -> d -> c -> b -> a -> null
		 *  
		 *  1. base case - if (head is null || head.next is null) => return head
		 *  2. considering you are recursing and now at second-last node(which is d) do:
		 *  	node = reverse(d.next) => this will return node = e
		 *  	// you don't have to process node, but just pass it back across each recursive call
		 *  	d.next.next = d
		 *  	d.next = null
		 *  	return node
		 *  
		 *  	
		 */
		
		if( node==null || node.next == null) {
			return node;
		}
		
		Node reverse_list_head = recursiveReverse(node.next);
		node.next.next = node;
		node.next = null;
		return reverse_list_head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		 
        // creating first linked list
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        
        RecursiveReverseLinkedList obj = new RecursiveReverseLinkedList();
        
        Node newHead = obj.recursiveReverse(list.head);
        LinkedList list1 = new LinkedList();
        list1.head = newHead;
        list1.printLinkedList();
 
        
        // T2: null head passed
        System.out.println("\n T2: nul head passed\n");
        
        
        LinkedList list2 = new LinkedList();
        Node newHead2 = obj.recursiveReverse(null);
        list2.head = newHead2;
        list2.printLinkedList();
        
        
        // T3: list with only one node
        System.out.println("\n T3: nul head passed\n");
        LinkedList list_test = new LinkedList();
        list_test.head = new Node(1);
        
        
        LinkedList list3 = new LinkedList();
        Node newHead3 = obj.recursiveReverse(list_test.head);
        list3.head = newHead3;
        list3.printLinkedList();
        

	}

}
