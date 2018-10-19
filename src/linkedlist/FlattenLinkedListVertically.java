package linkedlist;

//Java program for flattening a Linked List
class FlattenLinkedListVertically
{
 Node head;  // head of list
 Node last;

 /* Linked list Node*/
 class Node
 {
     int data;
     Node right, down;
     Node(int data)
     {
         this.data = data;
         right = null;
         down = null;
     }
 }

 

 Node flattenVertically(Node head)
 {
	if(head==null) {
		return null;
	}
	
	last = head;
	Node temp_right = head.right;
	
	if(head.down !=null) {
		head.right = flattenVertically(head.down);
	}
	
	if(temp_right !=null) {
		last.right = flattenVertically(temp_right);
	}
	
	return head;
 }

 /* Utility function to insert a node at begining of the
    linked list */
 Node push(Node head_ref, int data)
 {
     /* 1 & 2: Allocate the Node &
               Put in the data*/
     Node new_node = new Node(data);

     /* 3. Make next of new Node as head */
     new_node.down = head_ref;

     /* 4. Move the head to point to new Node */
     head_ref = new_node;

     /*5. return to link it back */
     return head_ref;
 }

 void printList()
 {
     Node temp = head;
     while (temp != null)
     {
         System.out.print(temp.data + " ");
         temp = temp.right;
     }
     System.out.println();
 }

 /* Drier program to test above functions */
 public static void main(String args[])
 {
	 FlattenLinkedListVertically L = new FlattenLinkedListVertically();

     /* Let us create the following linked list
         5 -> 			
         |    			
         V    			
         7 -> 18    	
         |     |     	
         V     v     	
               190
         8 -> 19        

         |              
         V              
         30              
         
     */

     L.head = L.push(L.head, 30);
     L.head = L.push(L.head, 8);
     L.head = L.push(L.head, 7);
     L.head = L.push(L.head, 5);
     L.head.down.right = L.push(L.head.down.right,  18);
     L.head.down.down.right = L.push(L.head.down.down.right,  19);
     
     L.head.down.right.down = L.push(L.head.down.right.down, 190);

    

     // flatten the list
     L.head = L.flattenVertically(L.head);

     L.printList();
 }
} /* This code is contributed by Rajat Mishra */