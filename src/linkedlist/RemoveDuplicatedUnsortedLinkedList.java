package linkedlist;

import java.util.HashSet;

public class RemoveDuplicatedUnsortedLinkedList {
	
	public Node removeDuplicatesUnsortedList(Node head) {
		/*
		 * 
		 * Three approaches
		 *  1. Use two loops n^2 time
		 *  2. Sort linked list and then remove duplicates -> nlogn time
		 *  3. Use hashing -> n time n space
		 */
		
		/*
		 *  Hashing
		 *  1. prevNode = head
		 *  2. currNode = head.next;
		 *  3. add prev to hash table hashmap.put(prevNode)
		 *  4. if(currNode) is in hashmap, then bypass currNode and link prevNode.next = currNode.next;
		 *  5. else add currNode in hashmap and move forward
		 */
		
		if(head == null || head.next == null) {
			return head;
		}
		
		HashSet<Integer> hs = new HashSet();
		Node prevNode = head;
		Node currNode = head.next;
		hs.add(prevNode.data);
		
		while(currNode!=null) {
			if(hs.contains(currNode.data)) {
				prevNode.next = currNode.next;
				currNode = currNode.next;
			}else {
				hs.add(currNode.data);
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
        list.head = new Node(32);
        list.head.next = new Node(16);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(32);
        list.head.next.next.next.next = new Node(3);
        
        RemoveDuplicatedUnsortedLinkedList obj = new RemoveDuplicatedUnsortedLinkedList();
        LinkedList result = new LinkedList();
        result.head = obj.removeDuplicatesUnsortedList(list.head);
        result.printLinkedList();
        
      //T2: null list
        System.out.println("\n T2: null list");
        LinkedList result2 = new LinkedList();
        result2.head = obj.removeDuplicatesUnsortedList(null);
        result2.printLinkedList();
        
        //T3: single node list 
        System.out.println("\n T3: single node list  \n");
        LinkedList list_test = new LinkedList();
        list_test.head = new Node(1);
        
        LinkedList result3 = new LinkedList();
        result3.head = obj.removeDuplicatesUnsortedList(list_test.head);
        result3.printLinkedList();
        
        //T4: all elements are repeating
        System.out.println("\n  T4: all elements are repeating\n");
        LinkedList list_t4 = new LinkedList();
		 
        // creating first linked list
        list_t4.head = new Node(32);
        list_t4.head.next = new Node(32);
        list_t4.head.next.next = new Node(32);
        list_t4.head.next.next.next = new Node(32);
        list_t4.head.next.next.next.next = new Node(32);
        
        
        LinkedList result4 = new LinkedList();
        result4.head = obj.removeDuplicatesUnsortedList(list_t4.head);
        result4.printLinkedList();
        

	}

}
