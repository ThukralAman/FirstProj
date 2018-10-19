package stack;

public class StackUsinglinkedList {
	StackNode top=null;
	
	
	static class StackNode {
		int data;
		StackNode next;
		
		StackNode(int data) {
			this.data = data;
			this.next = null;
		}
		
		StackNode() {
		}
	}
	
	public void push(int data) {
		StackNode temp = new StackNode(data);
		temp.next = top;
		top = temp;
	}
	
	public int pop() {
		int val = top.data;
		top = top.next;
		return val;
	}
	
	public void printStack() {
		StackNode temp = top;
		while(temp!=null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		StackUsinglinkedList st = new StackUsinglinkedList();
		if(st.top == null) {
			System.out.println("null hai");
		}
		st.push(10);
		st.push(20);
		st.push(30);
		System.out.println(st.pop());
		st.printStack();
	}
}
