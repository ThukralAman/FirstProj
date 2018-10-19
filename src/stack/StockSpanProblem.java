package stack;

import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 * 
 * The Stock Span Problem
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to 
calculate span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the 
maximum number of consecutive days just before the given day, 
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}


In my words you have to find current day is stock's high for last how many days. Like it is said today is 52 week high,
 it means that for the last 52 weeks stock's value has been <= to current day's value.
 */



public class StockSpanProblem {
	
	int[] calculateStockSpan(int[] arr) {
		int S[] = new int[arr.length];
		S[0] = 1;
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		
		for(int i=1; i<arr.length; i++) {
			
			while(!st.empty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			
			S[i] = (st.empty())? (i+1) : (i-st.peek());
			
			st.push(i);
			
		}
		
		return S;
	}

	public static void main(String[] args) {
		StockSpanProblem obj = new StockSpanProblem();
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		int res[] = obj.calculateStockSpan(arr);
		
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}
