package learncollections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LearnPriorityQueue {
	
	static class PQSort implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			if(two-one > 0){
				return 1;
			}else{
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 2, 8, 3, 10};
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		for(int i : arr) {
			pq1.offer(i);
		}
		
		System.out.println(pq1);
		System.out.println(pq1.size());
		
		//pq1.p
		
		for(int i=0; i<arr.length; i++) {
			//System.out.println("i = " + i);
			System.out.println(pq1.poll());
		}
		
		PQSort sorter = new PQSort();
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, sorter);
		for(int i : arr) {
			pq2.offer(i);
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(pq2.poll());
		}
		

		
	}

}
