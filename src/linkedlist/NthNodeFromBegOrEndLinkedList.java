package linkedlist;

/* https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
 * 
 * Given head and integer x, return index of number x in linked list.
*/
public class NthNodeFromBegOrEndLinkedList {
	
	public int nthIndexFromBeg(Node head, int x) {
		Node curr = head;
		int index = 0;
		while(curr!=null ) {
			if(curr.data == x) {
				return index;
			}
			index++;
			curr = curr.next;
		}
		return -1;
	}
	
	
	// n=1 will give 1st node from end
	public int nthFromEnd(Node head, int n) {  
		Node curr = head;
		Node prev = head;
		int temp = n;
		
		while( curr!=null && n > 0 ) {  //( for n=1 loop 1 times), (for n=2 loop 2 times), ..
			curr = curr.next;
			n--;
		}
		
		while(curr != null) {
			curr = curr.next;
			prev = prev.next;
		}
		
		return prev.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList llist = new LinkedList();
		NthNodeFromBegOrEndLinkedList obj = new NthNodeFromBegOrEndLinkedList(); 
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);
        System.out.println("\nPrinting before swap");
        llist.printLinkedList();
        
		System.out.println("Value = " + obj.nthFromEnd(llist.head, 1));
		System.out.println("Value = " + obj.nthFromEnd(llist.head, 6));
	}
}
