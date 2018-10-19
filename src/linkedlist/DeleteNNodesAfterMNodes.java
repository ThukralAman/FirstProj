package linkedlist;

public class DeleteNNodesAfterMNodes {
	
	public Node deleteNAfterM(Node head, int n, int m) {
		
		/*  
		 *  Abstract:
		 *  1. curr = head. Move curr by m nodes. If curr becomes null at any stage then return head
		 *  2. Set temp = curr.next;
		 *  3) Move temp by n nodes. If temp becomes null at any stage, then set curr.next = temp and return head
		 *  4) Otherwise till now temp is not null and has traversed n nodes. 
		 *  	- So curr.next = temp.next
		 *  	- curr = curr.next;
		 *  5) Go to step1
		 * 
		
		 *  
		 */

		Node curr = head;
		
		
		while(curr !=null) {
			int N = n, M = m;
			// Move curr by M nodes
			while(curr!=null && M > 1 ) {
				curr = curr.next;
				M--;
			}
			
			if(curr == null) {
				return head;
			}
			
			Node temp = curr.next;
			
			//Move temp b M nodes
			while(temp!=null && N>1) {
				temp = temp.next;
				N--;
			}
			
			
			if(temp == null) {
				curr.next = temp;
				return head;
			}else {
				curr.next = temp.next;
			}
			curr = curr.next;
		}
		
		
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		 
        // creating first list
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next.next.next.next.next = new Node(10);
        
        
       
        DeleteNNodesAfterMNodes obj = new DeleteNNodesAfterMNodes();
        LinkedList res = new LinkedList();
        res.head = obj.deleteNAfterM(list.head, 2, 3);
        res.printLinkedList();
	}

}
