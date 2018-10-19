package linkedlist;



/*
 *    https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 */






public class LinkedListSwapNodes {
	
	
	public Node swapNodes(Node head, int x, int y) {
		if(x==y) {
			return null;
		}
		
		// find X, Y and prevX and prevY
		Node prevX = null, 
			 currX = head;
		while(currX != null && currX.data != x ) {
			prevX = currX;
			currX = currX.next;
		}
		
		Node prevY = null,
			 currY = head;
		while(currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}
		
		if(currX == null || currY == null) {
			return null;
		}
		
		// Swap next pointers of prev nodes
		if(prevX == null) {   
			head  = currY;
		} else {
			prevX.next = currY;
		}
		
		
		if(prevY == null) {    // Dont usee currY == head to check if Y is the head node, because if X is head then in previous check Y would become head
			head = currX;
		} else {
			prevY.next = currX;
		}
		
		
		// Swap next pointers of X and Y nodes
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;	
		
		return head;
	}
	
	public boolean searchRecursive(Node head, int data) {
		if(head == null) {
			return false;
		} else if(head.data == data) {
			return true;
		}else {
			return searchRecursive(head.next, data);
		}
		
		/*Node curr = head;
		while(curr!=null) {
			if(curr.data == data) {
				return true;
			}
			curr = curr.next;
		}
		
		return false;*/
	}
	
	
	public static void main(String args[])
    {
 
		LinkedListSwapNodes obj = new LinkedListSwapNodes();
        //Start with the empty list
        LinkedList llist = new LinkedList();
 
        /*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);
        System.out.println("\nPrinting before swap");
        llist.printLinkedList();
        
        //Node result = obj.swapNodes(llist.head, 30, 21);
        //Node result = obj.swapNodes(llist.head, 14, 30);
        Node result = obj.swapNodes(llist.head, 14, 10);
        if( result!= null) {
        	llist.head = result;
        }
        
        System.out.println("\nPrinting after swap");
        llist.printLinkedList();
 
        
    }


}
