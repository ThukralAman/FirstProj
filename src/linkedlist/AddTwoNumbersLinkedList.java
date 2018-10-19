package linkedlist;

/*
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 */

public class AddTwoNumbersLinkedList {
	
	
	
	public Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public Node addNumbers(Node head1, Node head2) {
		/*
		 * 
		 *    7426					75946
		 *  +   85					   84
		 *  = 7511					76030
		 *  
		 *  1. Reverse the two lists => h1 = 6427 , h2= 58
		 *  2. Now compute the sum by adding head nodes h1 + h2 and passing on the carry till either h1 or h2 becomes null
		 *  3. if h1==null && h2 is not null? then compute the sum using h2 and carry
		 *  4. otherwise if h2==null && h1 is not null , then compute remaining h1 using carry
		 *  5. Finally after both h2==null and h1==null check if carry is not 0, then add an additional node in result for carry
		 *  
		 *  NOTE : this can also be done recursively
		 *  Complexity O(n) for reverse + O(n) for adding + O(n) for reversing again. Overall complexity = O(n)
		 */
		
		Node h1_rev = reverse(head1);
		Node h2_rev = reverse(head2);
		
		int carry = 0;
		int sum = 0;
		Node result = new Node(-1);
		Node temp = result;
		
		while(h1_rev != null && h2_rev !=null) {
			temp.next = new Node(-1);
			temp = temp.next;
			sum = (h1_rev.data + h2_rev.data + carry) %10;
			temp.data = sum;
			carry = (h1_rev.data + h2_rev.data+ carry) /10;
			h1_rev = h1_rev.next;
			h2_rev = h2_rev.next;
		}
		
		System.out.println();
		
		if(h1_rev==null) {
			while(h2_rev!=null) {
				temp.next = new Node(-1);
				temp = temp.next;
				temp.data = (h2_rev.data + carry)%10;
				carry = (h2_rev.data + carry)/10;
				h2_rev = h2_rev.next;
			}
		}else if(h2_rev == null) {
			while(h1_rev != null) {
				temp.next = new Node(-1);
				temp = temp.next;
				temp.data = (h1_rev.data + carry)%10;
				carry = (h1_rev.data + carry)/10;
				h1_rev = h1_rev.next;
			}
		}
		
		// finally when we are assured that all odes of h1_rev and h2_rev have been processed, we finally need to check if any
		// leftover carry is remaining   
		/*
		 *  case:      h1_rev = 95
		 *      	   h2_rev =  9
		 * 
		 * 
		 * 
		 *      case:      h1_rev = 59
		 *      		   h2_rev = 9
		 *      till now result   = 40   and carry=1
		 *      
		 *      so now we check if there is any carry then add it
		 * 
		 */
		
		
		if(carry!=0) {
			temp.next = new Node(-1);
			temp = temp.next;
			temp.data = carry;
		} 
		
		
		return reverse(result.next);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		 
        // creating first list
        list.head = new Node(7);
        list.head.next = new Node(5);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(6);
        
        
        // creating seconnd list
        LinkedList list2 = new LinkedList();
        list2.head = new Node(8);
        list2.head.next = new Node(4);
        
        
        
        AddTwoNumbersLinkedList obj = new AddTwoNumbersLinkedList();
        LinkedList res = new LinkedList();
        res.head = obj.addNumbers(list.head, list2.head);
        res.printLinkedList();
        
 

	}

}
