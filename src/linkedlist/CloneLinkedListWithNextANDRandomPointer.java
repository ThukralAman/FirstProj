package linkedlist;


/*
 * https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
 */


public class CloneLinkedListWithNextANDRandomPointer {
	
	class Node
	{
	    int data;//Node data
	    Node next, random;//Next and random reference
	 
	    //Node constructor
	    public Node(int data)
	    {
	        this.data = data;
	        this.next = this.random = null;
	    }
	}
	
	class LinkedList
	{
	    Node head;//Linked list head reference
	 
	    // Linked list constructor
	    public LinkedList(Node head)
	    {
	        this.head = head;
	    }
	    
	    public LinkedList() {
	    	
	    }
	 
	    // push method to put data always at the head
	    // in the linked list.
	    public void push(int data)
	    {
	        Node node = new Node(data);
	        node.next = this.head;
	        this.head = node;
	    }
	 
	    // Method to print the list.
	    void print()
	    {
	        Node temp = head;
	        while (temp != null)
	        {
	            Node random = temp.random;
	            int randomData = (random != null)? random.data: -1;
	            System.out.println("Data = " + temp.data +
	                               ", Random data = "+ randomData);
	            temp = temp.next;
	        }
	    }
	}
	
	public void cloneList(CloneLinkedListWithNextANDRandomPointer.Node head) {
		/*
		 * 
		 * 1. Iterate over existing list and create a hashmap. 
		 * 		- key of hashmap is current node. Value corresponding to key will be a new Node(curr.data)
		 * 		 so now map becomes (1, 1), (2, 2) ... so on
		 * 2. Again iterate over original list and update NEXT and RANDOM pointer of new cloned nodes stored as values
		 * 		- clonedNode = map.get(curr);
		 * 		- clonedNode.next = map.get(curr.next);
		 * 		- clonedNode.random = map.get(curr.random)
		 * 		- curr = curr.next;
		 * 
		 * 
		 */
	}
	
	
	public static void main(String[] args) {
		CloneLinkedListWithNextANDRandomPointer obj = new CloneLinkedListWithNextANDRandomPointer();
		
		 // Pushing data in the linked list.
		CloneLinkedListWithNextANDRandomPointer.LinkedList list = obj.new LinkedList();
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
 
        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
            list.head.next.next.next;
        list.head.next.next.random =
            list.head.next.next.next.next;
        list.head.next.next.next.random =
            list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
            list.head.next;
        
        obj.cloneList(list.head);
        
        
	}
	
}
