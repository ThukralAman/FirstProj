package linkedlist;

class Result {
	int carry;
	Node result_sum;
	
	Result() {
		this.carry = 0;
		this.result_sum = null;
	}
	
	Result(int carry, Node sum) {
		this.carry = carry;
		this.result_sum = sum;
	}
}

public class AddTwoNumbersLinkedListRecursively {
	
	public int len(Node head) {
		if(head == null) {
			return 0;
		}
		
		int count = 0;
		while(head!=null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public Node appendZeroes(Node head, int n) {
		if(head == null || n==0) {
			return head; 
		}
		
		while(n > 0) {
			Node newNode = new Node(0);
			newNode.next = head;
			head = newNode;
			n--;
		}
		return head;
	}
	
	public Result AddListsHelper(Node h1, Node h2) {
		
		if(h1==null && h2== null) {
			return new Result();
		}
		
		
		Node newNode = new Node(-1);
		Result result = new Result(0, newNode);
		
		
		Result remaining_list_res = AddListsHelper(h1.next, h2.next);
		result.result_sum.next = remaining_list_res.result_sum;
		result.result_sum.data = (h1.data + h2.data + remaining_list_res.carry) %10;
		result.carry = (h1.data + h2.data + remaining_list_res.carry) /10;
		
		return result;
	}
	
	public Node addTwoListsRecursively(Node h1, Node h2) {
		/*
		 * 
		 *  1. find length of linked lists l1 = len(h1), l2 = len(h2)
		 *  2. diff = Abs(l1-l2);
		 *  3. if l1 > l2, move h1 by diff number of nodes. Otherwise move h2 by diff num of nodes
		 *  >> Now h1 and h2 are at positions such that both lists are of equal size
		 *  4. call add_recursive(h1, h2) that returns carry and fill the result_sum list
		 *  5. if (l1!=l2) && l1> l2, then use the carry and process diff number of nodes of h1 
		 *   Otherwise if l2> l1, then  use the carry and process diff number of nodes of h2
		 *   By process I mean to use carry and h1 (or h2) node too calculate sum
		 *  6. Finally return the result_sum
		 */
		
		
		
		/*
		 *  1. find length of linked lists l1 = len(h1), l2 = len(h2)
		 *  2. diff = Abs(l1-l2);
		 *  3. if diff > 0 && l1 > l2, move pad h2 with diff number of zeroes, otherwise
		 *  	pad h1 with additional zeroes
		 *  4. recurse down to end of both lists
		 *  		- calculate sum
		 *  		- append sum to result_sum node
		 *  		- calculate carry 
		 *  pass back result_sum node AND carry back to previous stack item
		 *  
		 */
		
		Result res;
		
		int l1 = len(h1);
		int l2 = len(h2);
		
		int diff = Math.abs(l2-l1);
		
		if(diff!=0) {
			if(l1> l2) {
				h2 = appendZeroes(h2, diff);
			}else {
				h1 = appendZeroes(h1, diff);
			}
		}
		
		res = AddListsHelper(h1, h2);
		if(res.carry == 0) {
			return res.result_sum;
		}else {
			Node newNode = new Node(res.carry);
			newNode.next = res.result_sum;
			return newNode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbersLinkedListRecursively obj = new AddTwoNumbersLinkedListRecursively();
		
		LinkedList list = new LinkedList();
		 
        // creating first list
        list.head = new Node(7);
        list.head.next = new Node(5);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(6);
        
        
        // creating seconnd list
        LinkedList list2 = new LinkedList();
        list2.head = new Node(8);
        list2.head.next = new Node(4);
        
        LinkedList res = new LinkedList();
        res.head = obj.addTwoListsRecursively(list.head, list2.head);
        res.printLinkedList();

	}

}
