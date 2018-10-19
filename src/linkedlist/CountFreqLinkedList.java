package linkedlist;


//https://www.geeksforgeeks.org/write-a-function-that-counts-the-number-of-times-a-given-int-occurs-in-a-linked-list/
public class CountFreqLinkedList {
	
	public int countFrequency(Node head, int data) {
		if(head == null) {
			return 0;
		}else if(head.data == data) {
			return 1 + countFrequency(head.next, data);
		}else {
			return countFrequency(head.next, data);
		}
		
	}

	public static void main(String[] args) {
	
		CountFreqLinkedList obj = new CountFreqLinkedList();
		
		
		LinkedList llist = new LinkedList();
		
		/*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(14);
        llist.push(14);
        
        llist.printLinkedList();
        
        System.out.println("\n Freq = " + obj.countFrequency(llist.head, 14));
        System.out.println("\n Freq = " + obj.countFrequency(llist.head, 0));

	}

}
