package linkedlist;

/*
 * /*
 * 
 * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * 
         * GOTCHA: In the above function call [obj.sortedMerge(llist1.head, llist2.head);] llist1.head and llist2.head reference value will 
         * not get changed
         * 
         * - But the internal nodes of llist1 and llist2 will get affected and be combined into a single merged list
         */

public class SortedMergeLinkedLists {

	public LinkedList sortedMerge(Node head1, Node head2) {
		LinkedList result = new LinkedList();
		
		Node dummy = new Node(-1);
		Node temp = dummy;
		
		
		
		while(head1!=null && head2!=null) {
			if(head1.data <= head2.data) {
				dummy.next = head1;
				dummy = dummy.next;
				head1 = head1.next;
				
			}else {
				dummy.next = head2;
				dummy = dummy.next;
				head2 = head2.next;
			}
			
			
		}
		
		if(head1 == null) {
			while(head2!=null) {
				dummy.next = head2;
				dummy = dummy.next;
				head2 = head2.next;
			}
		}else if(head2 == null) {
			while(head1 != null) {
				dummy.next = head1;
				dummy = dummy.next;
				head1 = head1.next;
			}
		}
			
		result.head = temp.next;
		return result;
				
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		LinkedList llist1 = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
		llist1.push(107);
        llist1.push(97);
        llist1.push(88);
        llist1.push(37);
        llist1.push(10);
        
        //llist1.printLinkedList();
        
        LinkedList llist2 = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist2.push(100);
        llist2.push(99);
        llist2.push(65);
        llist2.push(23);
        llist2.push(1);
        //llist2.printLinkedList();
        
        System.out.println("\n  T1 below\n");
        SortedMergeLinkedLists obj = new SortedMergeLinkedLists();
        LinkedList mergedll = obj.sortedMerge(llist1.head, llist2.head);
        mergedll.printLinkedList();
        
        
        /*
         * GOTCHA: In the above function call [obj.sortedMerge(llist1.head, llist2.head);] llist1.head and llist2.head reference value will 
         * not get changed
         * 
         * - But the internal nodes of llist1 and llist2 will get affected and be combined into a single merged list
         */
        
        
        /*System.out.println("--------- \n");
        llist1.printLinkedList();
        System.out.println("============== \n");
        llist2.printLinkedList();
        
        System.out.println("777777777777777          7777777777777777777 \n");*/
        
        //T2 ll1=empty ll2=not empty
        System.out.println("\n T2 below \n");
        LinkedList llist3 = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist3.push(100);
        llist3.push(99);
        llist3.push(65);
        llist3.push(23);
        llist3.push(1);
      
        
        
        LinkedList mergedll2 = obj.sortedMerge(null, llist3.head);
        mergedll2.printLinkedList();
        
        
        // T3 ll1=one_element ll2=null
        System.out.println("\n T3 below \n");
        
        LinkedList llist4 = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist4.push(100);
        llist4.push(99);
        llist4.push(65);
        llist4.push(23);
        llist4.push(1);
        
        
        LinkedList ll = new LinkedList();
		ll.head = new Node(10);
        LinkedList mergedll3 = obj.sortedMerge(ll.head, llist4.head);
        mergedll3.printLinkedList();
        
        
	}

}
