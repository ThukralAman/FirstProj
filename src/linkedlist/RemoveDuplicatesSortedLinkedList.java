package linkedlist;

public class RemoveDuplicatesSortedLinkedList {
	
	public Node removeDuplicates(Node head) {
		
		/*
		 * 1. Set head = prevNode
		 * 2. Set head.next = currNode
		 * 3. Check if preVnode and currNode have same data ? If yes point prevNode.next to currNode.next and incre,ent currNode
		 * 4. Otherwise increment both prevNode and currentNode
		 * 5. Repeat this until currNode is not null 
		 * 
		 */
		
		if(head == null) {
			return null;
		}
		
		Node prevNode = head;
		Node currNode = head.next;
		while(currNode!=null) {
			if(currNode.data == prevNode.data) {
				prevNode.next = currNode.next;
				currNode = currNode.next;
			}else{
				prevNode = prevNode.next;
				currNode = currNode.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		 
        // creating first linked list
        list.head = new Node(1);
        list.head.next = new Node(1);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(3);
        
        RemoveDuplicatesSortedLinkedList obj = new RemoveDuplicatesSortedLinkedList();
        LinkedList result = new LinkedList();
        result.head = obj.removeDuplicates(list.head);
        result.printLinkedList();
        
        //T2: null list
        System.out.println("\n T2: null list");
        LinkedList result2 = new LinkedList();
        result2.head = obj.removeDuplicates(null);
        result2.printLinkedList();
        
        //T3: single node list 
        System.out.println("\n T3: single node list  \n");
        LinkedList list_test = new LinkedList();
        list_test.head = new Node(1);
        
        LinkedList result3 = new LinkedList();
        result3.head = obj.removeDuplicates(list_test.head);
        result3.printLinkedList();
        
        
        
        
        
        

	}

}
