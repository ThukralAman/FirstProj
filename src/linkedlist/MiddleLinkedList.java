package linkedlist;


//https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
public class MiddleLinkedList {
	
	public Node getMiddleNodeValue(Node head) {
		if(head == null) {
			return null;
		}
		Node slow = head;
		Node fast = head.next;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		MiddleLinkedList obj = new MiddleLinkedList();
		
		LinkedList llist = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        //llist.push(14);
        System.out.println("\nPrinting before swap");
        llist.printLinkedList();
        
        
        Node middleNode = obj.getMiddleNodeValue(llist.head);
        if(middleNode != null) {
        	System.out.println("Value = " + middleNode.data);
        }
        
        
        
	}

}
