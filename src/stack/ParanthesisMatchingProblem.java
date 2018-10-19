package stack;
/*
 * Testcas1: Opening parenthesis extra -> " () ( () ()"   -> Stack is not empty at end
 * Testcase2: Closing parenthesis extra -> " ()() ) ()" -> Stack is empty when processing closing bracket
 * Testcase3: Mismatch between closing and opening parenthesis type : " () (} {} " ->  in this case popped opening parenthesis type
 *  will not match closing parenthesis type 
 * 
 * 
 * 
 * Given index of opening parenthesis find closing parenthesis index
 */

import java.util.Stack;

public class ParanthesisMatchingProblem {
	
	boolean isParanthesisValid(char[] arr) {
		
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0; i<arr.length; i++) {
			//System.out.println("i = " + i);
			if(arr[i]=='{' || arr[i]== '(' || arr[i]=='[') {
				st.push(arr[i]);
			}
			
			
			
			if(arr[i]=='}' || arr[i]== ')' || arr[i]==']') {
				if(st.empty()) {
					System.out.println("Extra closing parenthesis found at index = " + i);
					return false;
				}
				char stackTop = st.pop();
				if( (arr[i] == ')' && stackTop == '(') || (arr[i] == '}' && stackTop == '{') || (arr[i] == ']' && stackTop == '[') ) {
					//System.out.println(st);
					continue;
				}
				else{
					System.out.println("Type mismatch for closing parenthesis at index = " + i);
					return false;
				}
				
			}
			
			//System.out.println(st);
		}
		
		if(!st.isEmpty()) {
			System.out.println("Extra open parenthesis found");
			return false;
		}
		
		return true;
	}

	
	int closingParenthesisIndex(char[] arr, int openingParenthesisIndex) {
		char closingParenthesis = '\0';
		int count = 1;
		if(arr[openingParenthesisIndex] == '(') {
			closingParenthesis = ')';
		}else if(arr[openingParenthesisIndex] == '{') {
			closingParenthesis = '}';
		}else if(arr[openingParenthesisIndex] == '[') {
			closingParenthesis = ']';
		}else{
			return -1;
		}
		
		
		for(int i=openingParenthesisIndex+1; i<arr.length; i++) {
			if(arr[i]=='[' || arr[i]=='(' || arr[i]=='{') {
				count++;
			}else if(arr[i]==']' || arr[i]==')' || arr[i]=='}'){
				count = count-1;
			}
			
			if(count==0 && arr[i] == closingParenthesis)
				return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		ParanthesisMatchingProblem obj = new ParanthesisMatchingProblem();
		String str = "{ (()()) () ()}";
		boolean res = obj.isParanthesisValid(str.toCharArray());
		System.out.println("Matching parenthesis  = " + res);
		
		int closingParenthesisIndex = obj.closingParenthesisIndex(str.toCharArray(), 2);
		System.out.println("closingParenthesisIndex = " + closingParenthesisIndex);
	}
}
