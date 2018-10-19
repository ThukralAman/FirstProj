package linkedlist;

public class QuickSortLinkedList {
	
	public Node partition(Node head) {
		
		
		
		
		return null;
	}
	
	/*public Node quickSort(Node head) {
		
		*//*
		 *  1. Select pivot as the last element of list
		 *  2. pivot_partitioned_head = partition the list around pivot and return head of list partitioned around pivot
		 *  3. As the list is now partioned around pivot, 
		 *  	- sort the left half of pivot.
		 *  		+ Set the pivot_prev.next = null
		 *  		+ left_sorted = qs(head) => this will effectively sort the left half of pivot and return head of sorted list
		 *  	- Sort the right half of pivot
		 *  		+ In this case tail of linked list is already null, so no need to set null for any node
		 *  		+ right_sorted = qs(pivot.next) => this will effectively sort right half of pivot and return head of sorted list
		 *  4. Now add pivot to left_sorted and right_sorted lists (pivot is between them) 
		 *  	- left_sorted.lastElement.next = pivot
		 *  	- pivot.next = right_sorted
		 *  5. Finally return left_sorted
		 * 
		 * 
		 *//*
		
		
		// This is the terminating condition of recursive calls
		*//*if(head == null || head.next == null) {
			return head;
		}
		
		// https://github.com/shivarach/LinkedList/blob/master/src/org/geeksforgeeks/linkedlists/QuickSortOnSLL.java
		Node pivot = findTail(head);//pointing pivot
		// At this state nodes from leftHalf to pivot(tail)  <= pivot and nodes from pivot.next(tail.next) to end are > pivot
		Node leftHalf = partition(head, pivot);
		//dividing right half
		Node rightHalf = pivot.next;
		pivot.next = null;
		cutPivot(leftHalf);//cut pivot temporarily
		Node sortedLeft = quickSort(leftHalf);
		addLast(sortedLeft, pivot);//add pivot again
		pivot.next = quickSort(rightHalf);
		return sortedLeft;*//*
		
		
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		/*LinkedList list = new LinkedList();
		 
        // creating first list
        list.head = new Node(10);
        list.head.next = new Node(5);
        list.head.next.next = new Node(12);
        list.head.next.next.next = new Node(7);
        list.head.next.next.next.next = new Node(11);
        
        QuickSortLinkedList obj = new QuickSortLinkedList();
        LinkedList res = new LinkedList();
        res.head = obj.quickSort(list.head);
        res.printLinkedList();*/
	}

}
