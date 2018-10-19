package linkedlist;

/*package whatever //do not write package name here */

import java.io.*;

public class LinkedList1 {
    
    Node head;
    
     public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
     }
    
	public static void main (String[] args) {
	    
	    LinkedList1 split1 = new LinkedList1();
	    
        split1.head = new Node(0,null);
        split1.head.next = new Node(1,null);
        split1.head.next.next = new Node(0,null);
        //split1.head.next.next.next = new Node(1,null);
        //split1.head.next.next.next.next = new Node(0,null);
        //split1.head.next.next.next.next.next = new Node(1,null);
        
        //Print Original List
        System.out.print("Original List : ");
        Node travese = split1.head;
        while( travese != null){
            System.out.print(travese.data+"->");
            travese =travese.next;
        }
        System.out.print("null");
        
        
        //Split the lists alternate.
        LinkedList1 split2 = alternatingSplit(split1);
        
        //Print split1
        System.out.println();
        System.out.print("Split1 : ");
        while(split1.head != null){
            System.out.print(split1.head.data+"->");
            split1.head =split1.head.next;
        }
        System.out.print("null");
        
        
        
        //Print Split2
        System.out.println();
        System.out.print("Split2 : ");
        while(split2 != null && split2.head !=null){
            System.out.print(split2.head.data+"->");
            split2.head =split2.head.next;
        }
        System.out.print("null");
	}
	
	private static void addNode(int data, LinkedList1 lst) {
        if (lst.head == null) {
            lst.head = new Node(data, null);
        } else {
            Node node = lst.head;
            while (node.next != null) {
                node = node.next;
            }
            Node newNode = new Node(data, null);
            node.next = newNode;
        }
    }
	
	
	private static LinkedList1 alternatingSplit(LinkedList1 list){
        Node p1 = list.head;

        if (p1 == null)
            return null;

        Node a1 = p1.next;

        LinkedList1 altList = new LinkedList1();
        altList.head = a1;

        while (p1 != null && a1 != null) {
            //System.out.println("p1 = " + p1.data + " a1 = " + a1.data);
            p1.next = a1.next;
            p1 = p1.next;

            if (p1 != null)
                a1.next = p1.next;
            else
                a1.next = p1;

            a1 = a1.next;
            
            //System.out.println("p1 = " + p1.data + " a1 = " + a1.data);
        }
        return altList;
    }
    
}