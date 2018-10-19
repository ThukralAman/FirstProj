package linkedlist;

import java.util.ArrayList;

public class MergeKsortedLinkedList {
	
	public Node mergeLists(Node h1, Node h2) {
		if(h1==null) {
			return h2;
		}
		
		if(h2==null) {
			return h1;
		}
		
		Node dummy = new Node(-1);
		Node temp = dummy;
		while(h1!=null && h2!=null) {
			if(h1.data<=h2.data) {
				temp.next = h1;
				h1 = h1.next;
				temp = temp.next;
			}else {
				temp.next = h2;
				h2 = h2.next;
				temp = temp.next;
			}
		}
		
		if(h1==null) {
			while(h2!=null) {
				temp.next = h2;
				h2 = h2.next;
				temp = temp.next;
			}
		}else {
			while(h1!=null) {
				temp.next = h1;
				h1 = h1.next;
				temp=temp.next;
			}
		}
		
		return dummy.next;
	}
	
	
	public Node mergeKSortedLists(ArrayList<Node> listArr) {
		
		
		/*
		 *  1. listArr[] contains k linked list head nodes. Lets assume k=8. So we have 8 linked list
		 *  2. Now merge linked list by selecting one from beginning and one from end. Also store merged linked list at start index
		 *  So I will first merge arrList[0] and arrList[7] and store merged linked list result in arrList[0]
		 *  Then merge (0,7) (1,6), (2,5), (3,4) --> Exit at (4,3)
		 *  In case of odd number of lists 7 => (0,6) , (1,5) (2,4) --> exit at (3,3)
		 *  3. keep doing 
		 * 
		 */
		
		int start = 0;
		int end = listArr.size()-1;
		
		while(end!=0) {
			start=0;
			while(start<end) {
				Node mergedListHead = mergeLists(listArr.get(start), listArr.get(end));
				listArr.set(start, mergedListHead);
				start++;
				end--;
			}
		}
		
		
		return listArr.get(0);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeKsortedLinkedList obj = new MergeKsortedLinkedList();
		
		LinkedList list = new LinkedList();
        // creating first list
        list.head = new Node(1);
        list.head.next = new Node(3);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(7);
        
        
        LinkedList list2 = new LinkedList();
        // creating first list
        list2.head = new Node(2);
        list2.head.next = new Node(4);
        list2.head.next.next = new Node(6);
        list2.head.next.next.next = new Node(8);
        
        LinkedList list3 = new LinkedList();
        // creating first list
        list3.head = new Node(0);
        list3.head.next = new Node(9);
        list3.head.next.next = new Node(10);
        list3.head.next.next.next = new Node(11);
        
        
        ArrayList<Node> arr = new ArrayList<Node>();
        arr.add(list.head);
        arr.add(list2.head);
        arr.add(list3.head);
        
        LinkedList res = new LinkedList();
        res.head = obj.mergeKSortedLists(arr);
        res.printLinkedList();
        
	}

}
