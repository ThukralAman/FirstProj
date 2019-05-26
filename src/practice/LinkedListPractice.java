package practice;

/**
 * Created by amthukra on 2/28/2019.
 */
<<<<<<< HEAD
public class LinkedListPractice {
}
=======
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

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
}
public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node node = new Node(10);
        ll.push(10);
        ll.push(20);
        ll.push(30);
        ll.push(40);
        new LinkedListPractice().printLL(ll);
        new LinkedListPractice().insertAt(3 , 11, ll);
        new LinkedListPractice().printLL(ll);
        new LinkedListPractice().deleteAt(5, ll);
        new LinkedListPractice().printLL(ll);

    }

    public void printLL(LinkedList ll) {
        System.out.println("--- Printing LL -------- ");
        Node curr = ll.head;
        while(curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    // assuming head is at pos=1
    public void insertAt(int pos, int data, LinkedList ll) {
        Node newNode = new Node(data);

        Node temp = ll.head;

        if(pos==1) {
            newNode.next = temp;
            ll.head = newNode;
            return;
        }

        while(temp.next!=null && pos-2 != 0) {
            temp = temp.next;
            pos = pos-1;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAt(int pos, LinkedList ll) {
        Node temp = ll.head;

        if(pos==1) {
            ll.head = temp.next;
            temp = null;
            return;
        }

        for(int i=1; i<= pos-2; i++) {
            temp = temp.next;
        }

        Node nodeToDelete = temp.next;
        temp.next = temp.next.next;
        nodeToDelete = null;
    }


}

>>>>>>> master
