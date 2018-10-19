package linkedlist;


/*
 *    http://geeksquiz.com/search-an-element-in-a-linked-list-iterative-and-recursive/
 */

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	Node() {
		this.data = -1;
		this.next = null;
	}
}


class LinkedList {
	Node head;
	
	// push in front of linked list
	public void push(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	
	public void printLinkedList() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
	}
	
	public  void printLinkedListFromGivenNode(Node head) {
		while(head!= null) {
			System.out.println(head.data + ", ");
			head = head.next;
		}
	}
	
	
	
	
	
}

public class LinkedListSearch {
	
	
	public boolean search(Node head, int data) {
		Node curr = head;
		while(curr!=null) {
			if(curr.data == data) {
				return true;
			}
			curr = curr.next;
		}
		
		return false;
	}
	
	public boolean searchRecursive(Node head, int data) {
		if(head == null) {
			return false;
		} else if(head.data == data) {
			return true;
		}else {
			return searchRecursive(head.next, data);
		}
		
		/*Node curr = head;
		while(curr!=null) {
			if(curr.data == data) {
				return true;
			}
			curr = curr.next;
		}
		
		return false;*/
	}
	
	
	public static void main(String args[])
    {
 
		LinkedListSearch obj = new LinkedListSearch();
        //Start with the empty list
        LinkedList llist = new LinkedList();
 
        /*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);
        
        llist.printLinkedList();
 
        if (obj.search(llist.head, 211))
            System.out.println("Yes");
        else
            System.out.println("No");
        
        if (obj.searchRecursive(llist.head, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }


}
