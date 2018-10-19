package linkedlist;


// https://www.geeksforgeeks.org/reverse-a-linked-list/

// Recursive reverse explaination: mycodeschool: https://www.youtube.com/watch?v=KYH83T4q6Vs
public class ReverseLinkedList {
	
	public Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node prev = null,
			 curr = head,
			 next = null;
		
		while(curr != null) {
			next = curr.next;
			
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public Node reverseRecursively(Node node) {
		if(node.next == null) {
			return node;
		}
		Node reversedListHead = reverseRecursively(node.next);
		node.next.next = node;
		node.next = null;
		return reversedListHead;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();
		
		LinkedList llist = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);
        llist.printLinkedList();
        
        //llist.head = obj.reverse(llist.head);
        llist.head = obj.reverseRecursively(llist.head);
        System.out.println("\n");
        
        llist.printLinkedList();
        
        	
	}
}
