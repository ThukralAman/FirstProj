package linkedlist;

/*
 *  https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 * 
 */

public class DetectAndRemoveLoopLinkedList {

	public Node loopDetector(Node head) {
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
			return null;
		}
		
		Node slowPtr = head;
		Node fastPtr = head;
		
		
		while(fastPtr.next!=null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(fastPtr==slowPtr) {
				return slowPtr;
			}
		}
		return null;
	}
	
	Node loopStartNode(Node head) {
		// It returns the node previous to node whre loop starts. This is done to allow the loop to be removed
		// if required.
		Node slowFastMeetingNode = loopDetector(head);
		Node slowPtr = head;
		Node prevNodeToLoopStartNode = null;
		Node fastPtr = slowFastMeetingNode;
		while(slowPtr!=fastPtr) {
			slowPtr = slowPtr.next;
			prevNodeToLoopStartNode = fastPtr;
			fastPtr = fastPtr.next;
		}
		return prevNodeToLoopStartNode;
		//return slowPtr;
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
	
		DetectAndRemoveLoopLinkedList obj = new DetectAndRemoveLoopLinkedList();
		
		
		
        // T5: loop
        System.out.println("\n case: T5: loop" + "\n");
        LinkedList tempList2 = new LinkedList();
		
		
		/*Use push() to construct below list
        10->30->11->21->14
		 		^		|									slow,fast => 	10, 10 | 30, 11 | 11, 14 | 21, 21
		 		|	 <-	v*/
        tempList2.push(14);
        tempList2.push(21);
        tempList2.push(11);
        tempList2.push(30);
        tempList2.push(10);
        
        tempList2 = obj.makeLoop(tempList2, 3, 5);
        Node res = obj.loopDetector(tempList2.head);
        Node res2 = obj.loopStartNode(tempList2.head);
        res2.next = null;
        tempList2.printLinkedList();
        System.out.println("Node in loop  " + res2.data);

	}

}
