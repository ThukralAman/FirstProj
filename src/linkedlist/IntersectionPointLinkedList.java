package linkedlist;

/*
 *   https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 */


public class IntersectionPointLinkedList {
	
	public int findLengthLinkedList(Node head) {
		if(head == null) {
			return 0;
		}
		int count = 0;
		while(head!=null) {
			head = head.next;
			count++;
		}
		return count;
	}
	
	public Node moveLinkedListByNNodes(Node head, int n) {
		while(n>0) {
			head = head.next;
			n--;
		}
		return head;
	}
	
	public Node findIntersection(Node head1, Node head2) {
		/* Terminology ll  -> LinkedList
		 * 
		 *  1. Find l1 = length of ll1
		 *  2. Find l2 = length of ll2
		 *  3. Subtract smaller from bigger say diff = l2-l1
		 *  4. traverse the diff number of nodes in longer ll which is ll2
		 *  5. Now traverse one node each in each of the ll iteratively till both nodes are same. This is the intersection point
		 */
		
		int l1 = findLengthLinkedList(head1);
		int l2 = findLengthLinkedList(head2);
		int diff = 0;
		if(l2 > l1) {
			diff = l2-l1;
			head2 = moveLinkedListByNNodes(head2, diff);
		}else {
			diff = l1-l2;
			head1 = moveLinkedListByNNodes(head1, diff);
		}
		
		while(head1!=null && head2!=null && head1!=head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if(head1 !=null && head2!=null && head1 == head2) {
			return head1;
		}
		return new Node(-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LinkedList list = new LinkedList();
		 
        // creating first linked list
        list.head = new Node(3);
        list.head.next = new Node(6);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(30);
 
        
        LinkedList list2 = new LinkedList();
        // creating second linked list
        list2.head = new Node(10);
        list2.head.next = list.head.next.next.next;
        list2.head.next.next = list.head.next.next.next.next;
        
        
        
        // TC1: Happy path of two nodes intersecting
        System.out.println("\n // TC1: Happy path of two nodes intersecting  \n");
        IntersectionPointLinkedList obj = new IntersectionPointLinkedList();
        Node result = obj.findIntersection(list.head, list2.head);
        System.out.println("Intersecting node is " + result.data);

        
        // TC2: Two parllel linked lists
        System.out.println("\nT2: parallel ll \n");
        LinkedList list3 = new LinkedList();
        // creating second linked list
        list3.head = new Node(10);
        list3.head.next = new Node(20);
        list3.head.next.next = new Node(30);
        
        Node result2 = obj.findIntersection(list.head, list3.head);
        System.out.println("Intersecting node is " + result2.data);
        
        
        // TC3: one of the linked list head is null
        System.out.println("\n TC3: one of the linked list head is null \n");
        Node result3 = obj.findIntersection(null, list3.head);
        System.out.println("Intersecting node is " + result3.data);
        
        // TC4: Both linked list are null
        System.out.println("\n  TC4: Both linked list are null \n");
        Node result4 = obj.findIntersection(null, null);
        System.out.println("Intersecting node is " + result4.data);
        
        
        
	}

}
