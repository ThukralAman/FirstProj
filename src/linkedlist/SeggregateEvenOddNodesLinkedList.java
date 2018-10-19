package linkedlist;

public class SeggregateEvenOddNodesLinkedList {
	
	/*
	 *  1. Check if first node is the odd node
	 *  	- If Yes, then add it to dummy node list and iterate over next nodes untill an even node is found
	 *  	However in the process of iterating if the list exhausts, then it means that there were no even nodes.
	 *  	So, in that case, return dummy.next
	 *  2. If there was any odd node in the beggining, then we have processed that, so now curr is 
	 *  	- Either at head and head is an even node
	 *  	- Or curr is at first even node in the list(which is reached by iterating over odd nodes in the beggining)
	 *  3. Now we have found the head of the result list. So set head = curr
	 *  4. Now use prev and curr to iterate over remaining list
	 *  5. While iterating if odd node is encountered, then link the dummy list to that odd node and keep iterating untill list exhausts.
	 */
	
	public Node segregateEvenOddNodes(Node head) {
		Node dummy = new Node(-1);
		Node temp = dummy;
		
		Node curr = head;
		Node prev = null;
		
		// if head node is not even, then iterate the list till odd nodes are found and add to dummy list
		if(head.data %2 !=0) {
			while(curr!=null && curr.data %2 != 0) {
				temp.next = curr;
				temp = temp.next;
				curr = curr.next; 
				//temp.next = null;
			}
			
			
			
			// if all nodes are odd only, then curr would become null otherwise if the first node is even then curr will not be null
			if(curr == null) {
				return dummy.next;
			}
		}
		
		
	
		
		/*Since current !=null then it means atleast one even node exists
		 *  1) Set the head = curr => the first even node encountered
		 *  2) Now iterate the list using prev and curr to move any more odd nodes to dummy list
		 */
		
		head = curr;
		// assign the even node  to prev pointer and start iterating from the next node onwards
		prev = curr;
		curr = curr.next;
		
		while(curr != null) {
			if(curr.data %2 != 0) {  
				/*
				 *  // if current data is odd ?
				 *  1. make prev.next to point to next node of curr
				 *  2. add curr node to next of temp
				 *  3. move temp to end of list
				 *  4. make end of dummy list to point to null
				 *  5. update current to point to next
				 */
				prev.next = curr.next;
				temp.next = curr;
				temp = temp.next;
				//temp.next = null;
				curr = curr.next;
			}else { // if current node data is even advance 
				prev = curr;
				curr = curr.next;
			}
			
			System.out.println("prev = " + prev.data );//+ " curr = " + curr.data);
			
			LinkedList t1 = new LinkedList();
			t1.head = head;
			System.out.println("\n");
			t1.printLinkedList();
			System.out.println("\n");
		}
		
		// At the end when curr == null then prev is at last node of original list. this original list now contains only even numbers
		// so set the prev.next = starting point of odd nodes list
		temp.next = null;
		prev.next = dummy.next;
		
			
			
			
		
		
		
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.head = new Node(9);
		ll.head.next = new Node(99);
		/*ll.head.next.next = new Node(30);
		ll.head.next.next.next = new Node(87);
		ll.head.next.next.next.next = new Node(50);
		ll.head.next.next.next.next.next = new Node(89);
		ll.head.next.next.next.next.next.next = new Node(70);
		ll.head.next.next.next.next.next.next.next = new Node(80);*/
		
		SeggregateEvenOddNodesLinkedList obj = new SeggregateEvenOddNodesLinkedList();
		LinkedList res = new LinkedList();
		res.head = obj.segregateEvenOddNodes(ll.head);
		res.printLinkedList();

	}

}
