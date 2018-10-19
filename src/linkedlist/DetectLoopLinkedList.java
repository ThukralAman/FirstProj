package linkedlist;



public class DetectLoopLinkedList {
	
	public boolean loopDetector(Node head) {
		/* 1. slowPtr and fastPtr at head
		   2. move slow by 1 and fast by 2 steps
		 * 3. if fast.next or fast.next.next = null then list has no loop
		 * 4. otherwise when fastPtr == slowPtr then there will be a loop
		 * */
		
		/*
		 * T1: Empty list => false
		 * T2: One node only(head.next == null) => false
		 * T3: on node in loop => true
		 * T4: no loop => false
		 * T5: loop => true
		 */
		
		if(head == null) {
			return false;
		}
		
		Node slowPtr = head;
		Node fastPtr = head;
		
		
		while(fastPtr.next!=null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(fastPtr==slowPtr) {
				return true;
			}
		}
		return false;
	}
	
	
	public LinkedList makeLoop(LinkedList list, int startLoopIndex, int endLoopIndex) {
		int index = 1;
		Node temp = list.head;
		Node endLoopNode = null;
		Node startLoopNode = null;
		
		if(list.head == null) {
			return list;
		}
		
		while(temp!=null) {
			if(startLoopIndex == index) {
				startLoopNode = temp;
			}
			endLoopNode = temp;
			temp = temp.next;
			index += 1;
		}
		System.out.println("EndNode = " + endLoopNode.data);
		System.out.println("startNode = " + startLoopNode.data);
		endLoopNode.next = startLoopNode;
		
		return list;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList llist = new LinkedList();
		DetectLoopLinkedList obj = new DetectLoopLinkedList();
		
		
		/*Use push() to construct below list
        14->21->11->30->10  */
		llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);
        
        // T1: Empty list => false
        System.out.println("\n case: T1" + "\n");
        System.out.println("is Loop Present: " + obj.loopDetector(null));
        
        //T2: One node only(head.next == null) => false
        System.out.println("\n case: T2" + "\n");
        LinkedList tempList = new LinkedList();
        tempList.push(10);
        System.out.println("is Loop Present: " + obj.loopDetector(tempList.head));
        
        
        // T3: one node in loop => true
        System.out.println("\n case: T3" + "\n");
        LinkedList tempList1 = new LinkedList();
        tempList1.push(10);
        tempList1.head.next = tempList1.head;
        System.out.println("is Loop Present: " + obj.loopDetector(tempList1.head));
        
        // T4: no loop
        System.out.println(" \n case: T4" + "\n");
        System.out.println("is Loop Present: " + obj.loopDetector(llist.head));
        
        // T5: loop
        System.out.println("\n case: T5" + "\n");
        LinkedList tempList2 = new LinkedList();
		
		
		/*Use push() to construct below list
        14->21->11->30->10
		 		^		|
		 		|	 <-	v*/
        tempList2.push(14);
        tempList2.push(21);
        tempList2.push(11);
        tempList2.push(30);
        tempList2.push(10);
        
        tempList2 = obj.makeLoop(tempList2, 3, 5);
        //tempList2.printLinkedList();
        System.out.println("is Loop Present: " + obj.loopDetector(tempList2.head));
        
        
        
        
        
        

	}

}
