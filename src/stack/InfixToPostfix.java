package stack;

import java.util.Stack;

/* http://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 * 
 * Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the 
stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is 
less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty. -> for this step (consider case a+b*c)
 * 
 * given infix notation -> a+b*(c^d-e)^(f+g*h)-i --> abcd^e-fgh*+^*+i-                ab (((c^d)-e) ^ (f + (g*h)))
 * stack: +												(a + (b*(((c^d)-e)^(f+(g*h)))))-i  
 * convert it to postfix 
 *  
 *  if operand -> add to result string
 *  if operator -> check on stack if operator is there with higher precedence 
 * 
 */



public class InfixToPostfix {
	
	int getPrecedence(Character ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		
		case '*':
		case '/':
			return 2;
			
		case '^':
			return 3;
		default:
			return -1;
		}
	}
	
	String infixToPostfix(String exp) {
		String result = "";
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<exp.length(); i++) {
			Character ch = exp.charAt(i);
			
			if(Character.isLetterOrDigit(ch)) {
				result += ch;
			}else if(ch == '(') {
				st.push(ch);
			}else if(ch == ')') {
				while(!st.empty() && st.peek()!='(') {
					result += st.pop();
				}
				if(st.empty()) {
					System.out.println("Invalid infix expression!!");
				}else{
					st.pop();
				}
			}else{
				while(!st.empty() && getPrecedence(ch) <= getPrecedence(st.peek()) ) {
					result += st.pop();
				}
				st.push(ch);
			}
			
		}
		
		while(!st.empty()) {
			result += st.pop();
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixToPostfix obj = new InfixToPostfix();

		//String exp = "a+b*(c^d-e)^(f+g*h)-i";
		String exp = "a*b+c";
		String posfixExp = obj.infixToPostfix(exp);
		System.out.println("postfixExp =  " + posfixExp);
	}

}
