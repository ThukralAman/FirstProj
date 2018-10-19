package linkedlist;

public class MergeSortLinkedList {
	
	public Node getMiddleOfList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		
		while(fast.next!=null && fast.next.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public Node merge(Node h1, Node h2) {
		Node dummy = new Node(-1);
		Node temp = dummy;
		
		while(h1!=null && h2!=null) {
			if(h1.data <= h2.data) {
				temp.next = h1;
				temp = temp.next;
				h1 = h1.next;
			}else {
				temp.next = h2;
				temp = temp.next;
				h2 = h2.next;
			}
			
		}
			
		if(h1 == null) {
			while(h2!=null) {
				temp.next = h2;
				temp = temp.next;
				h2 = h2.next;
			}
		}else if(h2 == null) {
			while(h1 != null) {
				temp.next = h1;
				temp = temp.next;
				h1 = h1.next;
			}
			
		}
		return dummy.next;
			
		
	}
	
	public Node mergeSort(Node head) {
		
		
		/*
		 * 
		 * 1. Terminating condition is when linked list has single node, then return that node
		 * 2. otherwise, find middle = middleOfLinkedList
		 * 3. mergeSort first half i.e from head-middleOfLinkedList [ mergeSort(head) ] => to do this set middle.next = null
		 * 4. mergeSortSecondhalf, i.e from nextOfMiddle-last node [mergeSort(nextOfMiddle) => tail already points to null so
		 * 	  we don't need to set anything to null here 
		 * 5. Now merge the sorted lists obtained from stp 3 and 4 and return the merged list
		 */
		
		if(head == null || head.next == null ) {
			return head;
		}
		
		Node middle = getMiddleOfList(head);
		Node nextOfMiddle = middle.next;
		
		middle.next = null;
		
		Node h1 = mergeSort(head);
		Node h2 = mergeSort(nextOfMiddle);
		
		Node sortedListHead = merge(h1, h2);
		return sortedListHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList ll = new LinkedList();
		ll.head = new Node(10);
		ll.head.next = new Node(14);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(16);
		ll.head.next.next.next.next = new Node(8);
		ll.head.next.next.next.next.next = new Node(11);
		ll.head.next.next.next.next.next.next = new Node(15);
		ll.head.next.next.next.next.next.next.next = new Node(70);
		
		MergeSortLinkedList obj = new MergeSortLinkedList();
		LinkedList res = new LinkedList();
		res.head = obj.mergeSort(ll.head);
		res.printLinkedList();
		

	}

}
