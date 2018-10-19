package linkedlist;

public class TripletFromThreeLinkedListEqualToSum {

	
	public Node findTripletWithSum(Node h1, Node h2, Node h3, int total) {
		
		/*
		 * 
		 * 
		 *  1. for each element t in linked list 1
		 *  2. sum_to_achieve = sum - t
		 *  NOTE: We need to reduce the problem to find two numbers in sorted array whose sum = sum_to_achieve
		 *   - How we solve this problem is like we have one pointer in array to start and one to end
		 *   - we calculate sum = start + end
		 *   	- if sum < sum_to_achieve , then we move start index by 1
		 *   	- if sum > sum_to_achieve, then we decrease end index by one
		 *   	- if equal we have find the sum
		 *   Now in linked list we cannot move backwards in list.
		 *   So we will sort h2 to increasing order => here h2 is analogous to start pointer in array
		 *   And we will sort h3 in decreasing order => so now h3 will be analogous to end pointer in array  
		 *  3. sort h2 in increasing order && sort h3 in decreasing order
		 *  4. calculate sum = h2 + h3
		 *  5. if sum < sum_to_achieve, then make h2 = h2.next and go to step4
		 *  6. if sum > sum_to_achieve, then make h3 = h3.next and go to step4
		 *  7. if sum = sum_to_achieve, append h1, h2 and h3 to dummy list and return dummy.next
		 */
		
		Node dummy = new Node(-1);
		Node temp = dummy;
		
		MergeSortLinkedList sorter = new MergeSortLinkedList();
		Node h2_sorted = sorter.mergeSort(h2);
		Node h3_sorted = sorter.mergeSort(h3);
		h3_sorted = new ReverseLinkedList().reverse(h3_sorted);
		
		Node h2_temp = h2_sorted;
		Node h3_temp = h3_sorted;
		
		int sum_to_achieve = 0;
		
		while(h1!=null) {
			sum_to_achieve = total;
			sum_to_achieve = sum_to_achieve - h1.data;
			System.out.println("h1.data = " + h1.data + " Sum to achieve = " + sum_to_achieve);
			
			h2_temp = h2_sorted;
			h3_temp = h3_sorted;
			
			while(h2_temp!=null && h3_sorted !=null) {
				
				System.out.println(" h2_temp = " + h2_temp.data + " h3_temp = " + h3_temp.data );
				int sum = h2_temp.data + h3_temp.data;
				if(sum < sum_to_achieve) {
					h2_temp = h2_temp.next;
					continue;
				}else if(sum > sum_to_achieve) {
					h3_temp = h3_temp.next;
					continue;
				}else { // sum == sum_to_achieve
					temp.next = h1;
					temp.next.next = h2_temp;
					temp.next.next.next = h3_temp;
					temp.next.next.next.next = null;
					return dummy.next;
				}
			}
			
			h1 = h1.next;
			
			System.out.println("-----------------");
		}
		
		
		return null;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		TripletFromThreeLinkedListEqualToSum obj = new TripletFromThreeLinkedListEqualToSum();
		
		LinkedList list = new LinkedList();
		 
        // creating first list
        list.head = new Node(12);
        list.head.next = new Node(6);
        list.head.next.next = new Node(29);
        //list.head.next.next.next = new Node(4);
        //list.head.next.next.next.next = new Node(6);
        
        LinkedList list2 = new LinkedList();
		 
        // creating first list
        list2.head = new Node(23);
        list2.head.next = new Node(5);
        list2.head.next.next = new Node(8);
        //list2.head.next.next.next = new Node(4);
        //list2.head.next.next.next.next = new Node(6);
        
        LinkedList list3 = new LinkedList();
		 
        // creating first list
        list3.head = new Node(90);
        list3.head.next = new Node(20);
        list3.head.next.next = new Node(59);
        /*list3.head.next.next.next = new Node(4);
        list3.head.next.next.next.next = new Node(6);*/
        
        LinkedList res = new LinkedList();
        res.head = obj.findTripletWithSum(list.head, list2.head, list3.head, 101);
        res.printLinkedList();
        

	}

}
